package com.test.summary.dom.sqlserver.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TItemSku
 * @author 
 */
public class ItemSku implements Serializable {
    private String itemSkuId;

    private String itemId;

    private String colorId;

    private String sizeId;

    private String itemSkuName;

    private BigDecimal salePrice;

    private String isSale;

    private String isSaleOnWeb;

    private String productSkuId;

    private String status;

    private String unitId;

    private BigDecimal qty;

    private String packageName;

    private String isDefault;

    private static final long serialVersionUID = 1L;

    public String getItemSkuId() {
        return itemSkuId;
    }

    public void setItemSkuId(String itemSkuId) {
        this.itemSkuId = itemSkuId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getItemSkuName() {
        return itemSkuName;
    }

    public void setItemSkuName(String itemSkuName) {
        this.itemSkuName = itemSkuName;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getIsSale() {
        return isSale;
    }

    public void setIsSale(String isSale) {
        this.isSale = isSale;
    }

    public String getIsSaleOnWeb() {
        return isSaleOnWeb;
    }

    public void setIsSaleOnWeb(String isSaleOnWeb) {
        this.isSaleOnWeb = isSaleOnWeb;
    }

    public String getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(String productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
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
        ItemSku other = (ItemSku) that;
        return (this.getItemSkuId() == null ? other.getItemSkuId() == null : this.getItemSkuId().equals(other.getItemSkuId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getColorId() == null ? other.getColorId() == null : this.getColorId().equals(other.getColorId()))
            && (this.getSizeId() == null ? other.getSizeId() == null : this.getSizeId().equals(other.getSizeId()))
            && (this.getItemSkuName() == null ? other.getItemSkuName() == null : this.getItemSkuName().equals(other.getItemSkuName()))
            && (this.getSalePrice() == null ? other.getSalePrice() == null : this.getSalePrice().equals(other.getSalePrice()))
            && (this.getIsSale() == null ? other.getIsSale() == null : this.getIsSale().equals(other.getIsSale()))
            && (this.getIsSaleOnWeb() == null ? other.getIsSaleOnWeb() == null : this.getIsSaleOnWeb().equals(other.getIsSaleOnWeb()))
            && (this.getProductSkuId() == null ? other.getProductSkuId() == null : this.getProductSkuId().equals(other.getProductSkuId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getQty() == null ? other.getQty() == null : this.getQty().equals(other.getQty()))
            && (this.getPackageName() == null ? other.getPackageName() == null : this.getPackageName().equals(other.getPackageName()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemSkuId() == null) ? 0 : getItemSkuId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getColorId() == null) ? 0 : getColorId().hashCode());
        result = prime * result + ((getSizeId() == null) ? 0 : getSizeId().hashCode());
        result = prime * result + ((getItemSkuName() == null) ? 0 : getItemSkuName().hashCode());
        result = prime * result + ((getSalePrice() == null) ? 0 : getSalePrice().hashCode());
        result = prime * result + ((getIsSale() == null) ? 0 : getIsSale().hashCode());
        result = prime * result + ((getIsSaleOnWeb() == null) ? 0 : getIsSaleOnWeb().hashCode());
        result = prime * result + ((getProductSkuId() == null) ? 0 : getProductSkuId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getQty() == null) ? 0 : getQty().hashCode());
        result = prime * result + ((getPackageName() == null) ? 0 : getPackageName().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemSkuId=").append(itemSkuId);
        sb.append(", itemId=").append(itemId);
        sb.append(", colorId=").append(colorId);
        sb.append(", sizeId=").append(sizeId);
        sb.append(", itemSkuName=").append(itemSkuName);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", isSale=").append(isSale);
        sb.append(", isSaleOnWeb=").append(isSaleOnWeb);
        sb.append(", productSkuId=").append(productSkuId);
        sb.append(", status=").append(status);
        sb.append(", unitId=").append(unitId);
        sb.append(", qty=").append(qty);
        sb.append(", packageName=").append(packageName);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}