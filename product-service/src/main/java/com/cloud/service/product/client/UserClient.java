package com.cloud.service.product.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="user-service")
public interface UserClient {

    @GetMapping("/user/{id}")
    JSONObject getInfo(@PathVariable Long id);

}
