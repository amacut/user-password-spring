package com.sda.userpassword;

import com.sda.userpassword.model.PhoneEntity;
import com.sda.userpassword.model.UserPassword;
import com.sda.userpassword.repository.PhoneDao;
import com.sda.userpassword.service.UserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Starter implements CommandLineRunner {

    UserPasswordService userPasswordService;
    PhoneDao phoneDao;

    @Autowired
    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Autowired
    public void setUserPasswordService(UserPasswordService userPasswordService) {
        this.userPasswordService = userPasswordService;
    }

    @Override
    public void run(String... args) throws Exception {
        UserPassword mbank = new UserPassword();
        mbank.setName("mbank");
        mbank.setUsername("user1");
        mbank.setPassword("password1");
        mbank.setEmail("email@vp.pl");
        mbank.setUrl("www.mbank.pl");
        mbank.setDescription("Hasło użytkownika mbank");

        UserPassword mbank2 = new UserPassword();
        mbank2.setName("mbank2");
        mbank2.setUsername("user2");
        mbank2.setPassword("password2");
        mbank2.setEmail("email2@vp.pl");
        mbank2.setUrl("www.mbank.pl");
        mbank2.setDescription("Hasło użytkownika mbank2");

        PhoneEntity phone1 = new PhoneEntity("123456789");
        PhoneEntity phone2 = new PhoneEntity("523456789");
        PhoneEntity phone3 = new PhoneEntity("423456789");
        PhoneEntity phone4 = new PhoneEntity("323456789");

        phone1.setName("mbank2");
        phone2.setName("mbank2");
        phone3.setName("mbank2");
        phone4.setName("mbank2");

        phoneDao.save(phone1);
        phoneDao.save(phone2);
        phoneDao.save(phone3);
        phoneDao.save(phone4);


        userPasswordService.addUserPassword(mbank);
        userPasswordService.addUserPassword(mbank2);
        List<UserPassword> mbank1 = userPasswordService.findByNameContaining("mbank");
        System.out.println(mbank1);
    }
}
