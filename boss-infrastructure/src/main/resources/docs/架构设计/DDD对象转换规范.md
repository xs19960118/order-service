# 📋 DDD 分层对象转换规范

## 概述

本文档详细说明 DDD 分层架构中各层对象的命名规范和转换规则，解决以下核心问题：

1. **Interface 层 → Application 层**：对象如何转换？
2. **Application 层 → Domain 层**：对象如何命名和处理？
3. **Domain 层 → Interface 层**：领域对象如何转换为 VO？

---

## 🏗️ 各层对象类型与命名规范

### 1. Interface 层（接口层）

**职责**：对外暴露 RESTful API，接收请求和返回响应

**对象类型**：
- **请求对象**：
  - `*Qry.java` - 查询类请求（Query）
  - `*Cmd.java` - 命令类请求（Command，如创建、更新、删除）
- **响应对象**：
  - `*VO.java` - 视图对象（View Object），统一返回给前端

**位置**：
```
boss-interfaces/src/main/java/com/xs/boss/interfaces/
├── dto/
│   ├── qry/          # 查询请求
│   │   └── user/
│   │       └── ExchangeTokenQry.java
│   ├── cmd/          # 命令请求
│   │   └── user/
│   │       └── CreateUserCmd.java
│   └── vo/           # 视图对象
│       └── user/
│           └── ExchangeTokenVO.java
└── web/
    └── user/
        └── converter/
            └── UserConverter.java  # 转换器
```

**示例**：
```java
// ExchangeTokenQry.java - 查询请求
@Data
@Builder
public class ExchangeTokenQry {
    private String ticket;
    private String serverUrl;
}

// ExchangeTokenVO.java - 视图对象
@Data
@Builder
public class ExchangeTokenVO {
    private String accessToken;
    private String tokenType;
    private Integer expiresIn;
}
```

---

### 2. Application 层（应用层）

**职责**：编排业务流程，协调领域服务

**对象类型**：
- **DTO（Data Transfer Object）**：
  - `*DTO.java` - 应用层自己的数据传输对象
  - **注意**：Application 层不依赖 Interface 层，必须有自己的 DTO

**位置**：
```
boss-application/src/main/java/com/xs/boss/application/
└── user/
    ├── dto/
    │   └── ExchangeTokenDTO.java
    └── service/
        ├── UserAppService.java
        └── impl/
            └── UserAppServiceImpl.java
```

**示例**：
```java
// ExchangeTokenDTO.java - 应用层 DTO
@Data
@Builder
public class ExchangeTokenDTO {
    private String ticket;
    private String serverUrl;
}
```

**关键原则**：
- ✅ Application 层**必须**有自己的 DTO，不直接使用 Interface 层的 Qry/Cmd
- ✅ Application 层的 Service 方法**接收** Application DTO，**返回** Domain 对象
- ❌ Application 层**不能**依赖 Interface 层

---

### 3. Domain 层（领域层）

**职责**：核心业务逻辑，领域模型

**对象类型**：
- **领域模型**：
  - `*Aggregate.java` - 聚合根（如 `OrderAggregate`）
  - `*Entity.java` - 实体（如 `OrderEntity`）
  - 直接使用业务名称（如 `User`, `Order`）
- **值对象**：
  - `*VO.java` - 值对象（Value Object），注意与 Interface 层的 VO 区分
  - 或者直接使用业务名称（如 `TokenInfo`, `TicketInfo`）

**位置**：
```
boss-domain/src/main/java/com/xs/boss/domain/
└── user/
    ├── model/
    │   ├── TokenInfo.java      # 领域模型
    │   ├── TicketInfo.java     # 领域模型
    │   └── User.java           # 聚合根/实体
    └── service/
        └── TicketDomainService.java
```

**示例**：
```java
// TokenInfo.java - 领域模型
@Data
@Builder
public class TokenInfo {
    private String accessToken;
    private String tokenType;
    private Integer expiresIn;
}
```

