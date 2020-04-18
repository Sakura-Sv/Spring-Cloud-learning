package com.test.springcloud.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.springcloud.demo.entity.Product;
import com.test.springcloud.demo.entity.ProductComment;
import com.test.springcloud.demo.service.ProductCommentService;
import com.test.springcloud.demo.service.ProductService;
import com.test.springcloud.demo.util.response.AjaxResponseBody;
import com.test.springcloud.demo.util.response.Result;
import com.test.springcloud.demo.util.response.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@AjaxResponseBody
@RestController
@RequestMapping("/comment")
public class ProductCommentController {

    @Autowired
    ProductCommentService productCommentService;

    @GetMapping
    public Result<Page<ProductComment>> findAll(Integer index) {
        Page<ProductComment> products = productCommentService.getPage(index);
        if (null != products) {
            return Result.success(products);
        }
        return Result.failure(null);
    }

    @PostMapping
    public Result<Void> postComment(@RequestBody ProductComment comment) {
        if (comment.getAuthorId() != null && comment.getProductId() != null) {
            productCommentService.postComment(comment);
            return Result.success();
        }
        return Result.failure();
    }

}
