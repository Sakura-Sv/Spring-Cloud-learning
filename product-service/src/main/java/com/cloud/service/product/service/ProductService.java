package com.cloud.service.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.service.product.entity.Product;

public interface ProductService {

    Page<Product> getPage(Integer index);

    Product getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);

    void addProduct(Product product);
}