**关键原则**：
- ✅ Domain 层对象是**纯业务对象**，不包含技术细节
- ✅ Domain 层**不依赖**任何其他业务层
- ✅ Application 层调用 Domain 层，Domain 层返回领域对象

---

### 4. Infrastructure 层（基础设施层）

**职责**：数据持久化、外部服务调用

**对象类型**：
- **PO（Persistent Object）**：
  - `*PO.java` - 持久化对象，对应数据库表

**位置**：
```
boss-infrastructure/src/main/java/com/xs/boss/infrastructure/
└── persistence/
    ├── po/
    │   └── TicketPO.java
    └── mapper/
        └── TicketMapper.java
```

---

## 🔄 对象转换流程

### 完整转换链路

```
┌─────────────────────────────────────────────────────────────┐
│ Interface 层                                                │
│  ┌──────────────┐      ┌──────────────┐                    │
│  │ ExchangeTokenQry │ → │ ExchangeTokenVO │                │
│  └──────────────┘      └──────────────┘                    │
│         ↓                        ↑                          │
│         │                        │                          │
│    [UserConverter]              │                          │
│         │                        │                          │
└─────────┼────────────────────────┼──────────────────────────┘
          │                        │
          ↓                        ↑
┌─────────┼────────────────────────┼──────────────────────────┐
│         │                        │                          │
│ Application 层                  │                          │
│  ┌──────────────┐                │                          │
│  │ ExchangeTokenDTO │            │                          │
│  └──────────────┘                │                          │
│         ↓                        │                          │
│    [UserAppService]              │                          │
│         │                        │                          │
└─────────┼────────────────────────┼──────────────────────────┘
          │                        │
          ↓                        ↑
┌─────────┼────────────────────────┼──────────────────────────┐
│         │                        │                          │
│ Domain 层                        │                          │
│  ┌──────────────┐                │                          │
│  │ TokenInfo    │ ←──────────────┘                          │
│  └──────────────┘                                            │
│                                                              │
└──────────────────────────────────────────────────────────────┘
```

### 转换步骤详解

#### 步骤 1：Interface Qry/Cmd → Application DTO

**位置**：Interface 层的 `Converter`

**示例**：
```java
@Component
public class UserConverter {
    
    /**
     * Interface Qry → Application DTO
     */
    public ExchangeTokenDTO toApplicationDTO(ExchangeTokenQry qry) {
        return ExchangeTokenDTO.builder()
                .ticket(qry.getTicket())
                .serverUrl(qry.getServerUrl())
                .build();
    }
}
```

**为什么需要转换？**
- Application 层不能依赖 Interface 层
- 保持各层独立性，便于维护和测试

---

#### 步骤 2：Application DTO → Domain Object

**位置**：Application 层的 `AppService`

**示例**：
```java
@Service
public class UserAppServiceImpl implements UserAppService {
    
    @Override
    public TokenInfo exchangeToken(ExchangeTokenDTO dto) {
        // Application 层接收自己的 DTO
        // 调用 Domain 层服务
        TicketInfo ticketInfo = ticketDomainService.validateAndGetTicketInfo(
                dto.getTicket(), 
                dto.getServerUrl()
        );
        
        // 构建并返回 Domain 对象
        return TokenInfo.builder()
                .accessToken(accessToken)
                .tokenType("Bearer")
                .expiresIn(expiresIn)
                .build();
    }
}
```

**关键点**：
- ✅ Application 层接收 `Application DTO`
- ✅ Application 层返回 `Domain 对象`
- ✅ Application 层负责将 DTO 转换为 Domain 对象（如果需要）

---

#### 步骤 3：Domain Object → Interface VO

**位置**：Interface 层的 `Converter`

**示例**：
```java
@Component
public class UserConverter {
    
    /**
     * Domain Object → Interface VO
     */
    public ExchangeTokenVO toVO(TokenInfo tokenInfo) {
        return ExchangeTokenVO.builder()
                .accessToken(tokenInfo.getAccessToken())
                .tokenType(tokenInfo.getTokenType())
                .expiresIn(tokenInfo.getExpiresIn())
                .build();
    }
}
```

