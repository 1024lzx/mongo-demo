package com.lzx.mongodemo.web;

import com.github.pagehelper.PageInfo;
import com.lzx.mongodemo.po.UserPO;
import com.lzx.mongodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public PageInfo<UserPO> getUserList(@ModelAttribute Page page){
        return userService.getUserList(page);
    }
}
