package com.mbplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbplus.mapper.ProductMapper;
import com.mbplus.pojo.Product;
import com.mbplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
