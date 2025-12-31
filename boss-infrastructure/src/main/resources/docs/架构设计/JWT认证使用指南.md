# JWT 认证使用指南

## 📋 概述

本项目使用 **JWT（JSON Web Token）** + **拦截器（HandlerInterceptor）** 实现统一的用户认证机制。

### 技术特性

- ✅ **基于注解的认证**：使用 `@JWT` 注解标记需要认证的接口
- ✅ **JDK 17 特性优化**：充分利用现代 Java 特性
  - Pattern Matching for instanceof（模式匹配）
  - `var` 关键字简化变量声明
  - `Optional` 链式调用优化 null 处理
  - 方法提取提高代码可读性
- ✅ **灵活的认证策略**：支持必需认证和可选认证
- ✅ **用户上下文管理**：ThreadLocal 存储当前用户信息

### 核心组件

| 组件 | 位置 | 作用 |
|------|------|------|
| `JwtConfig` | `infrastructure/config` | JWT配置类（统一管理JWT配置） |
| `JwtTokenProvider` | `infrastructure/security` | JWT工具类（生成、解析、验证Token，使用JDK17特性优化） |
| `JwtAuthInterceptor` | `infrastructure/security` | JWT认证拦截器（基于注解，使用JDK17特性优化） |
| `@JWT` | `infrastructure/annotation` | JWT认证注解（标记需要认证的接口） |
| `@SkipJWT` | `infrastructure/annotation` | 跳过JWT认证注解（优先级高于@JWT，标记不需要认证的接口） |
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

**基于注解的认证机制**：拦截器只对标记了 `@JWT` 注解的接口进行Token验证。

- 默认拦截所有 `/api/**` 路径
- 拦截器内部会检查方法或类上是否有 `@JWT` 注解
- **只有标记了 `@JWT` 注解的接口才会进行Token验证**
- 未标记 `@JWT` 注解的接口直接放行，无需认证

**排除路径**（这些路径不会被拦截器处理）：
- `/doc.html` - Knife4j文档
- `/swagger-ui/**` - Swagger UI
- `/actuator/**` - 健康检查
- `/static/**` - 静态资源

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

### 使用 @JWT 注解进行认证

**方式1: 在方法上标记（推荐）**

```java
@JWT
@Operation(summary = "创建订单", description = "创建新订单")
@PostMapping("/orders")
public HttpResponseEntity<OrderVO> createOrder(@RequestBody OrderCreateCmd cmd) {
    // 该接口需要JWT认证
    var currentUser = SecurityContextHolder.getCurrentUser();
    // ... 业务逻辑
    return HttpResponseEntity.success(orderVO);
}
```

**方式2: 在类上标记（整个Controller都需要认证）**

```java
@JWT
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    @PostMapping
    public HttpResponseEntity<OrderVO> createOrder() {
        // 该接口需要JWT认证
    }
    
    @GetMapping("/{id}")
    public HttpResponseEntity<OrderVO> getOrder(@PathVariable Long id) {
        // 该接口也需要JWT认证
    }
}
```

**方式3: 可选认证（required=false）**

```java
@JWT(required = false)
@GetMapping("/public-info")
public HttpResponseEntity<PublicInfoVO> getPublicInfo() {
    // 如果提供了Token，会解析并设置用户信息
    // 如果没有Token，也会放行
    var user = SecurityContextHolder.getCurrentUser();
    if (user != null) {
        // 已登录用户，返回个性化信息
    } else {
        // 未登录用户，返回通用信息
    }
    return HttpResponseEntity.success(vo);
}
```

**注意**: 
- 未标记 `@JWT` 注解的接口**不需要认证**，直接放行
- 标记了 `@JWT` 注解的接口**必须提供有效的Token**
- `required=false` 时，即使没有Token也会放行，但会尝试解析Token获取用户信息

### 使用 @SkipJWT 注解跳过认证

**使用场景**：当类上标记了 `@JWT`，但某些方法（如登录、注册）不需要认证时，可以使用 `@SkipJWT`。

**优先级规则**：`@SkipJWT` > `@JWT`
- 如果方法上同时标记了 `@JWT` 和 `@SkipJWT`，`@SkipJWT` 优先级更高
- 如果类上标记了 `@JWT`，但方法上标记了 `@SkipJWT`，该方法不需要认证

**示例1: 类上标记 @JWT，方法上标记 @SkipJWT**

```java
@JWT  // 整个Controller默认需要认证
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    @SkipJWT("登录接口，无需认证")
    @PostMapping("/login")
    public HttpResponseEntity<String> login() {
        // 该方法不需要认证（即使类上标记了 @JWT）
    }
    
    @PostMapping
    public HttpResponseEntity<OrderVO> createOrder() {
        // 该方法需要认证（继承类上的 @JWT）
    }
}
```

