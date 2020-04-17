package com.test.springcloud.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.springcloud.demo.entity.Product;

public interface ProductService{

    Page<Product> getPage(Integer index);

    Product getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);

}
