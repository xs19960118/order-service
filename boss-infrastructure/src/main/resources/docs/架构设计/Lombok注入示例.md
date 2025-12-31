# Lombok @RequiredArgsConstructor 注入示例

## 1. 只有 final 字段（推荐）

```java
@RequiredArgsConstructor
public class UserInfoController {
    private final UserFacade userFacade;  // ✅ 会生成构造器参数
    
    // Lombok 生成：
    // public UserInfoController(UserFacade userFacade) {
    //     this.userFacade = userFacade;
    // }
}
```

**结果**：✅ Spring 会自动通过构造器注入 `userFacade`

---

## 2. 只有非 final 字段（不推荐）

```java
@RequiredArgsConstructor
public class UserInfoController {
    private UserFacade userFacade;  // ❌ 不是 final，不会生成构造器参数
    
    // Lombok 不会生成任何构造器！
}
```

**结果**：❌ 不会自动注入，需要手动添加 `@Autowired` 或 `@Resource`

**解决方案**：
```java
@RequiredArgsConstructor
public class UserInfoController {
    @Autowired  // 或 @Resource
    private UserFacade userFacade;  // 需要手动注入
}
```

---

## 3. 既有 final 又有非 final 字段

```java
@RequiredArgsConstructor
public class UserInfoController {
    private final UserFacade userFacade;        // ✅ final，会生成构造器参数
    private String someConfig;                   // ❌ 不是 final，不会生成构造器参数
    
    // Lombok 生成的构造器（只包含 final 字段）：
    // public UserInfoController(UserFacade userFacade) {
    //     this.userFacade = userFacade;
    //     // someConfig 不会被注入
    // }
}
```

**结果**：
- ✅ `userFacade` 会通过构造器自动注入
- ❌ `someConfig` 不会被注入，需要手动处理

**解决方案 1**：将非 final 字段也改为 final（推荐）
```java
@RequiredArgsConstructor
public class UserInfoController {
    private final UserFacade userFacade;
    private final String someConfig;  // 改为 final，也会生成构造器参数
}
```

**解决方案 2**：使用 `@Autowired` 或 `@Resource` 手动注入非 final 字段
```java
@RequiredArgsConstructor
public class UserInfoController {
    private final UserFacade userFacade;  // 构造器注入
    
    @Value("${app.some.config}")  // 或 @Autowired
    private String someConfig;  // 字段注入
}
```

---

## 4. 使用 @NonNull 注解（即使不是 final）

```java
@RequiredArgsConstructor
public class UserInfoController {
    @NonNull
    private UserFacade userFacade;  // ✅ @NonNull，会生成构造器参数（即使不是 final）
    
    // Lombok 生成的构造器：
    // public UserInfoController(@NonNull UserFacade userFacade) {
    //     if (userFacade == null) {
    //         throw new NullPointerException("userFacade is marked non-null but is null");
    //     }
    //     this.userFacade = userFacade;
    // }
}
```

**结果**：✅ Spring 会自动通过构造器注入，并且会进行 null 检查

---

## 5. 混合使用（最佳实践）

```java
@RequiredArgsConstructor
public class UserInfoController {
    // final 字段：通过构造器注入（推荐）
    private final UserFacade userFacade;
    private final UserAppService userAppService;
    
    // 非 final 字段：如果需要注入，使用 @Autowired 或 @Resource
    @Value("${app.timeout:5000}")
    private Integer timeout;  // 配置值，不需要 final
    
    // 或者使用 @Autowired 注入可选依赖
    @Autowired(required = false)
    private OptionalService optionalService;  // 可选依赖
}
```

---

## 总结

| 字段类型 | @RequiredArgsConstructor 是否生成构造器参数 | 是否需要手动注入 |
|---------|------------------------------------------|-----------------|
| `private final Type field;` | ✅ 是 | ❌ 不需要 |
| `private Type field;` | ❌ 否 | ✅ 需要 `@Autowired` 或 `@Resource` |
| `@NonNull private Type field;` | ✅ 是（即使不是 final） | ❌ 不需要 |
| `private final Type field;` + `private Type field2;` | ✅ 只生成 final 字段的参数 | final 不需要，非 final 需要手动注入 |

## 最佳实践

1. **优先使用 `final` 字段**：确保不可变，符合 Spring 推荐
2. **统一使用 `@RequiredArgsConstructor`**：代码简洁，符合项目规范
3. **非 final 字段**：如果需要注入，使用 `@Autowired` 或 `@Resource`
4. **配置值**：使用 `@Value` 注入配置，不需要 final

