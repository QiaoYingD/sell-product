package com.imooc.sellproduct.controller;

import com.imooc.sellproduct.VO.ProductInfoVO;
import com.imooc.sellproduct.VO.ProductVo;
import com.imooc.sellproduct.VO.ResultVO;
import com.imooc.sellproduct.mapper.ProductInfoMapper;
import com.imooc.sellproduct.model.ProductCategory;
import com.imooc.sellproduct.model.ProductInfo;
import com.imooc.sellproduct.servie.ProductCategoryService;
import com.imooc.sellproduct.servie.ProductService;
import com.imooc.sellproduct.utils.ResultUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 1.查询所有在架商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/getList")
    public ResultVO<ProductVo> getList() {
        //查询所有在架商品
        List<ProductInfo> productList = productService.getProductLists();
        //获取类目type类型
        List<Integer> categoryTyptList = productList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        //获取类目列表
        List<ProductCategory> CategoryList = productCategoryService.getCategoryLists(categoryTyptList);
        //构造数据
        List<ProductVo> productVoList = new LinkedList<>();
        for (ProductCategory productCategory : CategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new LinkedList<>();
            for (ProductInfo productInfo : productList) {
                if (productCategory.getCategoryType() == productInfo.getCategoryType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVo.setProductInfoVOList(productInfoVOList);
            productVoList.add(productVo);
        }
        return ResultUtils.success(productVoList);
    }


}
