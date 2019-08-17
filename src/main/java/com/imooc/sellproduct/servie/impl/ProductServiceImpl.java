package com.imooc.sellproduct.servie.impl;

import com.imooc.sellproduct.mapper.ProductInfoMapper;
import com.imooc.sellproduct.model.ProductInfo;
import com.imooc.sellproduct.servie.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getProductLists() {

        return productInfoMapper.getProductLists();
    }
}
