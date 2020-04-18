package com.cloud.service.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.service.product.entity.ProductComment;

public interface ProductCommentService {

    Page<ProductComment> getPage(Integer index);

    void postComment(ProductComment comment);

}
