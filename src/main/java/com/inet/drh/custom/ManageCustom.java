package com.inet.drh.custom;

import com.inet.drh.entity.vo.UserPage;

public interface ManageCustom {
    UserPage findPage(int offset, int page);

    String agreeSin(String token);

    String refuseSin(String token);
}
