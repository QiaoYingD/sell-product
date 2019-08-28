package com.imooc.sellproduct.exception;

import com.imooc.sellproduct.enums.ResultEnum;

public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMesage());
        this.code = resultEnum.getCode();
    }
}
