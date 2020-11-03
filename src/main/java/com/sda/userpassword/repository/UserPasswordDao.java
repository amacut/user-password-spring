package com.sda.userpassword.repository;

import com.sda.userpassword.model.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPasswordDao extends JpaRepository<UserPassword, String> {

    List<UserPassword> findByNameContaining(String name);
}