**为什么需要转换？**
- Domain 对象是业务对象，可能包含业务细节
- Interface VO 是视图对象，面向前端，可能需要格式化、过滤敏感信息等
- 保持 Domain 层纯净，不依赖 Interface 层

---

## 📝 Controller 完整示例

```java
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserAppService userAppService;
    private final UserConverter userConverter;

    @PostMapping("/exchange-token")
    public HttpResponseEntity<ExchangeTokenVO> getExchangeToken(
            @RequestBody ExchangeTokenQry exchangeTokenQry) {
        
        // 步骤 1: Interface Qry → Application DTO
        var applicationDTO = userConverter.toApplicationDTO(exchangeTokenQry);
        
        // 步骤 2: Application DTO → Domain Object (在 AppService 内部完成)
        var tokenInfo = userAppService.exchangeToken(applicationDTO);
        
        // 步骤 3: Domain Object → Interface VO
        var vo = userConverter.toVO(tokenInfo);
        
        return HttpResponseEntity.ok(vo);
    }
}
```

---

## ✅ 核心原则总结

### 1. 对象命名规范

| 层级 | 对象类型 | 命名规范 | 示例 |
|------|---------|---------|------|
| **Interface** | 查询请求 | `*Qry.java` | `ExchangeTokenQry` |
| **Interface** | 命令请求 | `*Cmd.java` | `CreateUserCmd` |
| **Interface** | 视图对象 | `*VO.java` | `ExchangeTokenVO` |
| **Application** | 数据传输对象 | `*DTO.java` | `ExchangeTokenDTO` |
| **Domain** | 领域模型 | 业务名称 | `TokenInfo`, `User` |
| **Domain** | 值对象 | `*VO.java` 或业务名称 | `TokenInfo`, `Money` |
| **Infrastructure** | 持久化对象 | `*PO.java` | `TicketPO` |

### 2. 转换器（Converter）规范

**位置**：Interface 层

**命名**：`*Converter.java`（如 `UserConverter`）

**职责**：
- ✅ Interface Qry/Cmd → Application DTO
- ✅ Domain Object → Interface VO
- ❌ **不负责** Application DTO → Domain Object（在 AppService 中完成）

**示例结构**：
```java
@Component
public class UserConverter {
    
    // Interface → Application
    public ExchangeTokenDTO toApplicationDTO(ExchangeTokenQry qry) { ... }
    public CreateUserDTO toApplicationDTO(CreateUserCmd cmd) { ... }
    
    // Domain → Interface
    public ExchangeTokenVO toVO(TokenInfo tokenInfo) { ... }
    public UserVO toVO(User user) { ... }
}
```

### 3. 依赖方向

```
Interface 层
    ↓ (调用)
Application 层
    ↓ (调用)
Domain 层
    ↑ (实现)
Infrastructure 层
```

**关键约束**：
- ❌ Application 层**不能**依赖 Interface 层
- ❌ Domain 层**不能**依赖 Application 层和 Infrastructure 层
- ✅ Infrastructure 层**实现** Domain 层定义的接口（依赖倒置）

### 4. 各层对象职责

| 层级 | 对象职责 | 特点 |
|------|---------|------|
| **Interface Qry/Cmd** | 接收前端请求 | 可能包含验证注解、API 文档注解 |
| **Interface VO** | 返回给前端 | 格式化、过滤敏感信息 |
| **Application DTO** | 应用层内部传输 | 纯数据传输，无业务逻辑 |
| **Domain Object** | 业务对象 | 包含业务逻辑、业务规则 |
| **Infrastructure PO** | 数据库映射 | 对应数据库表结构 |

---

## 🎯 常见问题解答

### Q1: Application 层和 Domain 层之间如何处理对象？

**A**: 
- **Application 层**接收自己的 `DTO`，返回 `Domain 对象`
- **Domain 层**定义领域模型（如 `TokenInfo`, `User`）
- **Application 层**调用 Domain 层服务，Domain 层返回领域对象
- **不需要额外的转换层**，因为 Application 层可以直接使用 Domain 对象

