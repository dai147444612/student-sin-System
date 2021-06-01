package com.inet.drh.custom.Impl;

import com.inet.drh.custom.UserCustom;
import com.inet.drh.entity.dto.Login;
import com.inet.drh.entity.dto.Register;
import com.inet.drh.entity.po.Check;
import com.inet.drh.entity.po.Permission;
import com.inet.drh.entity.po.User;
import com.inet.drh.entity.vo.AllUserInfo;
import com.inet.drh.mapper.CheckMapper;
import com.inet.drh.service.*;
import com.inet.drh.util.JwtUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Service
public class UserCustomImpl implements UserCustom {
    @Resource
    private CheckMapper checkMapper;
    @Resource
    private ICheckService iCheckService;
    @Resource
    private IPermission_userService iPermission_userService;

    @Resource
    private IPermissionService iPermissionService;

    @Resource
    private IRole_userService iRole_userService;

    @Resource
    private IRoleService iRoleService;

    @Resource
    private IUserService iUserService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //注册
    @Override
    public String register(Register register) {
        if (register.getNumber().equals(null)) {
            return "请填写学号";
        }
        if (register.getClasses().equals(null)) {
            return "请填写班级";
        }
        if (register.getPassword().equals(null)) {
            return "密码不可为空";
        }
        if (register.getUsername().equals(null)) {
            return "用户名不能为空";
        }
        if (register.getPhone().equals(null)) {
            return "请填写电话";
        } else if (register.getPhone().length() != 11) {
            return "电话格式有误";
        }
        if (!Pattern.matches("^1[3-9]\\d{9}$", register.getPhone())) {
            return "电话格式有误";
        }

        User user = new User();
        user.setNumber(register.getNumber());
        user.setClasses(register.getClasses());
        user.setPhone(register.getPhone());
        user.setUsername(register.getUsername());
        user.setPassword(register.getPassword());
        user.setName(register.getName());
        if (iUserService.login(user.getUsername(), user.getPassword()) != null) {
            return "用户已存在";
        }
        //注册
        iUserService.registerUser(user);
        //创建角色
        iRoleService.insertRole(user.getUsername(), "student");

        List<Permission> list = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        permissions.add("singin");
        permissions.add("signOut");
        for (String permission : permissions) {
            iPermissionService.insertPermissionId(user.getUsername(), permission);
        }
        //添加签到
        iCheckService.insertNew(new Check(user.getUsername(), user.getName(), "0", null, null, 0));
        return "注册成功";
    }

    //注册管理员


    //登录操作
    @Override
    public String Login(Login login) {
        if (iUserService.login(login.getUsername(), login.getPassword()) != null) {
            AllUserInfo info = iUserService.findAll(login, login.getUsername());
            //设置token内含数据
            Map<String, String> map = new HashMap<>();
            map.put("userId", info.getUsername());
            map.put("userName", info.getName());
            //设置token
            String token = JwtUtils.getToken(map);
            //存储token
            redisTemplate.opsForValue().set(token, info, 7, TimeUnit.DAYS);
            return "登录成功" + token;
        } else {
            return "登录失败,密码错误";
        }
    }

    //退出登录
    @Override
    public String Logout(String token) {
        if (redisTemplate.opsForValue().get(token) == null) {
            return "退出登录异常";
        } else {
            redisTemplate.delete(token);
            return "退出登录成功";
        }

    }

    //签到
    @Override
    public String sinin(String token) {
        AllUserInfo user = (AllUserInfo) redisTemplate.opsForValue().get(token);
        if (user == null) {
            return "用户未登录，无法签到";
        }
        Check check = new Check();
        check.setId(user.getUsername());
        if (checkMapper.getCheckState(user.getUsername()).equals("0")) {
            check.setStartTime(new Date());
            check.setCheckState("1");
            iCheckService.singin(check);
            return "签到成功";
        }
        return "签到失败,请联系管理员查看";
    }

    //签退
    @Override
    public String sinout(String token) {
        AllUserInfo user = (AllUserInfo) redisTemplate.opsForValue().get(token);
        if (user == null) {
            return "用户未登录，无法签退";
        }
        Check check = new Check();
        check.setId(user.getUsername());
        if (checkMapper.getCheckState(user.getUsername()).equals("2")) {
            //签退操作
            int accountTime = iCheckService.findAccountTime(user.getUsername());
            Date now = new Date();
            Date startTime = iCheckService.getStartTime(user.getUsername());
            long start = startTime.getTime();
            long nowTime = now.getTime();
            long account = (nowTime - start) / (1000 * 60) + accountTime;
            check.setAccount((int) account);
            check.setCheckState("0");
            iCheckService.singOut(check);
            return "签退成功";
        } else if (checkMapper.getCheckState(user.getUsername()).equals("1")) {
            return "未同意签到";
        }

        return "签退产生异常,请联系管理员";
    }

    //查询时长
    @Override
    public String findAccount(String token) {
        AllUserInfo user = (AllUserInfo) redisTemplate.opsForValue().get(token);
        if (user == null) {
            return "用户未登录，无法查询签到时间";
        }
        int accountTime = iCheckService.findAccountTime(user.getUsername());
        return String.valueOf(accountTime);
    }


}
