package com.inet.drh.service.Impl;

import com.inet.drh.entity.po.Check;
import com.inet.drh.entity.po.User;
import com.inet.drh.entity.vo.UserPage;
import com.inet.drh.mapper.CheckMapper;
import com.inet.drh.service.ICheckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
@Service
public class CheckServiceImpl extends ServiceImpl<CheckMapper, Check> implements ICheckService {
    @Resource
    private CheckMapper checkMapper;

    //    判断是否签到
    @Override
    public Check findById(String number) {
        return checkMapper.findById(number);
    }

    //    新增签到
    @Override
    public void insertNew(Check check) {
        checkMapper.insertNew(check);
    }


    //签到
    @Override
    public void singin(Check check) {
        checkMapper.singin(check);
    }

    //获取签到时长
    @Override
    public Date getStartTime(String username) {
        return checkMapper.getStartTime(username);
    }

    @Override
    public void singOut(Check check) {
        checkMapper.singOut(check);
    }

    @Override
    public int findAccountTime(String username) {
        return checkMapper.findAccountTime(username);
    }

    //分页操作
    @Override
    public UserPage findPage(int offset, int page) {
        int offset1 = (offset - 1) * page;
        return checkMapper.findPage(offset1, page);
    }

    @Override
    public void agreeSin(Check check) {
        checkMapper.ManageSin(check);
    }

    @Override
    public void refuseSin(Check check) {
        checkMapper.ManageSin(check);
    }

    @Override
    public boolean saveBatch(List<User> users) {
        return false;
    }


}