**示例**：
```java
// Application 层
public interface UserAppService {
    // 接收 Application DTO，返回 Domain 对象
    TokenInfo exchangeToken(ExchangeTokenDTO dto);
}

// Domain 层
public class TicketDomainService {
    // 返回 Domain 对象
    public TicketInfo validateAndGetTicketInfo(String ticket, String serverUrl) {
        // ...
        return TicketInfo.builder()...build();
    }
}
```

---

### Q2: Domain 层返回的对象不能直接作为 Interface 层的 VO，怎么办？

**A**: 
- ✅ **使用 Interface 层的 Converter 进行转换**
- Converter 负责将 Domain 对象转换为 Interface VO
- 转换器放在 Interface 层，因为 Interface 层依赖 Domain 层

**示例**：
```java
// Interface 层的 Converter
@Component
public class UserConverter {
    
    // Domain Object → Interface VO
    public ExchangeTokenVO toVO(TokenInfo tokenInfo) {
        return ExchangeTokenVO.builder()
                .accessToken(tokenInfo.getAccessToken())
                .tokenType(tokenInfo.getTokenType())
                .expiresIn(tokenInfo.getExpiresIn())
                .build();
    }
}
```

**为什么需要转换？**
1. **职责分离**：Domain 对象是业务对象，VO 是视图对象
2. **数据格式化**：VO 可能需要格式化日期、金额等
3. **敏感信息过滤**：VO 可能需要隐藏某些字段
4. **前端适配**：VO 的结构可能更适合前端展示

---

### Q3: Application 层需要自己的 DTO 吗？

**A**: **必须需要！**

**原因**：
1. **依赖隔离**：Application 层不能依赖 Interface 层
2. **复用性**：Application 层可能被多种接口调用（REST、RPC、消息队列等）
3. **稳定性**：Interface 层的 Qry/Cmd 变化不影响 Application 层

**示例**：
```java
// ❌ 错误：Application 层直接使用 Interface 层的 Qry
public interface UserAppService {
    TokenInfo exchangeToken(ExchangeTokenQry qry);  // 错误！
}

// ✅ 正确：Application 层使用自己的 DTO
public interface UserAppService {
    TokenInfo exchangeToken(ExchangeTokenDTO dto);  // 正确！
}
```

---

### Q4: 转换器应该放在哪一层？

**A**: **放在 Interface 层**

**原因**：
- Interface 层依赖 Application 层和 Domain 层
- Interface 层需要将 Interface 对象转换为 Application 对象
- Interface 层需要将 Domain 对象转换为 Interface VO
- 转换器是 Interface 层的职责，负责适配外部接口

**位置**：
```
boss-interfaces/src/main/java/com/xs/boss/interfaces/
└── web/
    └── user/
        └── converter/
            └── UserConverter.java
```

---

## 📚 完整示例：创建订单流程

### 1. Interface 层

```java
// OrderCreateCmd.java - 命令请求
@Data
@Builder
public class OrderCreateCmd {
    private Long userId;
    private List<OrderItemCmd> items;
}

// OrderVO.java - 视图对象
@Data
@Builder
public class OrderVO {
    private Long orderId;
    private String orderNo;
    private BigDecimal totalAmount;
    private String status;
}

// OrderConverter.java - 转换器
@Component
public class OrderConverter {
    
    public OrderCreateDTO toApplicationDTO(OrderCreateCmd cmd) {
        return OrderCreateDTO.builder()
                .userId(cmd.getUserId())
                .items(cmd.getItems().stream()
                        .map(this::toItemDTO)
                        .collect(Collectors.toList()))
                .build();
    }
    
    public OrderVO toVO(Order order) {
        return OrderVO.builder()
                .orderId(order.getOrderId())
                .orderNo(order.getOrderNo())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus().name())
                .build();
    }
}

// OrderController.java
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderAppService orderAppService;
    private final OrderConverter orderConverter;
    
    @PostMapping
    public HttpResponseEntity<OrderVO> createOrder(@RequestBody OrderCreateCmd cmd) {
        // Interface Cmd → Application DTO
        var dto = orderConverter.toApplicationDTO(cmd);
        
        // Application DTO → Domain Object
        var order = orderAppService.createOrder(dto);
        
        // Domain Object → Interface VO
        var vo = orderConverter.toVO(order);
        
        return HttpResponseEntity.ok(vo);
    }
}
```

