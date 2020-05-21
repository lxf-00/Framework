package com.example.mapper;

import com.example.pojo.User;
import com.example.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DateUtils dateUtils;

    @Test
    public void testInsert() throws ParseException {
        Date birthday = dateUtils.String2Date("1995-6-9", "yyyy-MM-dd");
        Date created = dateUtils.String2Date("2018-8-9", "yyyy-MM-dd");

        User user = new User();
        user.setUsername("张三");
        user.setUpdated(new Date());
        user.setSex(1);
        user.setPassword("zs");
        user.setName("张三");
        user.setBirthday(birthday);
        user.setCreated(created);

        userMapper.insert(user);
    }
}