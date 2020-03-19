package com.test.summary.dom.sqlserver.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TItemSku
 * @author 
 */
@Data
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


}