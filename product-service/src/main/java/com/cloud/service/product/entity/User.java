package com.cloud.service.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String nickname;
    private String avatar;

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.nickname = userDto.getNickname();
        this.avatar = userDto.getAvatar();
    }

}
