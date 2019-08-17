package com.imooc.sellproduct.servie;

import com.imooc.sellproduct.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getCategoryLists(List<Integer> categoryTypeList);

}
