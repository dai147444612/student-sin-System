package com.inet.drh.mapper;

import com.inet.drh.entity.po.Check;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.drh.entity.vo.UserPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
@Mapper
public interface CheckMapper extends BaseMapper<Check> {
    //    查找登录信息
    Check findById(String number);

    //    新增签到
    void insertNew(Check check);

    //获取签到状态
    String getCheckState(String id);

    //签到操作
    void singin(Check check);

    //获取开始签到的时间
    Date getStartTime(String username);

    //签退操作
    void singOut(Check check);

    //查询总签到时长
    int findAccountTime(String username);

    //分页
    UserPage findPage(int offset, int page);

    //同意签到
    void ManageSin(Check check);
}
