# JWT 认证使用指南

## 📋 概述

本项目使用 **JWT（JSON Web Token）** + **拦截器（HandlerInterceptor）** 实现统一的用户认证机制。

### 核心组件

| 组件 | 位置 | 作用 |
|------|------|------|
| `JwtProperties` | `infrastructure/security` | JWT配置属性（密钥、过期时间等） |
| `JwtTokenProvider` | `infrastructure/security` | JWT工具类（生成、解析、验证Token） |
| `JwtAuthInterceptor` | `infrastructure/security` | JWT认证拦截器（拦截请求验证Token） |
| `SecurityContextHolder` | `infrastructure/security` | 用户上下文（ThreadLocal存储当前用户） |
| `CurrentUser` | `domain/user/model` | 当前登录用户领域模型 |
| `WebMvcConfig` | `infrastructure/config` | 拦截器配置（配置拦截路径） |

---

## ⚙️ 配置说明

### application.yml

```yaml
jwt:
  secret: LO5MJI7re0TrFKjJY80QJYntsYgEDOOY  # JWT密钥（生产环境务必修改）
  algo: HS256                                # 签名算法
  expire: 28800                              # 过期时间（8小时，单位：秒）
  header: Authorization                      # Token请求头
  prefix: "Bearer "                          # Token前缀
```

### 拦截规则

默认拦截所有 `/api/**` 路径，以下路径**不拦截**：

- `/api/v1/auth/login` - 登录
- `/api/v1/auth/register` - 注册
- `/test/**` - 测试接口
- `/doc.html` - Knife4j文档
- `/actuator/**` - 健康检查

**修改拦截规则**: 编辑 `WebMvcConfig.addInterceptors()` 方法

---

## 🚀 快速开始

### 1. 登录获取Token

**请求示例**：

```bash
curl -X POST http://localhost:8088/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "123456"
  }'
```

**响应示例**：

```json
{
  "code": 200,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAwMSIsInVzZXJuYW1lIjoiYWRtaW4iLCJyb2xlIjoiYWRtaW4iLCJpYXQiOjE3MDM1MDAwMDAsImV4cCI6MTcwMzUyODgwMH0.xxx",
    "userId": 10001,
    "username": "admin",
    "expireIn": 28800
  }
}
```

### 2. 携带Token访问受保护接口

**请求示例**：

```bash
curl -X GET http://localhost:8088/api/v1/user/current \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9..."
```

**响应示例**：

```json
{
  "code": 200,
  "message": "success",
  "data": {
    "userId": 10001,
    "username": "admin",
    "realName": "张三",
    "mobile": "13800138000",
    "email": "admin@example.com",
    "role": "admin"
  }
}
```

### 3. Token验证失败响应

**未携带Token**：

```json
{
  "code": 401,
  "message": "未提供认证Token",
  "data": null
}
```

**Token过期**：

```json
{
  "code": 401,
  "message": "Token 已过期",
  "data": null
}
```

**Token签名错误**：

```json
{
  "code": 401,
  "message": "Token 签名验证失败",
  "data": null
}
```

---

## 💻 开发指南

### 跳过JWT认证

如果某个接口不需要认证，使用 `@SkipAuth` 注解：

```java
@SkipAuth("接口说明，无需认证")
@PostMapping("/public-api")
public HttpResponseEntity<String> publicApi() {
    return HttpResponseEntity.ok("无需认证的接口");
}
```

**注意**: 还需要在 `WebMvcConfig` 中配置排除路径！

### 获取当前登录用户

在需要认证的接口中，通过 `SecurityContextHolder` 获取当前用户：

```java
@GetMapping("/my-info")
public HttpResponseEntity<UserInfoVO> getMyInfo() {
    // 方式1: 获取完整用户对象
    CurrentUser currentUser = SecurityContextHolder.getCurrentUser();
    
    // 方式2: 只获取用户ID
    Long userId = SecurityContextHolder.getCurrentUserId();
    
    // 方式3: 判断是否已登录
    boolean isAuthenticated = SecurityContextHolder.isAuthenticated();
    
    // ... 业务逻辑
    return HttpResponseEntity.ok(vo);
}
```

### 生成Token

在登录成功后生成Token：

```java
@Autowired
private JwtTokenProvider jwtTokenProvider;

public String doLogin(String username, String password) {
    // 1. 验证用户名密码
    User user = userService.authenticate(username, password);
    
    // 2. 构造Token Payload（可选，放入一些基本信息）
    Map<String, Object> payload = new HashMap<>();
    payload.put("username", user.getUsername());
    payload.put("realName", user.getRealName());
    payload.put("role", user.getRole());
    
    // 3. 生成Token
    String token = jwtTokenProvider.generateToken(user.getUserId(), payload);
    
    // 4. （可选）将用户信息存入Redis
    String userKey = "boss_user:" + user.getUserId();
    redisTemplate.opsForValue().set(userKey, JSON.toJSONString(user), 8, TimeUnit.HOURS);
    
    return token;
}
```

