package com.cloud.service.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.service.product.entity.ProductComment;
import com.cloud.service.product.service.ProductCommentService;
import com.cloud.service.product.util.response.AjaxResponseBody;
import com.cloud.service.product.util.response.Result;
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
