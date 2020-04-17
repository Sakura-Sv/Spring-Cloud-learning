package com.test.springcloud.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springcloud.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
