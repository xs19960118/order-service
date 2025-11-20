package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class OrdersPO implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单类型：
1.(主订单) 设计费订单
2. (主订单) 矫治器订单
10. 收费调整单
11. 附属订单
20. 外部订单
21. 口扫订单 - 售卖
22. 口扫订单 - 租赁
30. 预购订单
     */
    private Integer type;

    /**
     * 设计编号
     */
    private String designCode;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 病例编号
     */
    private String caseCode;

    /**
     * 业务编号，做唯一索引用
     */
    private String bizCode;

    /**
     * 销售主体：1.北京，2.上海，3.沭阳，4.无锡
     */
    private Integer region;

    /**
     * 关联的订单号
     */
    private String parentOrderCode;

    /**
     * 冲销的订单号
     */
    private String reversalOrderCode;

    /**
     * 1.惠山， 2.新区工厂
     */
    private Integer factory;

    /**
     * 产品数量，默认1
     */
    private Integer quantity;

    /**
     * 商品编号
     */
    private String productCode;

    /**
     * 修改者id
     */
    private Integer modifyUid;

    /**
     * 责任人id
     */
    private Integer assignUid;

    /**
     * 创建人id
     */
    private Integer createUid;

    /**
     * 总价
     */
    private BigDecimal price;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 货币类型
     */
    private String currency;

    /**
     * 订单状态：

0.待审核，
1.新建，
2.待结算，
10.已取消
11. 审核失败
20. 冲销
21. 被冲销
     */
    private Integer status;

    /**
     * 变成待结算时间
     */
    private Long timeConfirm;

    /**
     * 已开票金额
     */
    private BigDecimal amountInvoice;

    /**
     * 已核销金额
     */
    private BigDecimal amountVerification;

    /**
     * 核销时间
     */
    private Long timeVerified;

    /**
     * 回款状态：0.未回款， 1.已匹配回款
     */
    private Integer incomeStatus;

    /**
     * 对账状态：0.未对账，1.对账中，2.部分对账，3.已对账，10.无需对账
     */
    private Integer checkingStatus;

    /**
     * 开票状态：0.未开票，1.开票中，2.部分开票，3.已开票， 10.无需开票，20.已红冲
     */
    private Integer invoiceStatus;

    /**
     * 核销状态：0.未核销，1.部分核销，2.已核销，10.无需核销，20.已冲销
     */
    private Integer verificationStatus;

    /**
     * 完成状态：0.未完成， 1.已完成， 2.已中止，3，已终止
     */
    private Integer finishStatus;

    /**
     * 税率：0.06或者0.13
     */
    private BigDecimal taxRate;

    /**
     * 患者编号
     */
    private String patientCode;

    /**
     * 医生编号
     */
    private String doctorCode;

    /**
     * BA账户编号
     */
    private String baCode;

    /**
     * 集团编号
     */
    private String groupCode;

    /**
     * 机构编号
     */
    private String accountCode;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 开票对象类型: 1.机构, 2.集团, 3.BA
     */
    private Integer invoiceTargetType;

    /**
     * 结算对象类型: 1.机构, 2.集团, 3.BA
     */
    private Integer settlementTargetType;

    /**
     * 业务核销类型，
1.主订单/附属订单不卡款，
2.信用放行，
3.代理放行，
4.优惠放行，
5.预购活动放行 
10.结算核销， 
20. 原订单已放行并冲销， 新订单继承放行
100. 不放行
     */
    private Integer processType;

    /**
     * 业务核销时间
     */
    private Long timeProcess;

    /**
     * 标签位：
1. 卡款
2. 冻结
4. 待结算
8. 折扣调整单
16. 结算系统卡款
32. 是否是复制订单
64. 是否是升级订单
128. 是否是根据组件来获取报价
256. 是否等待投递kafka放行消息
     */
    private byte[] labelBit;

    /**
     * 备注
     */
    private String note;

    /**
     * 乐观锁版本号
     */
    private Integer version;

    /**
     * 结算订单创建结果：0.未传输，1.传输且创建成功， 2.传输但创建失败
     */
    private Integer settlementCreated;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Long deleteTime;

    /**
     * 订单完成时间
     */
    private Long timeFinish;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrdersPO other = (OrdersPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDesignCode() == null ? other.getDesignCode() == null : this.getDesignCode().equals(other.getDesignCode()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getCaseCode() == null ? other.getCaseCode() == null : this.getCaseCode().equals(other.getCaseCode()))
            && (this.getBizCode() == null ? other.getBizCode() == null : this.getBizCode().equals(other.getBizCode()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getParentOrderCode() == null ? other.getParentOrderCode() == null : this.getParentOrderCode().equals(other.getParentOrderCode()))
            && (this.getReversalOrderCode() == null ? other.getReversalOrderCode() == null : this.getReversalOrderCode().equals(other.getReversalOrderCode()))
            && (this.getFactory() == null ? other.getFactory() == null : this.getFactory().equals(other.getFactory()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getModifyUid() == null ? other.getModifyUid() == null : this.getModifyUid().equals(other.getModifyUid()))
            && (this.getAssignUid() == null ? other.getAssignUid() == null : this.getAssignUid().equals(other.getAssignUid()))
            && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid().equals(other.getCreateUid()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTimeConfirm() == null ? other.getTimeConfirm() == null : this.getTimeConfirm().equals(other.getTimeConfirm()))
            && (this.getAmountInvoice() == null ? other.getAmountInvoice() == null : this.getAmountInvoice().equals(other.getAmountInvoice()))
            && (this.getAmountVerification() == null ? other.getAmountVerification() == null : this.getAmountVerification().equals(other.getAmountVerification()))
            && (this.getTimeVerified() == null ? other.getTimeVerified() == null : this.getTimeVerified().equals(other.getTimeVerified()))
            && (this.getIncomeStatus() == null ? other.getIncomeStatus() == null : this.getIncomeStatus().equals(other.getIncomeStatus()))
            && (this.getCheckingStatus() == null ? other.getCheckingStatus() == null : this.getCheckingStatus().equals(other.getCheckingStatus()))
            && (this.getInvoiceStatus() == null ? other.getInvoiceStatus() == null : this.getInvoiceStatus().equals(other.getInvoiceStatus()))
            && (this.getVerificationStatus() == null ? other.getVerificationStatus() == null : this.getVerificationStatus().equals(other.getVerificationStatus()))
            && (this.getFinishStatus() == null ? other.getFinishStatus() == null : this.getFinishStatus().equals(other.getFinishStatus()))
            && (this.getTaxRate() == null ? other.getTaxRate() == null : this.getTaxRate().equals(other.getTaxRate()))
            && (this.getPatientCode() == null ? other.getPatientCode() == null : this.getPatientCode().equals(other.getPatientCode()))
            && (this.getDoctorCode() == null ? other.getDoctorCode() == null : this.getDoctorCode().equals(other.getDoctorCode()))
            && (this.getBaCode() == null ? other.getBaCode() == null : this.getBaCode().equals(other.getBaCode()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()))
            && (this.getAccountCode() == null ? other.getAccountCode() == null : this.getAccountCode().equals(other.getAccountCode()))
            && (this.getContractCode() == null ? other.getContractCode() == null : this.getContractCode().equals(other.getContractCode()))
            && (this.getInvoiceTargetType() == null ? other.getInvoiceTargetType() == null : this.getInvoiceTargetType().equals(other.getInvoiceTargetType()))
            && (this.getSettlementTargetType() == null ? other.getSettlementTargetType() == null : this.getSettlementTargetType().equals(other.getSettlementTargetType()))
            && (this.getProcessType() == null ? other.getProcessType() == null : this.getProcessType().equals(other.getProcessType()))
            && (this.getTimeProcess() == null ? other.getTimeProcess() == null : this.getTimeProcess().equals(other.getTimeProcess()))
            && (Arrays.equals(this.getLabelBit(), other.getLabelBit()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getSettlementCreated() == null ? other.getSettlementCreated() == null : this.getSettlementCreated().equals(other.getSettlementCreated()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getTimeFinish() == null ? other.getTimeFinish() == null : this.getTimeFinish().equals(other.getTimeFinish()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDesignCode() == null) ? 0 : getDesignCode().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getCaseCode() == null) ? 0 : getCaseCode().hashCode());
        result = prime * result + ((getBizCode() == null) ? 0 : getBizCode().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getParentOrderCode() == null) ? 0 : getParentOrderCode().hashCode());
        result = prime * result + ((getReversalOrderCode() == null) ? 0 : getReversalOrderCode().hashCode());
        result = prime * result + ((getFactory() == null) ? 0 : getFactory().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getModifyUid() == null) ? 0 : getModifyUid().hashCode());
        result = prime * result + ((getAssignUid() == null) ? 0 : getAssignUid().hashCode());
        result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTimeConfirm() == null) ? 0 : getTimeConfirm().hashCode());
        result = prime * result + ((getAmountInvoice() == null) ? 0 : getAmountInvoice().hashCode());
        result = prime * result + ((getAmountVerification() == null) ? 0 : getAmountVerification().hashCode());
        result = prime * result + ((getTimeVerified() == null) ? 0 : getTimeVerified().hashCode());
        result = prime * result + ((getIncomeStatus() == null) ? 0 : getIncomeStatus().hashCode());
        result = prime * result + ((getCheckingStatus() == null) ? 0 : getCheckingStatus().hashCode());
        result = prime * result + ((getInvoiceStatus() == null) ? 0 : getInvoiceStatus().hashCode());
        result = prime * result + ((getVerificationStatus() == null) ? 0 : getVerificationStatus().hashCode());
        result = prime * result + ((getFinishStatus() == null) ? 0 : getFinishStatus().hashCode());
        result = prime * result + ((getTaxRate() == null) ? 0 : getTaxRate().hashCode());
        result = prime * result + ((getPatientCode() == null) ? 0 : getPatientCode().hashCode());
        result = prime * result + ((getDoctorCode() == null) ? 0 : getDoctorCode().hashCode());
        result = prime * result + ((getBaCode() == null) ? 0 : getBaCode().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        result = prime * result + ((getAccountCode() == null) ? 0 : getAccountCode().hashCode());
        result = prime * result + ((getContractCode() == null) ? 0 : getContractCode().hashCode());
        result = prime * result + ((getInvoiceTargetType() == null) ? 0 : getInvoiceTargetType().hashCode());
        result = prime * result + ((getSettlementTargetType() == null) ? 0 : getSettlementTargetType().hashCode());
        result = prime * result + ((getProcessType() == null) ? 0 : getProcessType().hashCode());
        result = prime * result + ((getTimeProcess() == null) ? 0 : getTimeProcess().hashCode());
        result = prime * result + (Arrays.hashCode(getLabelBit()));
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getSettlementCreated() == null) ? 0 : getSettlementCreated().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getTimeFinish() == null) ? 0 : getTimeFinish().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", designCode=").append(designCode);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", caseCode=").append(caseCode);
        sb.append(", bizCode=").append(bizCode);
        sb.append(", region=").append(region);
        sb.append(", parentOrderCode=").append(parentOrderCode);
        sb.append(", reversalOrderCode=").append(reversalOrderCode);
        sb.append(", factory=").append(factory);
        sb.append(", quantity=").append(quantity);
        sb.append(", productCode=").append(productCode);
        sb.append(", modifyUid=").append(modifyUid);
        sb.append(", assignUid=").append(assignUid);
        sb.append(", createUid=").append(createUid);
        sb.append(", price=").append(price);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", currency=").append(currency);
        sb.append(", status=").append(status);
        sb.append(", timeConfirm=").append(timeConfirm);
        sb.append(", amountInvoice=").append(amountInvoice);
        sb.append(", amountVerification=").append(amountVerification);
        sb.append(", timeVerified=").append(timeVerified);
        sb.append(", incomeStatus=").append(incomeStatus);
        sb.append(", checkingStatus=").append(checkingStatus);
        sb.append(", invoiceStatus=").append(invoiceStatus);
        sb.append(", verificationStatus=").append(verificationStatus);
        sb.append(", finishStatus=").append(finishStatus);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", patientCode=").append(patientCode);
        sb.append(", doctorCode=").append(doctorCode);
        sb.append(", baCode=").append(baCode);
        sb.append(", groupCode=").append(groupCode);
        sb.append(", accountCode=").append(accountCode);
        sb.append(", contractCode=").append(contractCode);
        sb.append(", invoiceTargetType=").append(invoiceTargetType);
        sb.append(", settlementTargetType=").append(settlementTargetType);
        sb.append(", processType=").append(processType);
        sb.append(", timeProcess=").append(timeProcess);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", note=").append(note);
        sb.append(", version=").append(version);
        sb.append(", settlementCreated=").append(settlementCreated);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", timeFinish=").append(timeFinish);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}