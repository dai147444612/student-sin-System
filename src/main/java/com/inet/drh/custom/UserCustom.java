package com.inet.drh.custom;

import com.inet.drh.entity.dto.Login;
import com.inet.drh.entity.dto.Register;

public interface UserCustom {
    //  String registerManager();
    String register(Register register);

    String Login(Login login);

    String Logout(String token);

    String sinin(String token);

    String sinout(String token);

    String findAccount(String token);
}