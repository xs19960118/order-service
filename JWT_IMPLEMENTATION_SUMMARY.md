# 🔐 JWT 认证拦截器实现总结

## ✅ 已完成的工作

### 1. 核心组件实现

| 组件 | 文件路径 | 说明 |
|------|----------|------|
| **JWT配置类** | `boss-infrastructure/security/JwtProperties.java` | 管理JWT配置（密钥、算法、过期时间等） |
| **JWT工具类** | `boss-infrastructure/security/JwtTokenProvider.java` | 负责Token的生成、解析、验证 |
| **JWT异常类** | `boss-infrastructure/security/JwtAuthenticationException.java` | 自定义JWT认证异常 |
| **用户上下文** | `boss-infrastructure/security/SecurityContextHolder.java` | ThreadLocal存储当前用户信息 |
| **JWT拦截器** | `boss-infrastructure/security/JwtAuthInterceptor.java` | 拦截请求验证Token |
| **拦截器配置** | `boss-infrastructure/config/WebMvcConfig.java` | 配置拦截路径和排除路径 |
| **跳过认证注解** | `boss-infrastructure/security/SkipAuth.java` | 标记无需认证的接口 |
| **用户领域模型** | `boss-domain/user/model/CurrentUser.java` | 当前登录用户领域对象 |

### 2. 示例Controller

| Controller | 说明 |
|------------|------|
| `AuthController.java` | 登录、注册等认证接口（演示Token生成） |
| `UserInfoController.java` | 用户信息接口（演示如何获取当前用户） |

### 3. 配置文件更新

- ✅ `boss-start/src/main/resources/application.yml` - 添加JWT配置
- ✅ `boss-infrastructure/build.gradle` - 添加JJWT依赖

### 4. 文档

- ✅ `JWT认证使用指南.md` - 完整的使用文档

---

## 🏗️ 架构设计

```
┌─────────────────────────────────────────────────────────────┐
│                        客户端请求                              │
│          POST /api/v1/auth/login (无需认证)                   │
│          GET /api/v1/user/current (需要认证)                  │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│                  Spring DispatcherServlet                    │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│              JwtAuthInterceptor (拦截器)                      │
│  1. 检查请求路径是否在排除列表                                  │
│  2. 从请求头提取Token (Authorization: Bearer xxx)             │
│  3. 验证Token签名和过期时间                                    │
│  4. 解析Token获取用户ID                                       │
│  5. 从Redis加载用户信息（可选）                                │
│  6. 将用户信息放入SecurityContextHolder                       │
└────────────────────────┬────────────────────────────────────┘
                         │
                 ┌───────┴───────┐
                 │               │
                 ▼               ▼
         验证成功 ✅         验证失败 ❌
                 │               │
                 │               ▼
                 │      返回401未授权
                 │
                 ▼
┌─────────────────────────────────────────────────────────────┐
│                    Controller处理                             │
│  SecurityContextHolder.getCurrentUser() 获取当前用户          │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│                    返回响应                                   │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│            afterCompletion (清除ThreadLocal)                 │
│              SecurityContextHolder.clear()                   │
└─────────────────────────────────────────────────────────────┘
```

---

## 🎯 核心特性

### 1. JWT配置（符合你的要求）

```yaml
jwt:
  secret: LO5MJI7re0TrFKjJY80QJYntsYgEDOOY  # 你提供的密钥
  algo: HS256                               # HS256算法
  expire: 28800                             # 8小时过期
  header: Authorization
  prefix: "Bearer "
```

### 2. 拦截器配置

- **拦截路径**: `/api/**`（所有业务接口）
- **排除路径**: 
  - `/api/v1/auth/*` (登录、注册)
  - `/test/**` (测试接口)
  - `/doc.html` (Swagger文档)
  - `/actuator/**` (健康检查)

### 3. 用户上下文管理

使用ThreadLocal存储当前请求的用户信息，确保线程安全：

```java
// 设置用户
SecurityContextHolder.setCurrentUser(currentUser);

// 获取用户
CurrentUser user = SecurityContextHolder.getCurrentUser();
Long userId = SecurityContextHolder.getCurrentUserId();

// 清除上下文（拦截器自动调用）
SecurityContextHolder.clear();
```

### 4. Redis集成（可选）

支持从Redis加载用户信息缓存：
- Key格式: `boss_user:{userId}`
- 过期时间: 与Token一致（8小时）

### 5. 符合DDD架构

- **领域层**: `CurrentUser` 领域模型
- **基础设施层**: JWT工具类、拦截器、配置
- **接口层**: Controller使用`SecurityContextHolder`获取用户

---

## 🚀 使用示例

### 1. 登录获取Token

```bash
curl -X POST http://localhost:8088/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"123456"}'
```

**响应**:
```json
{
  "code": 200,
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "userId": 10001,
    "username": "admin",
    "expireIn": 28800
  }
}
```

### 2. 携带Token访问接口

```bash
curl -X GET http://localhost:8088/api/v1/user/current \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9..."
```

### 3. 在Controller中获取当前用户

```java
@GetMapping("/my-order")
public HttpResponseEntity<List<OrderVO>> getMyOrders() {
    // 获取当前用户ID
    Long userId = SecurityContextHolder.getCurrentUserId();
    
    // 查询订单
    List<OrderVO> orders = orderService.getOrdersByUserId(userId);
    
    return HttpResponseEntity.ok(orders);
}
```

### 4. 跳过认证（可选）

```java
@SkipAuth("公开接口，无需认证")
@GetMapping("/public-data")
public HttpResponseEntity<String> getPublicData() {
    return HttpResponseEntity.ok("公开数据");
}
```

