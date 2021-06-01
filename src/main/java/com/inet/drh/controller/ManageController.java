package com.inet.drh.controller;

import com.inet.drh.custom.ManageCustom;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Api(tags = {"管理员模块"})
@RequestMapping("/manage")
public class ManageController {
    @Resource
    private ManageCustom manageCustom;

    @GetMapping("/findPage")
    @ApiOperation("管理员分页")
    public String findPage(@RequestHeader(value = "Token") String token,
                           @RequestParam(value = "offset") Integer offset,
                           @RequestParam(value = "page") Integer page) {
        return String.valueOf(manageCustom.findPage(offset, page));

    }

    @GetMapping("/agreeSin")
    @ApiOperation("管理员同意签到")
    @RequiresPermissions(value = {"agreeSin"})
    public String agreeSin(@RequestHeader(value = "Token") String token) {
        return manageCustom.agreeSin(token);
    }


    @GetMapping("/refuseSin")
    @ApiOperation("管理员拒绝签到")
    @RequiresPermissions(value = {"refuseSin"})
    public String refuseSin(@RequestHeader(value = "Token") String token) {
        return manageCustom.refuseSin(token);
    }
}
