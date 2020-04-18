package com.cloud.service.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.service.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
