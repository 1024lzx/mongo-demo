package com.lzx.mongodemo.mapper;

import com.lzx.mongodemo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserMapper {
    List<UserPO> getUserList();
}