### 2. Application 层

```java
// OrderCreateDTO.java - 应用层 DTO
@Data
@Builder
public class OrderCreateDTO {
    private Long userId;
    private List<OrderItemDTO> items;
}

// OrderAppService.java
public interface OrderAppService {
    Order createOrder(OrderCreateDTO dto);
}

// OrderAppServiceImpl.java
@Service
@RequiredArgsConstructor
public class OrderAppServiceImpl implements OrderAppService {
    
    private final OrderRepository orderRepository;
    private final OrderDomainService orderDomainService;
    
    @Override
    @Transactional
    public Order createOrder(OrderCreateDTO dto) {
        // Application DTO → Domain Object（在 AppService 中转换）
        Order order = Order.builder()
                .userId(dto.getUserId())
                .items(dto.getItems().stream()
                        .map(this::toOrderItem)
                        .collect(Collectors.toList()))
                .build();
        
        // 调用领域服务
        orderDomainService.validateAndCreate(order);
        
        // 保存
        orderRepository.save(order);
        
        // 返回 Domain 对象
        return order;
    }
}
```

### 3. Domain 层

```java
// Order.java - 聚合根
@Data
@Builder
public class Order {
    private Long orderId;
    private String orderNo;
    private Long userId;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
    private OrderStatus status;
    
    // 领域行为
    public void calculateTotal() {
        this.totalAmount = items.stream()
                .map(OrderItem::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

// OrderDomainService.java
public class OrderDomainService {
    
    public void validateAndCreate(Order order) {
        // 业务规则验证
        if (order.getItems().isEmpty()) {
            throw new BusinessException("订单项不能为空");
        }
        
        // 计算总金额
        order.calculateTotal();
        
        // 生成订单号
        order.setOrderNo(generateOrderNo());
    }
}
```

---

## 🎓 最佳实践

### 1. 转换器命名规范

- 转换器类名：`{模块}Converter`（如 `UserConverter`, `OrderConverter`）
- 方法命名：
  - `toApplicationDTO()` - Interface → Application
  - `toVO()` - Domain → Interface
  - `toDomain()` - Application → Domain（如果需要）

### 2. 转换器方法组织

```java
@Component
public class UserConverter {
    
    // ========== Interface → Application ==========
    public ExchangeTokenDTO toApplicationDTO(ExchangeTokenQry qry) { ... }
    public CreateUserDTO toApplicationDTO(CreateUserCmd cmd) { ... }
    
    // ========== Domain → Interface ==========
    public ExchangeTokenVO toVO(TokenInfo tokenInfo) { ... }
    public UserVO toVO(User user) { ... }
    public List<UserVO> toVOList(List<User> users) { ... }
}
```

### 3. 避免过度转换

- ✅ **必要转换**：Interface ↔ Application ↔ Domain
- ❌ **避免**：Domain 层内部不必要的转换
- ✅ **原则**：Domain 对象可以在 Application 层直接使用

### 4. 使用 MapStruct（可选）

对于复杂的转换，可以考虑使用 MapStruct：

```java
@Mapper(componentModel = "spring")
public interface UserConverter {
    
    ExchangeTokenDTO toApplicationDTO(ExchangeTokenQry qry);
    
    ExchangeTokenVO toVO(TokenInfo tokenInfo);
}
```

---

## 📖 参考

- [DDD 架构说明](./DDD架构说明.md)
- [项目根目录 `.cursorrules`](../../../../.cursorrules)

---

**最后更新**: 2025-12-25  
**作者**: @xiangshang

