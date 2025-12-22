#!/bin/bash

# 多数据源目录结构创建脚本
# 用于创建 Boss、CRM、Report 三个数据源的目录结构

echo "=========================================="
echo "创建多数据源目录结构"
echo "=========================================="

# 创建 Mapper 接口目录
echo "📁 创建 Mapper 接口目录..."
mkdir -p order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/mapper/boss
mkdir -p order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/mapper/crm
mkdir -p order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/mapper/report

# 创建 PO 对象目录
echo "📁 创建 PO 对象目录..."
mkdir -p order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/po/boss
mkdir -p order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/po/crm
mkdir -p order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/po/report

# 创建 Mapper XML 目录
echo "📁 创建 Mapper XML 目录..."
mkdir -p order-service-interfaces/src/main/resources/mapper/boss
mkdir -p order-service-interfaces/src/main/resources/mapper/crm
mkdir -p order-service-interfaces/src/main/resources/mapper/report

# 创建 .gitkeep 文件以保持空目录
echo "📝 创建 .gitkeep 文件..."
touch order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/mapper/boss/.gitkeep
touch order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/mapper/crm/.gitkeep
touch order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/mapper/report/.gitkeep

touch order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/po/boss/.gitkeep
touch order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/po/crm/.gitkeep
touch order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/po/report/.gitkeep

touch order-service-interfaces/src/main/resources/mapper/boss/.gitkeep
touch order-service-interfaces/src/main/resources/mapper/crm/.gitkeep
touch order-service-interfaces/src/main/resources/mapper/report/.gitkeep

echo ""
echo "✅ 目录结构创建完成！"
echo ""
echo "目录结构："
echo "order-service-infrastructure/src/main/java/com/xs/order/service/infrastructure/persistence/"
echo "├── mapper/"
echo "│   ├── boss/          # Boss 数据源的 Mapper 接口"
echo "│   ├── crm/           # CRM 数据源的 Mapper 接口"
echo "│   └── report/        # Report 数据源的 Mapper 接口"
echo "└── po/"
echo "    ├── boss/          # Boss 数据源的 PO 对象"
echo "    ├── crm/           # CRM 数据源的 PO 对象"
echo "    └── report/        # Report 数据源的 PO 对象"
echo ""
echo "order-service-interfaces/src/main/resources/"
echo "└── mapper/"
echo "    ├── boss/          # Boss 数据源的 Mapper XML"
echo "    ├── crm/           # CRM 数据源的 Mapper XML"
echo "    └── report/        # Report 数据源的 Mapper XML"
echo ""
echo "=========================================="

