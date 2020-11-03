package com.sda.userpassword.service;

import com.sda.userpassword.model.PhoneEntity;
import com.sda.userpassword.model.UserPassword;

import java.util.List;

public interface UserPasswordService {

    void addUserPassword(UserPassword userPassword);

    void removeUserPassword(String name);

    void modifyUserPassword(String name, UserPassword userPassword);

    List<UserPassword> getAll();

    List<UserPassword> findByNameContaining(String name);

    UserPassword getById (String name);

    List<PhoneEntity> getPhonesByUsername(String name);
}
