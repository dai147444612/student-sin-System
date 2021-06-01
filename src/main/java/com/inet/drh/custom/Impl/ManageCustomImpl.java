package com.inet.drh.custom.Impl;

import com.inet.drh.custom.ManageCustom;
import com.inet.drh.custom.UserCustom;
import com.inet.drh.entity.po.Check;
import com.inet.drh.entity.vo.AllUserInfo;
import com.inet.drh.entity.vo.UserPage;
import com.inet.drh.service.ICheckService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManageCustomImpl implements ManageCustom {
    @Resource
    private ICheckService checkService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //查询用户分页
    @Override
    public UserPage findPage(int offset, int page) {
        return checkService.findPage(offset, page);
    }

    @Override

    public String agreeSin(String token) {
        AllUserInfo user = (AllUserInfo) redisTemplate.opsForValue().get(token);
        if (user == null) {
            return "用户未登录，无法同意签到";
        }
        Check check = new Check();
        check.setId(user.getUsername());
        check.setCheckState("2");
        checkService.agreeSin(check);
        return "同意签到成功";
    }

    @Override

    public String refuseSin(String token) {
        AllUserInfo user = (AllUserInfo) redisTemplate.opsForValue().get(token);
        if (user == null) {
            return "用户未登录，无法拒绝签到";
        }
        Check check = new Check();
        check.setCheckState("0");
        check.setId(user.getUsername());
        check.setStartTime(null);
        checkService.singin(check);
        return "已拒绝签到";
    }


}
