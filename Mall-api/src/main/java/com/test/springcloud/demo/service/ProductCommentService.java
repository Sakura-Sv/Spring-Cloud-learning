package com.test.springcloud.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.springcloud.demo.entity.ProductComment;

public interface ProductCommentService {

    Page<ProductComment> getPage(Integer index);

    void postComment(ProductComment comment);

}
