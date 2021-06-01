package com.inet.drh.service;

import com.inet.drh.entity.po.Check;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.drh.entity.po.User;
import com.inet.drh.entity.vo.UserPage;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
public interface ICheckService extends IService<Check> {
    //    查找登录信息
    Check findById(String number);

    //    新增签到
    void insertNew(Check check);

    void singin(Check check);

    Date getStartTime(String username);

    void singOut(Check check);

    int findAccountTime(String username);

    UserPage findPage(int offset, int page);

    void agreeSin(Check check);

    void refuseSin(Check check);


    boolean saveBatch(List<User> users);
}
