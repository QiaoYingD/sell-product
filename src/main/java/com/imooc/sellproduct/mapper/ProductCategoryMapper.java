package com.imooc.sellproduct.mapper;

import com.imooc.sellproduct.model.ProductCategory;

import java.util.List;

public interface ProductCategoryMapper {

   List<ProductCategory> getCategoryLists(List<Integer> categoryTypeList);

}
