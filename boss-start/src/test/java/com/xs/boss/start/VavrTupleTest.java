package com.xs.boss.start;

import io.vavr.Tuple;
import io.vavr.Tuple0;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.Tuple4;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vavr Tuple 功能测试
 * 
 * @author xiangshang
 */
@DisplayName("Vavr Tuple 测试")
class VavrTupleTest {

    // ==================== 1. 创建 Tuple ====================

    @Test
    @DisplayName("1.1 创建不同类型的 Tuple")
    void testCreateTuple() {
        // 空 Tuple
        Tuple0 tuple0 = Tuple.empty();
        assertNotNull(tuple0);

        // 二元组
        Tuple2<String, Integer> tuple2 = Tuple.of("订单号", 1001);
        assertEquals("订单号", tuple2._1);
        assertEquals(1001, tuple2._2);

        // 三元组
        Tuple3<String, Integer, Double> tuple3 = Tuple.of("iPhone", 2, 5999.0);
        assertEquals("iPhone", tuple3._1);
        assertEquals(2, tuple3._2);
        assertEquals(5999.0, tuple3._3);

        System.out.println("✅ Tuple0: " + tuple0);
        System.out.println("✅ Tuple2: " + tuple2);
        System.out.println("✅ Tuple3: " + tuple3);
    }

    // ==================== 2. 访问元素 ====================

    @Test
    @DisplayName("2.1 访问 Tuple 元素")
    void testAccessElements() {
        Tuple3<String, Integer, Boolean> tuple = Tuple.of("用户A", 25, true);

        // 使用字段访问
        String name = tuple._1;
        Integer age = tuple._2;
        Boolean active = tuple._3;

        assertEquals("用户A", name);
        assertEquals(25, age);
        assertTrue(active);

        // 也可以使用方法访问
        assertEquals("用户A", tuple._1());
        assertEquals(25, tuple._2());
        assertTrue(tuple._3());

        System.out.println("✅ 姓名: " + name + ", 年龄: " + age + ", 活跃: " + active);
    }

    // ==================== 3. 转换操作 ====================

    @Test
    @DisplayName("3.1 map1/map2 - 转换单个元素")
    void testMapSingleElement() {
        Tuple2<String, Integer> tuple = Tuple.of("hello", 5);

        // 转换第一个元素
        Tuple2<String, Integer> result1 = tuple.map1(String::toUpperCase);
        assertEquals("HELLO", result1._1);
        assertEquals(5, result1._2);

        // 转换第二个元素
        Tuple2<String, Integer> result2 = tuple.map2(n -> n * 2);
        assertEquals("hello", result2._1);
        assertEquals(10, result2._2);

        System.out.println("✅ 原始: " + tuple);
        System.out.println("✅ map1 后: " + result1);
        System.out.println("✅ map2 后: " + result2);
    }

    @Test
    @DisplayName("3.2 map - 同时转换所有元素")
    void testMapAllElements() {
        Tuple2<String, Integer> tuple = Tuple.of("test", 100);

        // 使用两个函数分别转换
        Tuple2<Integer, String> result = tuple.map(
                String::length,      // 字符串长度
                Object::toString     // 转为字符串
        );

        assertEquals(4, result._1);      // "test" 长度为 4
        assertEquals("100", result._2);  // 100 转为 "100"

        System.out.println("✅ 原始: " + tuple);
        System.out.println("✅ map 后: " + result);
    }

    @Test
    @DisplayName("3.3 apply - 将 Tuple 应用到函数")
    void testApply() {
        Tuple2<String, Integer> person = Tuple.of("张三", 25);

        // 将 tuple 元素作为参数传入函数
        String result = person.apply((name, age) -> name + " 今年 " + age + " 岁");

        assertEquals("张三 今年 25 岁", result);
        System.out.println("✅ apply 结果: " + result);
    }

    @Test
    @DisplayName("3.4 apply - 应用函数转换")
    void testApplyTransform() {
        Tuple2<String, Integer> tuple = Tuple.of("订单", 12345);

        // apply 方法：将 Tuple 元素作为参数传入 BiFunction
        String result = tuple.apply((prefix, id) -> prefix + "-" + id);
        assertEquals("订单-12345", result);
        System.out.println("✅ apply 结果: " + result);

        // 可以转换为任意类型
        Integer length = tuple.apply((prefix, id) -> prefix.length() + id);
        assertEquals(12347, length);  // 2 + 12345
        System.out.println("✅ apply 计算结果: " + length);

        // 也可以直接访问元素进行操作
        String direct = tuple._1 + "-" + tuple._2;
        assertEquals("订单-12345", direct);
        System.out.println("✅ 直接访问: " + direct);
    }

