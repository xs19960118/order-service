# 🏗️ DDD 架构说明

## 项目模块结构

```
boss/
├── boss-start/                    # 启动模块
│   └── 应用启动入口、配置文件
├── boss-interfaces/               # 接口层（用户接口层）
│   └── Controller、DTO、VO
├── boss-application/              # 应用层
│   └── 应用服务、编排业务流程
├── boss-domain/                   # 领域层（核心业务逻辑）
│   └── 领域模型、领域服务、仓储接口
└── boss-infrastructure/           # 基础设施层
    └── 数据持久化、外部服务调用、技术实现
```

## 模块依赖关系

```
boss-start
    ↓ (依赖所有模块)
┌───┴───┐
↓       ↓
boss-interfaces   boss-infrastructure
    ↓                   ↓
    └─────→ boss-application
                ↓
            boss-domain (核心，不依赖其他业务模块)            
```

```
interface层 → application层 → domain层 ← infrastructure层
（infrastructure层实现domain层定义的接口，依赖倒置）
```

## 各层职责

### 1. 接口层 (boss-interfaces)

**职责**: 
- 对外暴露 RESTful API
- 接收请求参数（DTO/Cmd/Qry）
- 返回响应数据（VO）
- 调用应用层服务

**关键规范**:
- Controller 命名: `*Controller.java`
- 请求对象: `*Cmd.java`, `*Qry.java`
- 响应对象: `*VO.java`

**示例**:
```java
@RestController
@RequestMapping("/api/v1/user")
public class UserInfoController {
    
    private final UserAppService userAppService;
    
    @GetMapping("/current")
    public HttpResponseEntity<UserInfoVO> getCurrentUser() {
        return HttpResponseEntity.ok(userAppService.getCurrentUserInfo());
    }
}
```

### 2. 应用层 (boss-application)

**职责**:
- 编排业务流程
- 调用领域服务
- 处理事务
- 协调多个聚合

**关键规范**:
- 应用服务命名: `*AppService.java`

**示例**:
```java
@Service
public class UserAppService {
    
    private final UserRepository userRepository;
    
    public UserInfoVO getCurrentUserInfo() {
        Long userId = SecurityContextHolder.getCurrentUserId();
        User user = userRepository.findById(userId);
        // ... 业务逻辑
        return convert(user);
    }
}
```

### 3. 领域层 (boss-domain)

**职责**:
- 核心业务逻辑
- 领域模型（聚合根、实体、值对象）
- 领域服务
- 仓储接口定义

**关键规范**:
- 聚合根: `*Aggregate.java` 或直接用业务名
- 实体: `*Entity.java` 或直接用业务名
- 值对象: `*VO.java`
- 领域服务: `*DomainService.java`
- 仓储接口: `*Repository.java`

**示例**:
```java
// 领域模型
public class User {
    private Long userId;
    private String username;
    
    // 领域行为
    public void changePassword(String newPassword) {
        // 密码校验逻辑
    }
}

// 仓储接口
public interface UserRepository {
    User findById(Long userId);
    void save(User user);
}
```

### 4. 基础设施层 (boss-infrastructure)

**职责**:
- 实现仓储接口
- 数据库持久化（MyBatis Mapper）
- 外部服务调用
- 缓存（Redis）
- 技术配置（JWT、多数据源等）

**关键规范**:
- Mapper: `*Mapper.java`
- PO: `*PO.java`
- 仓储实现: `*RepositoryImpl.java`
- 配置类: `*Config.java`

**示例**:
```java
@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private final UserMapper userMapper;
    
    @Override
    public User findById(Long userId) {
        UserPO po = userMapper.selectById(userId);
        return convert(po);
    }
}
```

## DDD 核心原则

### 1. 依赖方向

✅ **正确**:
```
接口层 → 应用层 → 领域层
          ↑
    基础设施层（实现领域层接口）
```

❌ **错误**:
```
领域层 → 基础设施层  # 领域层不能依赖基础设施层！
```

### 2. 职责隔离

- **领域层**: 只关注业务逻辑，不涉及技术实现
- **基础设施层**: 只提供技术支持，不包含业务逻辑
- **应用层**: 协调各层，不写复杂业务逻辑

### 3. 聚合设计

- 一个聚合一个仓储
- 聚合内强一致性
- 聚合间最终一致性（事件驱动）

## 示例：用户登录流程

```
1. Controller (接口层)
   ↓ 接收登录请求 LoginCmd
   
2. AuthAppService (应用层)
   ↓ 验证用户名密码
   ↓ 调用 UserRepository.findByUsername()
   
3. UserRepository (领域层接口定义)
   
4. UserRepositoryImpl (基础设施层实现)
   ↓ 调用 UserMapper 查询数据库
   
5. 返回 User 领域对象
   ↓
   
6. 生成 JWT Token (基础设施层 JwtTokenProvider)
   ↓
   
7. 返回 LoginVO (接口层)
```

## 配置管理规范

所有技术配置**统一在基础设施层**管理：

```
boss-infrastructure/
└── config/
    ├── JwtConfig.java          # JWT 配置
    ├── DataSourceConfig.java   # 数据源配置
    ├── WebMvcConfig.java       # MVC 配置
    └── ...
```

❌ **不要使用散落的 @Value 注解**  
✅ **使用 @ConfigurationProperties 统一管理**

---

**参考**: 详见项目根目录 `.cursorrules` 文件

**最后更新**: 2025-12-25