**示例2: 明确标记跳过认证（作为文档说明）**

```java
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    
    @SkipJWT("登录接口，无需认证")
    @PostMapping("/login")
    public HttpResponseEntity<LoginVO> login(@RequestBody LoginCmd cmd) {
        // 明确标记不需要认证，即使没有 @JWT 也会跳过
    }
    
    @SkipJWT("注册接口，无需认证")
    @PostMapping("/register")
    public HttpResponseEntity<String> register(@RequestBody RegisterCmd cmd) {
        // 明确标记不需要认证
    }
}
```

### 获取当前登录用户

在需要认证的接口中，通过 `SecurityContextHolder` 获取当前用户：

```java
@JWT
@GetMapping("/my-info")
public HttpResponseEntity<UserInfoVO> getMyInfo() {
    // 方式1: 获取完整用户对象（使用 var 关键字）
    var currentUser = SecurityContextHolder.getCurrentUser();
    
    // 方式2: 只获取用户ID
    var userId = SecurityContextHolder.getCurrentUserId();
    
    // 方式3: 判断是否已登录
    var isAuthenticated = SecurityContextHolder.isAuthenticated();
    
    // ... 业务逻辑
    return HttpResponseEntity.ok(vo);
}
```

### 生成Token

在登录成功后生成Token（使用 JDK 17 特性）：

```java
@RequiredArgsConstructor
public class AuthService {
    
    private final JwtTokenProvider jwtTokenProvider;
    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;
    
    public String doLogin(String username, String password) {
        // 1. 验证用户名密码
        var user = userService.authenticate(username, password);
        
        // 2. 构造Token Payload（可选，放入一些基本信息）
        var payload = Map.of(
            "username", user.getUsername(),
            "realName", user.getRealName(),
            "role", user.getRole()
        );
        
        // 3. 生成Token
        var token = jwtTokenProvider.generateToken(user.getUserId(), payload);
        
        // 4. （可选）将用户信息存入Redis
        var userKey = "boss_user:" + user.getUserId();
        try {
            var userJson = objectMapper.writeValueAsString(user);
            redisTemplate.opsForValue().set(userKey, userJson, 8, TimeUnit.HOURS);
        } catch (Exception e) {
            log.warn("保存用户信息到Redis失败", e);
        }
        
        return token;
    }
}
```

**说明**：
- 使用 `var` 关键字简化变量声明
- 使用 `Map.of()` 创建不可变 Map（JDK 9+）
- 使用 `@RequiredArgsConstructor` 进行构造器注入

### 刷新Token

当Token即将过期时，可以刷新Token：

```java
@JWT
@PostMapping("/refresh")
public HttpResponseEntity<String> refreshToken(@RequestHeader("Authorization") String authorization) {
    var oldToken = authorization.replace("Bearer ", "");
    
    // 解析旧Token获取用户ID
    var userId = jwtTokenProvider.getUserIdFromToken(oldToken);
    
    // 生成新Token
    var newToken = jwtTokenProvider.generateToken(userId, null);
    
    return HttpResponseEntity.ok(newToken);
}
```

---

## 🎯 实现细节

### JDK 17 特性应用

#### 1. Pattern Matching for instanceof

拦截器中使用模式匹配简化类型检查和转换：

```java
// 优化前
if (!(handler instanceof HandlerMethod)) {
    return true;
}
HandlerMethod handlerMethod = (HandlerMethod) handler;

// 优化后（JDK 16+）
if (!(handler instanceof HandlerMethod handlerMethod)) {
    return true;
}
// handlerMethod 可直接使用，无需强制转换
```

#### 2. var 关键字

简化局部变量声明，提高代码可读性：

```java
// 优化前
String token = extractToken(request);
Long userId = jwtTokenProvider.getUserIdFromToken(token);
CurrentUser currentUser = loadUserFromRedis(userId, token);

// 优化后
var token = extractToken(request);
var userId = jwtTokenProvider.getUserIdFromToken(token);
var currentUser = loadUserFromRedis(userId, token);
```

#### 3. Optional 链式调用

优化 null 处理，减少 NPE 风险：

```java
// 查找 @JWT 注解（方法优先，类次之）
private Optional<JWT> findJwtAnnotation(HandlerMethod handlerMethod) {
    var methodAnnotation = Optional.ofNullable(handlerMethod.getMethodAnnotation(JWT.class));
    return methodAnnotation.or(() -> Optional.ofNullable(handlerMethod.getBeanType().getAnnotation(JWT.class)));
}

// 使用 Optional 处理 null
Optional.ofNullable(payload)
        .filter(p -> !p.isEmpty())
        .ifPresent(builder::addClaims);
```

