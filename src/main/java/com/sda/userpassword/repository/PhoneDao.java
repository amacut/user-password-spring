package com.sda.userpassword.repository;

import com.sda.userpassword.model.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneDao extends JpaRepository<PhoneEntity, Integer> {

    List<PhoneEntity> findByName(String name);
}
