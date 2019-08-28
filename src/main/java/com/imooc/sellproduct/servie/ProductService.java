package com.imooc.sellproduct.servie;

import com.imooc.sellproduct.dto.CartDto;
import com.imooc.sellproduct.model.ProductInfo;

import java.util.List;

public interface ProductService {


    List<ProductInfo> getProductLists();

    List<ProductInfo> getProductByIdList(List<String> productId);

    void decreaseStock(List<CartDto> cartDtos);

}
