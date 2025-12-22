@echo off
REM 多数据源目录结构创建脚本（Windows 版本）
REM 用于创建 Boss、CRM、Report 三个数据源的目录结构

echo ==========================================
echo 创建多数据源目录结构
echo ==========================================

REM 创建 Mapper 接口目录
echo 📁 创建 Mapper 接口目录...
mkdir order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\mapper\boss 2>nul
mkdir order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\mapper\crm 2>nul
mkdir order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\mapper\report 2>nul

REM 创建 PO 对象目录
echo 📁 创建 PO 对象目录...
mkdir order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\po\boss 2>nul
mkdir order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\po\crm 2>nul
mkdir order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\po\report 2>nul

REM 创建 Mapper XML 目录
echo 📁 创建 Mapper XML 目录...
mkdir order-service-interfaces\src\main\resources\mapper\boss 2>nul
mkdir order-service-interfaces\src\main\resources\mapper\crm 2>nul
mkdir order-service-interfaces\src\main\resources\mapper\report 2>nul

REM 创建 .gitkeep 文件以保持空目录
echo 📝 创建 .gitkeep 文件...
type nul > order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\mapper\boss\.gitkeep
type nul > order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\mapper\crm\.gitkeep
type nul > order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\mapper\report\.gitkeep

type nul > order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\po\boss\.gitkeep
type nul > order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\po\crm\.gitkeep
type nul > order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\po\report\.gitkeep

type nul > order-service-interfaces\src\main\resources\mapper\boss\.gitkeep
type nul > order-service-interfaces\src\main\resources\mapper\crm\.gitkeep
type nul > order-service-interfaces\src\main\resources\mapper\report\.gitkeep

echo.
echo ✅ 目录结构创建完成！
echo.
echo 目录结构：
echo order-service-infrastructure\src\main\java\com\xs\order\service\infrastructure\persistence\
echo ├── mapper\
echo │   ├── boss\          # Boss 数据源的 Mapper 接口
echo │   ├── crm\           # CRM 数据源的 Mapper 接口
echo │   └── report\        # Report 数据源的 Mapper 接口
echo └── po\
echo     ├── boss\          # Boss 数据源的 PO 对象
echo     ├── crm\           # CRM 数据源的 PO 对象
echo     └── report\        # Report 数据源的 PO 对象
echo.
echo order-service-interfaces\src\main\resources\
echo └── mapper\
echo     ├── boss\          # Boss 数据源的 Mapper XML
echo     ├── crm\           # CRM 数据源的 Mapper XML
echo     └── report\        # Report 数据源的 Mapper XML
echo.
echo ==========================================
pause

