package com.cloud.service.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.service.product.entity.Product;
import com.cloud.service.product.service.ProductService;
import com.cloud.service.product.util.response.AjaxResponseBody;
import com.cloud.service.product.util.response.Result;
import com.cloud.service.product.util.response.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AjaxResponseBody
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public Result<Page<Product>> findAll(Integer index) {
        Page<Product> products = productService.getPage(index);
        if (null != products) {
            return Result.success(products);
        }
        return Result.failure(null);
    }

    @PostMapping
    public Result<Void> addProduct(@RequestBody Product product) {
        if (product.getName() != null && product.getPrice() != null) {
            productService.addProduct(product);
            return Result.success();
        }
        return Result.failure();
    }

    @GetMapping("/{id}")
    public Result<Product> detail(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return (null != product) ? Result.success(product) : Result.failure(ResultStatus.WRONG_PARAMETERS);
    }

    @PostMapping("/{id}")
    public Result<Product> update(@PathVariable Long id,
                                  @RequestBody Product product) {
        product.setId(id);
        product = productService.saveProduct(product);
        return (null != product) ? Result.success(product) : Result.failure(ResultStatus.WRONG_PARAMETERS);
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return Result.success(true);
    }

}
