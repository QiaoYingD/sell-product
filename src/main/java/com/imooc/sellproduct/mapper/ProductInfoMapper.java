package com.imooc.sellproduct.mapper;

import com.imooc.sellproduct.model.ProductInfo;

import java.util.List;

public interface ProductInfoMapper {

    List<ProductInfo> getProductLists();

    ProductInfo getProduct(ProductInfo productInfo);

    List<ProductInfo> getProductByIdList(List<String> productId);

    void updateProduct(ProductInfo productInfo);

}