    // ==================== 4. 拼接操作 ====================

    @Test
    @DisplayName("4.1 concat - 拼接两个 Tuple")
    void testConcat() {
        Tuple2<String, Integer> t1 = Tuple.of("商品A", 100);
        Tuple2<Double, Boolean> t2 = Tuple.of(99.9, true);

        // 拼接成 Tuple4
        Tuple4<String, Integer, Double, Boolean> combined = t1.concat(t2);

        assertEquals("商品A", combined._1);
        assertEquals(100, combined._2);
        assertEquals(99.9, combined._3);
        assertTrue(combined._4);

        System.out.println("✅ Tuple1: " + t1);
        System.out.println("✅ Tuple2: " + t2);
        System.out.println("✅ 拼接后: " + combined);
    }

    @Test
    @DisplayName("4.2 append - 追加元素")
    void testAppend() {
        Tuple2<String, Integer> tuple = Tuple.of("测试", 100);

        // 追加元素到末尾
        Tuple3<String, Integer, Boolean> appended = tuple.append(true);
        assertEquals("测试", appended._1);
        assertEquals(100, appended._2);
        assertTrue(appended._3);

        // 继续追加
        Tuple4<String, Integer, Boolean, Double> appended2 = appended.append(3.14);
        assertEquals("测试", appended2._1);
        assertEquals(100, appended2._2);
        assertTrue(appended2._3);
        assertEquals(3.14, appended2._4);

        System.out.println("✅ 原始: " + tuple);
        System.out.println("✅ append 后: " + appended);
        System.out.println("✅ 再次 append: " + appended2);

        // 如果需要前置元素，可以用 concat 实现
        Tuple3<Double, String, Integer> prepended = Tuple.of(3.14).concat(tuple);
        assertEquals(3.14, prepended._1);
        assertEquals("测试", prepended._2);
        assertEquals(100, prepended._3);
        System.out.println("✅ 使用 concat 前置: " + prepended);
    }

    // ==================== 5. 转换为其他数据结构 ====================

    @Test
    @DisplayName("5.1 toSeq - 转为序列")
    void testToSeq() {
        Tuple3<String, Integer, Double> tuple = Tuple.of("A", 1, 2.5);

        Seq<?> seq = tuple.toSeq();

        assertEquals(3, seq.size());
        assertEquals("A", seq.get(0));
        assertEquals(1, seq.get(1));
        assertEquals(2.5, seq.get(2));

        System.out.println("✅ Tuple: " + tuple);
        System.out.println("✅ Seq: " + seq);
    }

    @Test
    @DisplayName("5.2 使用 Tuple 构建 Map")
    void testBuildMap() {
        // 使用 Tuple 构建 Vavr Map
        Map<String, Integer> scores = HashMap.ofEntries(
                Tuple.of("张三", 85),
                Tuple.of("李四", 92),
                Tuple.of("王五", 78)
        );

        assertEquals(3, scores.size());
        assertEquals(Option.some(85), scores.get("张三"));
        assertEquals(Option.some(92), scores.get("李四"));
        assertEquals(Option.some(78), scores.get("王五"));

        System.out.println("✅ Map: " + scores);

        // 遍历 Map
        System.out.println("✅ 遍历 Map:");
        scores.forEach((name, score) ->
                System.out.println("   - " + name + ": " + score + " 分")
        );
    }

    // ==================== 6. 实际业务场景 ====================

    @Test
    @DisplayName("6.1 方法返回多个值")
    void testReturnMultipleValues() {
        // 模拟验证订单
        Tuple2<Boolean, String> validResult = validateOrder(100.0);
        assertTrue(validResult._1);
        assertEquals("验证通过", validResult._2);

        Tuple2<Boolean, String> invalidResult = validateOrder(-10.0);
        assertFalse(invalidResult._1);
        assertEquals("订单金额必须大于0", invalidResult._2);

        System.out.println("✅ 有效订单验证: " + validResult);
        System.out.println("✅ 无效订单验证: " + invalidResult);
    }

