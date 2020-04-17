package com.test.springcloud.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springcloud.demo.entity.ProductComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductCommentMapper extends BaseMapper<ProductComment> {
}
