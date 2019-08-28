package com.imooc.sellproduct.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfo {

    private String productId;

    private String productName;

    private String productType;

    private Integer productStock;

    private BigDecimal productPrice;

    private String productDescription;

    private String productIcon;

    private String productStatus;

    private Integer categoryType;

}
