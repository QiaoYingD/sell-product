package com.imooc.sellproduct.controller;


import com.imooc.sellproduct.servie.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductService productService;

    @Test
    public void getProductForOrder() {
        productService.getProductByIdList(Arrays.asList("15787519636616022", "164103465734242707"));
    }
}
