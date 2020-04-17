package com.test.springcloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.springcloud.demo.entity.Product;
import com.test.springcloud.demo.mapper.ProductMapper;
import com.test.springcloud.demo.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