### 刷新Token

当Token即将过期时，可以刷新Token：

```java
@PostMapping("/refresh")
public HttpResponseEntity<String> refreshToken(@RequestHeader("Authorization") String authorization) {
    String oldToken = authorization.replace("Bearer ", "");
    
    // 解析旧Token获取用户ID
    Long userId = jwtTokenProvider.getUserIdFromToken(oldToken);
    
    // 生成新Token
    String newToken = jjtTokenProvider.generateToken(userId, null);
    
    return HttpResponseEntity.ok(newToken);
}
```

---

## 🔐 安全建议

### 1. JWT密钥管理

- ⚠️ **生产环境务必修改默认密钥**
- 密钥长度至少 **32字符**
- 使用 **环境变量** 或 **配置中心** 管理密钥
- 定期轮换密钥（需要处理旧Token）

```yaml
# 使用环境变量
jwt:
  secret: ${JWT_SECRET:default-secret-key}
```

### 2. Token过期策略

- **短期Token（推荐）**: 2-8小时，安全性高
- **长期Token**: 24小时+，需配合刷新Token机制
- **刷新Token**: 使用独立的RefreshToken延长会话

### 3. Token存储

**客户端存储**：
- ✅ 推荐：`localStorage` 或 `sessionStorage`
- ❌ 不推荐：Cookie（容易CSRF攻击）

**服务端缓存**：
- 用户信息缓存到Redis，加速认证
- 缓存Key格式：`boss_user:{userId}`
- 过期时间与Token一致

### 4. HTTPS强制

⚠️ **生产环境必须使用HTTPS**，否则Token可能被中间人攻击窃取。

### 5. Token撤销

JWT本身无状态，无法主动撤销。解决方案：

**方案1: Token黑名单（Redis）**
```java
// 用户登出时，将Token加入黑名单
String tokenKey = "boss_token_blacklist:" + token;
redisTemplate.opsForValue().set(tokenKey, "1", 8, TimeUnit.HOURS);

// 拦截器中检查黑名单
Boolean isBlacklisted = redisTemplate.hasKey(tokenKey);
if (isBlacklisted) {
    return unauthorizedResponse(response, "Token已失效");
}
```

**方案2: 短期Token + 刷新机制**
- 访问Token过期时间短（1-2小时）
- 使用RefreshToken获取新的访问Token
- RefreshToken存储在服务端，可主动撤销

---

## 🧪 测试

### Postman测试

1. **登录获取Token**
   - URL: `POST http://localhost:8088/api/v1/auth/login`
   - Body: `{"username":"admin","password":"123456"}`
   - 复制返回的 `token`

2. **访问受保护接口**
   - URL: `GET http://localhost:8088/api/v1/user/current`
   - Headers: `Authorization: Bearer {token}`

### 单元测试

```java
@SpringBootTest
class JwtTokenProviderTest {
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Test
    void testGenerateAndParseToken() {
        Long userId = 10001L;
        String token = jwtTokenProvider.generateToken(userId, null);
        
        assertNotNull(token);
        assertTrue(jwtTokenProvider.validateToken(token));
        
        Long parsedUserId = jwtTokenProvider.getUserIdFromToken(token);
        assertEquals(userId, parsedUserId);
    }
}
```

---

## 🐛 常见问题

### Q1: Token验证失败，提示"Token签名验证失败"

**原因**: JWT密钥不一致
**解决**: 检查 `application.yml` 中的 `jwt.secret` 配置

### Q2: 拦截器没有生效，所有接口都能访问

**原因**: 拦截路径配置错误
**解决**: 检查 `WebMvcConfig` 中的 `addPathPatterns` 配置

### Q3: 获取当前用户返回 null

**原因**: 
1. 请求未携带Token
2. Token验证失败
3. ThreadLocal被清空

**解决**: 
- 确认请求头携带了正确的Token
- 查看日志确认Token验证结果

### Q4: Redis加载用户信息失败

**原因**: Redis中没有用户信息缓存
**解决**: 
- 在登录时将用户信息存入Redis
- 或在拦截器中从数据库查询用户信息

### Q5: 跨域请求Token验证失败

**原因**: 浏览器跨域预检请求（OPTIONS）被拦截
**解决**: 在拦截器中排除OPTIONS请求

```java
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    // 放行OPTIONS请求
    if ("OPTIONS".equals(request.getMethod())) {
        return true;
    }
    
    // ... 正常的Token验证逻辑
}
```

---

## 📚 参考资料

- [JWT官方网站](https://jwt.io/)
- [JJWT GitHub](https://github.com/jwtk/jjwt)
- [Spring Boot Interceptor文档](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-config-interceptors)

---

**最后更新**: 2025-12-25  
**作者**: @xiangshang