---

## 📦 依赖清单

已在 `boss-infrastructure/build.gradle` 中添加：

```gradle
// JWT 依赖
implementation 'io.jsonwebtoken:jjwt-api:0.12.3'
runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.12.3'
runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.12.3'

// Jackson（JSON 序列化）
implementation 'com.fasterxml.jackson.core:jackson-databind'
```

---

## 🧪 测试步骤

### 1. 启动项目

```bash
./gradlew :boss-start:bootRun
```

### 2. 访问Swagger文档

打开浏览器访问: http://localhost:8088/doc.html

### 3. 测试登录接口

在Swagger中找到 **认证管理 > 用户登录**，点击"试一试"：

**请求参数**:
```json
{
  "username": "admin",
  "password": "123456"
}
```

**复制返回的 `token`**

### 4. 测试需要认证的接口

在Swagger中找到 **用户管理 > 获取当前用户信息**，点击"试一试"：

- 在右上角"Authorize"按钮点击
- 输入: `Bearer {刚才复制的token}`
- 点击"Authorize"确认

然后调用接口，应该能返回用户信息。

### 5. 测试未携带Token

不设置Authorization，直接调用接口，应该返回：

```json
{
  "code": 401,
  "message": "未提供认证Token"
}
```

---

## 🔧 后续工作（可选）

### 1. 集成真实用户表

修改 `AuthController.login()` 方法，查询数据库验证用户：

```java
@Autowired
private UserService userService;

@PostMapping("/login")
public HttpResponseEntity<LoginVO> login(@RequestBody LoginCmd cmd) {
    // 1. 验证用户名密码
    User user = userService.authenticate(cmd.getUsername(), cmd.getPassword());
    if (user == null) {
        return HttpResponseEntity.fail("用户名或密码错误");
    }
    
    // 2. 生成Token
    String token = jwtTokenProvider.generateToken(user.getId(), null);
    
    // 3. 缓存用户信息到Redis
    stringRedisTemplate.opsForValue().set(
        "boss_user:" + user.getId(),
        JSON.toJSONString(user),
        28800, TimeUnit.SECONDS
    );
    
    // 4. 返回Token
    LoginVO vo = new LoginVO();
    vo.setToken(token);
    vo.setUserId(user.getId());
    vo.setUsername(user.getUsername());
    vo.setExpireIn(28800L);
    
    return HttpResponseEntity.ok(vo);
}
```

### 2. 实现登出功能

使用Redis黑名单机制：

```java
@PostMapping("/logout")
public HttpResponseEntity<String> logout(@RequestHeader("Authorization") String authorization) {
    String token = authorization.replace("Bearer ", "");
    
    // 将Token加入黑名单
    stringRedisTemplate.opsForValue().set(
        "boss_token_blacklist:" + token,
        "1",
        28800, TimeUnit.SECONDS
    );
    
    return HttpResponseEntity.ok("登出成功");
}
```

并在拦截器中检查黑名单：

```java
// JwtAuthInterceptor.preHandle() 中添加
String blacklistKey = "boss_token_blacklist:" + token;
if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(blacklistKey))) {
    return unauthorizedResponse(response, "Token已失效");
}
```

### 3. 实现权限控制

创建 `@RequireRole` 注解 + AOP切面：

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireRole {
    String[] value(); // 允许的角色
}

@Aspect
@Component
public class RoleCheckAspect {
    
    @Before("@annotation(requireRole)")
    public void checkRole(RequireRole requireRole) {
        CurrentUser user = SecurityContextHolder.getCurrentUser();
        String[] allowedRoles = requireRole.value();
        
        if (!Arrays.asList(allowedRoles).contains(user.getRole())) {
            throw new ForbiddenException("无权限访问");
        }
    }
}
```

使用：

```java
@RequireRole({"admin", "manager"})
@DeleteMapping("/user/{id}")
public HttpResponseEntity<String> deleteUser(@PathVariable Long id) {
    // 只有admin和manager角色可以访问
    return HttpResponseEntity.ok("删除成功");
}
```

### 4. Token刷新机制

实现短期AccessToken + 长期RefreshToken：

- AccessToken: 1-2小时
- RefreshToken: 7-30天，存储在服务端

### 5. 多端登录控制

- 单端登录: Redis存储 `user:{userId}:token`，登录时踢掉旧Token
- 多端登录: Redis存储 `user:{userId}:tokens:{deviceId}`

---

## ⚠️ 注意事项

### 1. 生产环境安全

- ✅ 修改JWT密钥（使用环境变量）
- ✅ 启用HTTPS
- ✅ 设置CORS白名单
- ✅ 限制登录频率（防暴力破解）

### 2. 性能优化

- ✅ 用户信息缓存到Redis（减少数据库查询）
- ✅ Token黑名单使用Redis（高性能）
- ✅ 拦截器只拦截必要路径

### 3. 异常处理

已实现统一401响应，可扩展全局异常处理：

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(JwtAuthenticationException.class)
    public HttpResponseEntity<Void> handleJwtException(JwtAuthenticationException e) {
        return HttpResponseEntity.fail(401, e.getMessage());
    }
}
```

---

## 📞 技术支持

如有问题，请查看：
- 📖 [JWT认证使用指南](boss-infrastructure/src/main/resources/docs/其它文档/JWT认证使用指南.md)
- 🌐 [JWT官方文档](https://jwt.io/)
- 📚 [JJWT GitHub](https://github.com/jwtk/jjwt)

---

**实现完成日期**: 2025-12-25  
**作者**: @xiangshang  
**架构**: DDD + JWT + HandlerInterceptor

