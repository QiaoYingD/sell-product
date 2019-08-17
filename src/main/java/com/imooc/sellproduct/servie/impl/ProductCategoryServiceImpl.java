package com.imooc.sellproduct.servie.impl;

import com.imooc.sellproduct.mapper.ProductCategoryMapper;
import com.imooc.sellproduct.model.ProductCategory;
import com.imooc.sellproduct.servie.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> getCategoryLists(List<Integer> categoryTypeList) {
        return productCategoryMapper.getCategoryLists(categoryTypeList);
    }
}
