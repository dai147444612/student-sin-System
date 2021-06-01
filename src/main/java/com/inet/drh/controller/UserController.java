package com.inet.drh.controller;


import com.inet.drh.custom.UserCustom;
import com.inet.drh.entity.dto.Login;
import com.inet.drh.entity.dto.Register;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = {"用户模块"})
@RequestMapping("/student")
public class UserController {
    @Resource
    private UserCustom userCustom;


    //注册
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public String register(@RequestBody Register register) {
        return userCustom.register(register);
    }

    //登录
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        return userCustom.Login(login);
    }

    //退出登录
    @ApiOperation("用户退出")
    @GetMapping("/logout")
    public String Logout(@RequestHeader(value = "Token") String token) {
        return userCustom.Logout(token);
    }

    //签到
    @ApiOperation("用户签到")
    @GetMapping("/sinin")
    public String sinin(@RequestHeader(value = "Token") String token) {
        return userCustom.sinin(token);
    }

    //签退
    @ApiOperation("用户签退")
    @GetMapping("/sinout")
    public String sinout(@RequestHeader(value = "Token") String token) {
        return userCustom.sinout(token);
    }

    //查询签到时长
    @ApiOperation("用户查询时长")
    @GetMapping("/findAccount")
    public String findAccount(@RequestHeader(value = "Token") String token) {
        return userCustom.findAccount(token);
    }
}
