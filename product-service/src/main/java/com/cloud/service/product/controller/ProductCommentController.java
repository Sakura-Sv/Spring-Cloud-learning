package com.cloud.service.product.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.service.product.client.UserClient;
import com.cloud.service.product.entity.ProductComment;
import com.cloud.service.product.entity.UserDto;
import com.cloud.service.product.service.ProductCommentService;
import com.cloud.service.product.util.response.AjaxResponseBody;
import com.cloud.service.product.util.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@AjaxResponseBody
@RestController
@RequestMapping("/comment")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @Autowired
    private UserClient userClient;

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

    @GetMapping("/test/{id}")
    public UserDto loadUser(@PathVariable Long id){
        JSONObject data = userClient.getInfo(id);
        return Result.parseData(data, UserDto.class);
    }

}