    /**
     * 模拟订单验证，返回验证结果和消息
     */
    private Tuple2<Boolean, String> validateOrder(Double amount) {
        if (amount == null || amount <= 0) {
            return Tuple.of(false, "订单金额必须大于0");
        }
        return Tuple.of(true, "验证通过");
    }

    @Test
    @DisplayName("6.2 数据聚合统计")
    void testDataAggregation() {
        // 模拟订单统计
        Tuple3<Integer, Double, String> stats = getOrderStatistics();

        assertEquals(5, stats._1);          // 订单数量
        assertEquals(1500.0, stats._2);     // 总金额
        assertEquals("VIP订单", stats._3);  // 最大订单名称

        System.out.println("✅ 订单统计:");
        System.out.println("   - 订单数量: " + stats._1);
        System.out.println("   - 总金额: ¥" + stats._2);
        System.out.println("   - 最大订单: " + stats._3);
    }

    /**
     * 模拟获取订单统计数据
     */
    private Tuple3<Integer, Double, String> getOrderStatistics() {
        int totalCount = 5;
        double totalAmount = 1500.0;
        String maxOrderName = "VIP订单";
        return Tuple.of(totalCount, totalAmount, maxOrderName);
    }

    @Test
    @DisplayName("6.3 结合 Option 处理空值")
    void testWithOption() {
        // 可能为空的数据
        String nullableName = null;
        Integer age = 25;

        // 使用 Option 包装可能为空的值
        Tuple2<Option<String>, Integer> safeTuple = Tuple.of(Option.of(nullableName), age);

        assertTrue(safeTuple._1.isEmpty());
        assertEquals(25, safeTuple._2);

        // 安全获取值
        String name = safeTuple._1.getOrElse("未知用户");
        assertEquals("未知用户", name);

        System.out.println("✅ 安全 Tuple: " + safeTuple);
        System.out.println("✅ 获取姓名 (带默认值): " + name);
    }

    // ==================== 7. 不可变性验证 ====================

    @Test
    @DisplayName("7.1 验证 Tuple 不可变性")
    void testImmutability() {
        Tuple2<String, Integer> original = Tuple.of("原始值", 100);

        // 所有转换操作都返回新对象
        Tuple2<String, Integer> modified = original.map1(s -> "修改后");

        // 原始 Tuple 不变
        assertEquals("原始值", original._1);
        assertEquals(100, original._2);

        // 新 Tuple 是修改后的值
        assertEquals("修改后", modified._1);
        assertEquals(100, modified._2);

        // 验证是不同对象
        assertNotSame(original, modified);

        System.out.println("✅ 原始 Tuple (不变): " + original);
        System.out.println("✅ 新 Tuple: " + modified);
    }

    // ==================== 8. arity 和其他方法 ====================

    @Test
    @DisplayName("8.1 arity - 获取元素数量")
    void testArity() {
        Tuple0 t0 = Tuple.empty();
        Tuple2<String, Integer> t2 = Tuple.of("A", 1);
        Tuple3<String, Integer, Boolean> t3 = Tuple.of("A", 1, true);

        assertEquals(0, t0.arity());
        assertEquals(2, t2.arity());
        assertEquals(3, t3.arity());

        System.out.println("✅ Tuple0 arity: " + t0.arity());
        System.out.println("✅ Tuple2 arity: " + t2.arity());
        System.out.println("✅ Tuple3 arity: " + t3.arity());
    }

    @Test
    @DisplayName("8.2 equals 和 hashCode")
    void testEqualsAndHashCode() {
        Tuple2<String, Integer> tuple1 = Tuple.of("test", 100);
        Tuple2<String, Integer> tuple2 = Tuple.of("test", 100);
        Tuple2<String, Integer> tuple3 = Tuple.of("test", 200);

        // equals
        assertEquals(tuple1, tuple2);
        assertNotEquals(tuple1, tuple3);

        // hashCode
        assertEquals(tuple1.hashCode(), tuple2.hashCode());

        System.out.println("✅ tuple1: " + tuple1 + ", hashCode: " + tuple1.hashCode());
        System.out.println("✅ tuple2: " + tuple2 + ", hashCode: " + tuple2.hashCode());
        System.out.println("✅ tuple3: " + tuple3 + ", hashCode: " + tuple3.hashCode());
    }
}
