package com.test.springcloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.springcloud.demo.entity.ProductComment;
import com.test.springcloud.demo.mapper.ProductCommentMapper;
import com.test.springcloud.demo.service.ProductCommentService;

public class ProductCommentServiceImpl
        extends ServiceImpl<ProductCommentMapper, ProductComment>
        implements ProductCommentService {
}
