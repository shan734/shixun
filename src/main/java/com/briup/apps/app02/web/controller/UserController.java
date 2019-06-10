package com.briup.apps.app02.web.controller;


import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.service.IUserService;
import com.briup.apps.app02.utils.MessageUtil;
import com.briup.apps.app02.utils.Message;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/findAll")
    public Message findAll(){
        return MessageUtil.success("sss",userService.findAll());
    }

    @ApiOperation("通过id查询")
    @GetMapping("/findById")
    public Message findById(@ApiParam(value = "主键",required = true)
                         @RequestParam(value = "id") long id) {
        return MessageUtil.success("sss",userService.findById(id));
    }

    @ApiOperation("保存或更新用户信息")
    @GetMapping("saveOrUpdate")
    public String saveOrUpdate(User user){
        try {
            userService.saveOrUpdate(user);
            return "保存成功!";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @ApiOperation("通过id删除用户信息")
    @GetMapping("deleteById")
    public String deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            userService.deleteById(id);
            return "删除成功!";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}