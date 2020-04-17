package com.test.springcloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.springcloud.demo.entity.ProductComment;
import com.test.springcloud.demo.mapper.ProductCommentMapper;
import com.test.springcloud.demo.service.ProductCommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductCommentServiceImpl
        extends ServiceImpl<ProductCommentMapper, ProductComment>
        implements ProductCommentService {

    @Override
    public Page<ProductComment> getPage(Integer index) {
        Page<ProductComment> page = new Page<>(index, 20);
        return this.page(page);
    }

    @Override
    public void postComment(ProductComment comment) {
        comment.setCreateTime(LocalDateTime.now());
        this.save(comment);
    }

}
