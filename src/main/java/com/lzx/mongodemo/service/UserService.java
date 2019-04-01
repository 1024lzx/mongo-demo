package com.lzx.mongodemo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzx.mongodemo.mapper.IUserMapper;
import com.lzx.mongodemo.po.UserPO;
import com.lzx.mongodemo.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserMapper userMapper;

    public PageInfo<UserPO> getUserList(Page page) {
        return PageHelper.startPage(page).doSelectPageInfo(() -> userMapper.getUserList());
    }
}
