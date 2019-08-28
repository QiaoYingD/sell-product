package com.imooc.sellproduct.servie.impl;

import com.imooc.sellproduct.dto.CartDto;
import com.imooc.sellproduct.enums.ResultEnum;
import com.imooc.sellproduct.exception.ProductException;
import com.imooc.sellproduct.mapper.ProductInfoMapper;
import com.imooc.sellproduct.model.ProductInfo;
import com.imooc.sellproduct.servie.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<ProductInfo> getProductByIdList(List<String> productId) {
        return productInfoMapper.getProductByIdList(productId);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtos) {
        for (CartDto cartDto : cartDtos) {
            ProductInfo productInfo = new ProductInfo();
            BeanUtils.copyProperties(cartDto,productInfo);
            ProductInfo product = productInfoMapper.getProduct(productInfo);
            if (product == null) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int result = product.getProductStock() - cartDto.getProductStock();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoMapper.updateProduct(productInfo);
        }
    }
}
