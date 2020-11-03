package com.sda.userpassword.service;

import com.sda.userpassword.model.PhoneEntity;
import com.sda.userpassword.model.UserPassword;
import com.sda.userpassword.repository.PhoneDao;
import com.sda.userpassword.repository.UserPasswordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPasswordServiceImpl implements  UserPasswordService{

    UserPasswordDao userPasswordDao;
    PhoneDao phoneDao;


    public UserPasswordServiceImpl(UserPasswordDao userPasswordDao) {
        this.userPasswordDao = userPasswordDao;
    }

    @Override
    public void addUserPassword(UserPassword userPassword) {
        userPasswordDao.save(userPassword);
    }

    @Override
    public void removeUserPassword(String name) {
        userPasswordDao.deleteById(name);
    }

    @Override
    public void modifyUserPassword(String name, UserPassword userPassword) {
        UserPassword newUserPassword = userPasswordDao.findById(name).orElse(new UserPassword());
        newUserPassword.setName(userPassword.getName());
        newUserPassword.setPassword(userPassword.getPassword());
        newUserPassword.setEmail(userPassword.getEmail());
        newUserPassword.setUrl(userPassword.getUrl());
        newUserPassword.setDescription(userPassword.getDescription());
        userPasswordDao.save(newUserPassword);
    }

    @Override
    public List<UserPassword> getAll() {
        return userPasswordDao.findAll();
    }

    @Override
    public List<UserPassword> findByNameContaining(String name) {
        return userPasswordDao.findByNameContaining(name);
    }

    @Override
    public UserPassword getById(String name) {
        return userPasswordDao.findById(name).orElse(new UserPassword());
    }


    @Override
    public List<PhoneEntity> getPhonesByUsername(String name) {
        return phoneDao.findByName(name);
    }

    @Autowired
    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }
}
