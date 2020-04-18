package com.test.springcloud.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.springcloud.demo.entity.Product;
import com.test.springcloud.demo.entity.ProductComment;
import com.test.springcloud.demo.service.ProductService;
import com.test.springcloud.demo.util.response.AjaxResponseBody;
import com.test.springcloud.demo.util.response.Result;
import com.test.springcloud.demo.util.response.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AjaxResponseBody
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

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
