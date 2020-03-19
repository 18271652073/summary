package com.test.summary.dom.mysql.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_order_base
 * @author 
 */
public class OrderBase implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * Billing号码（90订单号）
     */
    private String billingId;

    /**
     * 销售订单,订单号（30）
     */
    private String orderIdThree;

    /**
     * 主数据包号
     */
    private String parentPackageCode;

    /**
     * 销售组织
     */
    private String saleOrg;

    /**
     * 公司代码
     */
    private String companyCode;

    /**
     * 产品组
     */
    private String productGroup;

    /**
     * 销售渠道
     */
    private String saleChannel;

    /**
     * 客户号码
     */
    private String customerCode;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 开票方
     */
    private String invoiceCode;

    /**
     * 开票方名称
     */
    private String invoiceName;

    /**
     * 送达方
     */
    private String deliveryCode;

    /**
     * 送达方名称
     */
    private String deliveryName;

    /**
     * 利润中心
     */
    private String profitCenterCode;

    /**
     * 利润中心描述
     */
    private String profitCenterName;

    /**
     * 订单税率
     */
    private String taxRate;

    /**
     * 客户订单号
     */
    private String customerOrderId;

    /**
     * 客户组
     */
    private String customerGroup;

    /**
     * 销售订单类型
     */
    private String saleOrderType;

    /**
     * 销售订单类型名称
     */
    private String saleOrderTypeName;

    /**
     * 直销包号
     */
    private String dsPackageId;

    /**
     * Billing类别
     */
    private String billingCategory;

    /**
     * 发票总类型  F5等
     */
    private String invoiceTotalType;

    /**
     * 开票类型
               1:纸质增票、2:纸质普票、3:电子增票、4:电子普票、5:纸质增票红票、6:纸质普票红票、7：电子增票红票、8：电子普票红票
     */
    private String invoiceType;

    /**
     * 行数
     */
    private Integer lineNumber;

    /**
     * 出具发票日期
     */
    private Date invoiceDate;

    /**
     * Billing原值
     */
    private BigDecimal billingOriginalValue;

    /**
     * 折前原值
     */
    private BigDecimal originalValue;

    /**
     * 含税净额
     */
    private BigDecimal taxInclusiveValue;

    /**
     * Billing净额
     */
    private BigDecimal billingInclusiveValue;

    /**
     * Billing税额
     */
    private BigDecimal billingTaxInclusiveValue;

    /**
     * 差价
     */
    private BigDecimal priceDifference;

    /**
     * 票折率
     */
    private BigDecimal discountPercent;

    /**
     * 票折金额
     */
    private BigDecimal discountValue;

    /**
     * 费用率
     */
    private BigDecimal expenseRatio;

    /**
     * 费用金额
     */
    private BigDecimal expenseValue;

    /**
     * 尾差
     */
    private BigDecimal tailDifference;

    /**
     * 数据包号
     */
    private String packageId;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 寄送地址
     */
    private String deliveryAddress;

    /**
     * 收件公司
     */
    private String consigneeCompany;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 固定电话
     */
    private String phone;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 快递类型
     */
    private String expressType;

    /**
     * 是否需要货号
     */
    private String isNeedCode;

    /**
     * 是否需要收据
     */
    private String isNeedReceipt;

    /**
     * 是否缺少税收分类编码
     */
    private String isLackTaxClassificationCode;

    /**
     * 是否税差异常
     */
    private String isTaxDifferenceAbnormal;

    /**
     * 打包状态
            1：已打包——自动
            2：已打包——手动
            3：未打包
     */
    private String packageStatus;

    /**
     * 开票类型（正1、红2）
     */
    private String billingType;

    /**
     * 配送费
     */
    private BigDecimal deliveryCost;

    /**
     * 配送数量
     */
    private Integer deliveryQty;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建者
     */
    private String addNo;

    /**
     * 创建时间
     */
    private Date addTime;

    /**
     * 修改者
     */
    private String updateNo;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public String getOrderIdThree() {
        return orderIdThree;
    }

    public void setOrderIdThree(String orderIdThree) {
        this.orderIdThree = orderIdThree;
    }

    public String getParentPackageCode() {
        return parentPackageCode;
    }

    public void setParentPackageCode(String parentPackageCode) {
        this.parentPackageCode = parentPackageCode;
    }

    public String getSaleOrg() {
        return saleOrg;
    }

    public void setSaleOrg(String saleOrg) {
        this.saleOrg = saleOrg;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getSaleChannel() {
        return saleChannel;
    }

    public void setSaleChannel(String saleChannel) {
        this.saleChannel = saleChannel;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getProfitCenterCode() {
        return profitCenterCode;
    }

    public void setProfitCenterCode(String profitCenterCode) {
        this.profitCenterCode = profitCenterCode;
    }

    public String getProfitCenterName() {
        return profitCenterName;
    }

    public void setProfitCenterName(String profitCenterName) {
        this.profitCenterName = profitCenterName;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public String getSaleOrderType() {
        return saleOrderType;
    }

    public void setSaleOrderType(String saleOrderType) {
        this.saleOrderType = saleOrderType;
    }

    public String getSaleOrderTypeName() {
        return saleOrderTypeName;
    }

    public void setSaleOrderTypeName(String saleOrderTypeName) {
        this.saleOrderTypeName = saleOrderTypeName;
    }

    public String getDsPackageId() {
        return dsPackageId;
    }

    public void setDsPackageId(String dsPackageId) {
        this.dsPackageId = dsPackageId;
    }

    public String getBillingCategory() {
        return billingCategory;
    }

    public void setBillingCategory(String billingCategory) {
        this.billingCategory = billingCategory;
    }

    public String getInvoiceTotalType() {
        return invoiceTotalType;
    }

    public void setInvoiceTotalType(String invoiceTotalType) {
        this.invoiceTotalType = invoiceTotalType;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getBillingOriginalValue() {
        return billingOriginalValue;
    }

    public void setBillingOriginalValue(BigDecimal billingOriginalValue) {
        this.billingOriginalValue = billingOriginalValue;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
    }

    public BigDecimal getTaxInclusiveValue() {
        return taxInclusiveValue;
    }

    public void setTaxInclusiveValue(BigDecimal taxInclusiveValue) {
        this.taxInclusiveValue = taxInclusiveValue;
    }

    public BigDecimal getBillingInclusiveValue() {
        return billingInclusiveValue;
    }

    public void setBillingInclusiveValue(BigDecimal billingInclusiveValue) {
        this.billingInclusiveValue = billingInclusiveValue;
    }

    public BigDecimal getBillingTaxInclusiveValue() {
        return billingTaxInclusiveValue;
    }

    public void setBillingTaxInclusiveValue(BigDecimal billingTaxInclusiveValue) {
        this.billingTaxInclusiveValue = billingTaxInclusiveValue;
    }

    public BigDecimal getPriceDifference() {
        return priceDifference;
    }

    public void setPriceDifference(BigDecimal priceDifference) {
        this.priceDifference = priceDifference;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getExpenseRatio() {
        return expenseRatio;
    }

    public void setExpenseRatio(BigDecimal expenseRatio) {
        this.expenseRatio = expenseRatio;
    }

    public BigDecimal getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(BigDecimal expenseValue) {
        this.expenseValue = expenseValue;
    }

    public BigDecimal getTailDifference() {
        return tailDifference;
    }

    public void setTailDifference(BigDecimal tailDifference) {
        this.tailDifference = tailDifference;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getConsigneeCompany() {
        return consigneeCompany;
    }

    public void setConsigneeCompany(String consigneeCompany) {
        this.consigneeCompany = consigneeCompany;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getIsNeedCode() {
        return isNeedCode;
    }

    public void setIsNeedCode(String isNeedCode) {
        this.isNeedCode = isNeedCode;
    }

    public String getIsNeedReceipt() {
        return isNeedReceipt;
    }

    public void setIsNeedReceipt(String isNeedReceipt) {
        this.isNeedReceipt = isNeedReceipt;
    }

    public String getIsLackTaxClassificationCode() {
        return isLackTaxClassificationCode;
    }

    public void setIsLackTaxClassificationCode(String isLackTaxClassificationCode) {
        this.isLackTaxClassificationCode = isLackTaxClassificationCode;
    }

    public String getIsTaxDifferenceAbnormal() {
        return isTaxDifferenceAbnormal;
    }

    public void setIsTaxDifferenceAbnormal(String isTaxDifferenceAbnormal) {
        this.isTaxDifferenceAbnormal = isTaxDifferenceAbnormal;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Integer getDeliveryQty() {
        return deliveryQty;
    }

    public void setDeliveryQty(Integer deliveryQty) {
        this.deliveryQty = deliveryQty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddNo() {
        return addNo;
    }

    public void setAddNo(String addNo) {
        this.addNo = addNo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getUpdateNo() {
        return updateNo;
    }

    public void setUpdateNo(String updateNo) {
        this.updateNo = updateNo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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
        OrderBase other = (OrderBase) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBillingId() == null ? other.getBillingId() == null : this.getBillingId().equals(other.getBillingId()))
            && (this.getOrderIdThree() == null ? other.getOrderIdThree() == null : this.getOrderIdThree().equals(other.getOrderIdThree()))
            && (this.getParentPackageCode() == null ? other.getParentPackageCode() == null : this.getParentPackageCode().equals(other.getParentPackageCode()))
            && (this.getSaleOrg() == null ? other.getSaleOrg() == null : this.getSaleOrg().equals(other.getSaleOrg()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getProductGroup() == null ? other.getProductGroup() == null : this.getProductGroup().equals(other.getProductGroup()))
            && (this.getSaleChannel() == null ? other.getSaleChannel() == null : this.getSaleChannel().equals(other.getSaleChannel()))
            && (this.getCustomerCode() == null ? other.getCustomerCode() == null : this.getCustomerCode().equals(other.getCustomerCode()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getInvoiceCode() == null ? other.getInvoiceCode() == null : this.getInvoiceCode().equals(other.getInvoiceCode()))
            && (this.getInvoiceName() == null ? other.getInvoiceName() == null : this.getInvoiceName().equals(other.getInvoiceName()))
            && (this.getDeliveryCode() == null ? other.getDeliveryCode() == null : this.getDeliveryCode().equals(other.getDeliveryCode()))
            && (this.getDeliveryName() == null ? other.getDeliveryName() == null : this.getDeliveryName().equals(other.getDeliveryName()))
            && (this.getProfitCenterCode() == null ? other.getProfitCenterCode() == null : this.getProfitCenterCode().equals(other.getProfitCenterCode()))
            && (this.getProfitCenterName() == null ? other.getProfitCenterName() == null : this.getProfitCenterName().equals(other.getProfitCenterName()))
            && (this.getTaxRate() == null ? other.getTaxRate() == null : this.getTaxRate().equals(other.getTaxRate()))
            && (this.getCustomerOrderId() == null ? other.getCustomerOrderId() == null : this.getCustomerOrderId().equals(other.getCustomerOrderId()))
            && (this.getCustomerGroup() == null ? other.getCustomerGroup() == null : this.getCustomerGroup().equals(other.getCustomerGroup()))
            && (this.getSaleOrderType() == null ? other.getSaleOrderType() == null : this.getSaleOrderType().equals(other.getSaleOrderType()))
            && (this.getSaleOrderTypeName() == null ? other.getSaleOrderTypeName() == null : this.getSaleOrderTypeName().equals(other.getSaleOrderTypeName()))
            && (this.getDsPackageId() == null ? other.getDsPackageId() == null : this.getDsPackageId().equals(other.getDsPackageId()))
            && (this.getBillingCategory() == null ? other.getBillingCategory() == null : this.getBillingCategory().equals(other.getBillingCategory()))
            && (this.getInvoiceTotalType() == null ? other.getInvoiceTotalType() == null : this.getInvoiceTotalType().equals(other.getInvoiceTotalType()))
            && (this.getInvoiceType() == null ? other.getInvoiceType() == null : this.getInvoiceType().equals(other.getInvoiceType()))
            && (this.getLineNumber() == null ? other.getLineNumber() == null : this.getLineNumber().equals(other.getLineNumber()))
            && (this.getInvoiceDate() == null ? other.getInvoiceDate() == null : this.getInvoiceDate().equals(other.getInvoiceDate()))
            && (this.getBillingOriginalValue() == null ? other.getBillingOriginalValue() == null : this.getBillingOriginalValue().equals(other.getBillingOriginalValue()))
            && (this.getOriginalValue() == null ? other.getOriginalValue() == null : this.getOriginalValue().equals(other.getOriginalValue()))
            && (this.getTaxInclusiveValue() == null ? other.getTaxInclusiveValue() == null : this.getTaxInclusiveValue().equals(other.getTaxInclusiveValue()))
            && (this.getBillingInclusiveValue() == null ? other.getBillingInclusiveValue() == null : this.getBillingInclusiveValue().equals(other.getBillingInclusiveValue()))
            && (this.getBillingTaxInclusiveValue() == null ? other.getBillingTaxInclusiveValue() == null : this.getBillingTaxInclusiveValue().equals(other.getBillingTaxInclusiveValue()))
            && (this.getPriceDifference() == null ? other.getPriceDifference() == null : this.getPriceDifference().equals(other.getPriceDifference()))
            && (this.getDiscountPercent() == null ? other.getDiscountPercent() == null : this.getDiscountPercent().equals(other.getDiscountPercent()))
            && (this.getDiscountValue() == null ? other.getDiscountValue() == null : this.getDiscountValue().equals(other.getDiscountValue()))
            && (this.getExpenseRatio() == null ? other.getExpenseRatio() == null : this.getExpenseRatio().equals(other.getExpenseRatio()))
            && (this.getExpenseValue() == null ? other.getExpenseValue() == null : this.getExpenseValue().equals(other.getExpenseValue()))
            && (this.getTailDifference() == null ? other.getTailDifference() == null : this.getTailDifference().equals(other.getTailDifference()))
            && (this.getPackageId() == null ? other.getPackageId() == null : this.getPackageId().equals(other.getPackageId()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getDeliveryAddress() == null ? other.getDeliveryAddress() == null : this.getDeliveryAddress().equals(other.getDeliveryAddress()))
            && (this.getConsigneeCompany() == null ? other.getConsigneeCompany() == null : this.getConsigneeCompany().equals(other.getConsigneeCompany()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getExpressType() == null ? other.getExpressType() == null : this.getExpressType().equals(other.getExpressType()))
            && (this.getIsNeedCode() == null ? other.getIsNeedCode() == null : this.getIsNeedCode().equals(other.getIsNeedCode()))
            && (this.getIsNeedReceipt() == null ? other.getIsNeedReceipt() == null : this.getIsNeedReceipt().equals(other.getIsNeedReceipt()))
            && (this.getIsLackTaxClassificationCode() == null ? other.getIsLackTaxClassificationCode() == null : this.getIsLackTaxClassificationCode().equals(other.getIsLackTaxClassificationCode()))
            && (this.getIsTaxDifferenceAbnormal() == null ? other.getIsTaxDifferenceAbnormal() == null : this.getIsTaxDifferenceAbnormal().equals(other.getIsTaxDifferenceAbnormal()))
            && (this.getPackageStatus() == null ? other.getPackageStatus() == null : this.getPackageStatus().equals(other.getPackageStatus()))
            && (this.getBillingType() == null ? other.getBillingType() == null : this.getBillingType().equals(other.getBillingType()))
            && (this.getDeliveryCost() == null ? other.getDeliveryCost() == null : this.getDeliveryCost().equals(other.getDeliveryCost()))
            && (this.getDeliveryQty() == null ? other.getDeliveryQty() == null : this.getDeliveryQty().equals(other.getDeliveryQty()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAddNo() == null ? other.getAddNo() == null : this.getAddNo().equals(other.getAddNo()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateNo() == null ? other.getUpdateNo() == null : this.getUpdateNo().equals(other.getUpdateNo()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBillingId() == null) ? 0 : getBillingId().hashCode());
        result = prime * result + ((getOrderIdThree() == null) ? 0 : getOrderIdThree().hashCode());
        result = prime * result + ((getParentPackageCode() == null) ? 0 : getParentPackageCode().hashCode());
        result = prime * result + ((getSaleOrg() == null) ? 0 : getSaleOrg().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getProductGroup() == null) ? 0 : getProductGroup().hashCode());
        result = prime * result + ((getSaleChannel() == null) ? 0 : getSaleChannel().hashCode());
        result = prime * result + ((getCustomerCode() == null) ? 0 : getCustomerCode().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getInvoiceCode() == null) ? 0 : getInvoiceCode().hashCode());
        result = prime * result + ((getInvoiceName() == null) ? 0 : getInvoiceName().hashCode());
        result = prime * result + ((getDeliveryCode() == null) ? 0 : getDeliveryCode().hashCode());
        result = prime * result + ((getDeliveryName() == null) ? 0 : getDeliveryName().hashCode());
        result = prime * result + ((getProfitCenterCode() == null) ? 0 : getProfitCenterCode().hashCode());
        result = prime * result + ((getProfitCenterName() == null) ? 0 : getProfitCenterName().hashCode());
        result = prime * result + ((getTaxRate() == null) ? 0 : getTaxRate().hashCode());
        result = prime * result + ((getCustomerOrderId() == null) ? 0 : getCustomerOrderId().hashCode());
        result = prime * result + ((getCustomerGroup() == null) ? 0 : getCustomerGroup().hashCode());
        result = prime * result + ((getSaleOrderType() == null) ? 0 : getSaleOrderType().hashCode());
        result = prime * result + ((getSaleOrderTypeName() == null) ? 0 : getSaleOrderTypeName().hashCode());
        result = prime * result + ((getDsPackageId() == null) ? 0 : getDsPackageId().hashCode());
        result = prime * result + ((getBillingCategory() == null) ? 0 : getBillingCategory().hashCode());
        result = prime * result + ((getInvoiceTotalType() == null) ? 0 : getInvoiceTotalType().hashCode());
        result = prime * result + ((getInvoiceType() == null) ? 0 : getInvoiceType().hashCode());
        result = prime * result + ((getLineNumber() == null) ? 0 : getLineNumber().hashCode());
        result = prime * result + ((getInvoiceDate() == null) ? 0 : getInvoiceDate().hashCode());
        result = prime * result + ((getBillingOriginalValue() == null) ? 0 : getBillingOriginalValue().hashCode());
        result = prime * result + ((getOriginalValue() == null) ? 0 : getOriginalValue().hashCode());
        result = prime * result + ((getTaxInclusiveValue() == null) ? 0 : getTaxInclusiveValue().hashCode());
        result = prime * result + ((getBillingInclusiveValue() == null) ? 0 : getBillingInclusiveValue().hashCode());
        result = prime * result + ((getBillingTaxInclusiveValue() == null) ? 0 : getBillingTaxInclusiveValue().hashCode());
        result = prime * result + ((getPriceDifference() == null) ? 0 : getPriceDifference().hashCode());
        result = prime * result + ((getDiscountPercent() == null) ? 0 : getDiscountPercent().hashCode());
        result = prime * result + ((getDiscountValue() == null) ? 0 : getDiscountValue().hashCode());
        result = prime * result + ((getExpenseRatio() == null) ? 0 : getExpenseRatio().hashCode());
        result = prime * result + ((getExpenseValue() == null) ? 0 : getExpenseValue().hashCode());
        result = prime * result + ((getTailDifference() == null) ? 0 : getTailDifference().hashCode());
        result = prime * result + ((getPackageId() == null) ? 0 : getPackageId().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getDeliveryAddress() == null) ? 0 : getDeliveryAddress().hashCode());
        result = prime * result + ((getConsigneeCompany() == null) ? 0 : getConsigneeCompany().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getExpressType() == null) ? 0 : getExpressType().hashCode());
        result = prime * result + ((getIsNeedCode() == null) ? 0 : getIsNeedCode().hashCode());
        result = prime * result + ((getIsNeedReceipt() == null) ? 0 : getIsNeedReceipt().hashCode());
        result = prime * result + ((getIsLackTaxClassificationCode() == null) ? 0 : getIsLackTaxClassificationCode().hashCode());
        result = prime * result + ((getIsTaxDifferenceAbnormal() == null) ? 0 : getIsTaxDifferenceAbnormal().hashCode());
        result = prime * result + ((getPackageStatus() == null) ? 0 : getPackageStatus().hashCode());
        result = prime * result + ((getBillingType() == null) ? 0 : getBillingType().hashCode());
        result = prime * result + ((getDeliveryCost() == null) ? 0 : getDeliveryCost().hashCode());
        result = prime * result + ((getDeliveryQty() == null) ? 0 : getDeliveryQty().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAddNo() == null) ? 0 : getAddNo().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateNo() == null) ? 0 : getUpdateNo().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", billingId=").append(billingId);
        sb.append(", orderIdThree=").append(orderIdThree);
        sb.append(", parentPackageCode=").append(parentPackageCode);
        sb.append(", saleOrg=").append(saleOrg);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", productGroup=").append(productGroup);
        sb.append(", saleChannel=").append(saleChannel);
        sb.append(", customerCode=").append(customerCode);
        sb.append(", customerName=").append(customerName);
        sb.append(", invoiceCode=").append(invoiceCode);
        sb.append(", invoiceName=").append(invoiceName);
        sb.append(", deliveryCode=").append(deliveryCode);
        sb.append(", deliveryName=").append(deliveryName);
        sb.append(", profitCenterCode=").append(profitCenterCode);
        sb.append(", profitCenterName=").append(profitCenterName);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", customerOrderId=").append(customerOrderId);
        sb.append(", customerGroup=").append(customerGroup);
        sb.append(", saleOrderType=").append(saleOrderType);
        sb.append(", saleOrderTypeName=").append(saleOrderTypeName);
        sb.append(", dsPackageId=").append(dsPackageId);
        sb.append(", billingCategory=").append(billingCategory);
        sb.append(", invoiceTotalType=").append(invoiceTotalType);
        sb.append(", invoiceType=").append(invoiceType);
        sb.append(", lineNumber=").append(lineNumber);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", billingOriginalValue=").append(billingOriginalValue);
        sb.append(", originalValue=").append(originalValue);
        sb.append(", taxInclusiveValue=").append(taxInclusiveValue);
        sb.append(", billingInclusiveValue=").append(billingInclusiveValue);
        sb.append(", billingTaxInclusiveValue=").append(billingTaxInclusiveValue);
        sb.append(", priceDifference=").append(priceDifference);
        sb.append(", discountPercent=").append(discountPercent);
        sb.append(", discountValue=").append(discountValue);
        sb.append(", expenseRatio=").append(expenseRatio);
        sb.append(", expenseValue=").append(expenseValue);
        sb.append(", tailDifference=").append(tailDifference);
        sb.append(", packageId=").append(packageId);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", deliveryAddress=").append(deliveryAddress);
        sb.append(", consigneeCompany=").append(consigneeCompany);
        sb.append(", contact=").append(contact);
        sb.append(", phone=").append(phone);
        sb.append(", mobile=").append(mobile);
        sb.append(", expressType=").append(expressType);
        sb.append(", isNeedCode=").append(isNeedCode);
        sb.append(", isNeedReceipt=").append(isNeedReceipt);
        sb.append(", isLackTaxClassificationCode=").append(isLackTaxClassificationCode);
        sb.append(", isTaxDifferenceAbnormal=").append(isTaxDifferenceAbnormal);
        sb.append(", packageStatus=").append(packageStatus);
        sb.append(", billingType=").append(billingType);
        sb.append(", deliveryCost=").append(deliveryCost);
        sb.append(", deliveryQty=").append(deliveryQty);
        sb.append(", status=").append(status);
        sb.append(", addNo=").append(addNo);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateNo=").append(updateNo);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}