#### 4. 方法提取

将复杂逻辑拆分为职责单一的小方法，提高可读性和可维护性：

```java
// 主方法简洁清晰
public boolean preHandle(...) {
    if (!(handler instanceof HandlerMethod handlerMethod)) {
        return true;
    }
    var jwtAnnotation = findJwtAnnotation(handlerMethod);
    if (jwtAnnotation.isEmpty()) {
        return true;
    }
    var token = extractToken(request);
    if (token.isEmpty()) {
        return handleMissingToken(request, response, required);
    }
    return validateAndProcessToken(request, response, token.get(), required);
}

// 每个方法职责单一
private Optional<JWT> findJwtAnnotation(HandlerMethod handlerMethod) { ... }
private Optional<String> extractToken(HttpServletRequest request) { ... }
private boolean handleMissingToken(...) { ... }
private boolean validateAndProcessToken(...) { ... }
```

#### 5. 异常处理优化

合并处理相关异常，减少重复代码：

```java
// 合并处理格式相关异常
catch (UnsupportedJwtException | MalformedJwtException e) {
    var message = e instanceof UnsupportedJwtException 
        ? "不支持的 Token 格式" 
        : "Token 格式错误";
    throw new JwtAuthenticationException(message, e);
}
```

### 代码质量提升

| 优化项 | 说明 | 收益 |
|--------|------|------|
| **常量提取** | `USER_KEY_PREFIX`、`JSON_CONTENT_TYPE` | 便于维护，避免魔法字符串 |
| **方法拆分** | 将长方法拆分为小方法 | 提高可读性，便于测试 |
| **Optional 使用** | 统一使用 Optional 处理 null | 减少 NPE，代码更安全 |
| **var 关键字** | 简化变量声明 | 代码更简洁 |
| **Pattern Matching** | 简化类型检查 | 代码更优雅 |

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
        var userId = 10001L;
        var token = jwtTokenProvider.generateToken(userId, null);
        
        assertNotNull(token);
        assertTrue(jwtTokenProvider.validateToken(token));
        
        var parsedUserId = jwtTokenProvider.getUserIdFromToken(token);
        assertEquals(userId, parsedUserId);
    }
    
    @Test
    void testGenerateTokenWithPayload() {
        var userId = 10001L;
        var payload = Map.of(
            "username", "admin",
            "role", "admin"
        );
        var token = jwtTokenProvider.generateToken(userId, payload);
        
        assertNotNull(token);
        var claims = jwtTokenProvider.parseToken(token);
        assertEquals("admin", claims.get("username"));
    }
}
```

---

## 🐛 常见问题

### Q1: Token验证失败，提示"Token签名验证失败"

**原因**: JWT密钥不一致
**解决**: 检查 `application.yml` 中的 `jwt.secret` 配置

### Q2: 拦截器没有生效，所有接口都能访问

**原因**: 
1. 接口未标记 `@JWT` 注解（默认不需要认证）
2. 接口标记了 `@SkipJWT` 注解
3. 拦截路径配置错误

**解决**: 
- 检查接口是否标记了 `@JWT` 注解
- 检查是否误标记了 `@SkipJWT` 注解
- 检查 `WebMvcConfig` 中的 `addPathPatterns` 配置

### Q2.1: 类上标记了 @JWT，但某个方法不需要认证怎么办？

**解决**: 在该方法上标记 `@SkipJWT` 注解：

```java
@JWT
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    @SkipJWT("公开接口，无需认证")
    @GetMapping("/public")
    public HttpResponseEntity<String> publicApi() {
        // 该方法不需要认证
    }
}
```

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

---

## 📝 更新日志

### 2025-12-25
- ✨ 实现基于 `@JWT` 注解的认证机制
- ✨ 新增 `@SkipJWT` 注解，支持跳过认证（优先级高于 `@JWT`）
- 🚀 使用 JDK 17 特性优化代码
  - Pattern Matching for instanceof
  - var 关键字简化变量声明
  - Optional 链式调用优化 null 处理
  - 方法提取提高代码可读性
- 📚 更新文档，添加 JDK 17 特性说明和使用示例
- 🔄 将 `@SkipAuth` 重命名为 `@SkipJWT`（更明确的命名）

---

**最后更新**: 2025-12-25  
**作者**: @xiangshang  
**JDK 版本**: 17+

