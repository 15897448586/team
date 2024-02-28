package com.zlx.team.service;

import com.zlx.team.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;

//    @Test
//    void testLogin(){
//        userService.userLogin("admin","200424zlx",null).
//    }

    @Test
    void testSearchUsersByTags(){
        List<String> tags = Arrays.asList("java", "c");
        List<User> users = userService.searchUsersByTags(tags);
        Assertions.assertTrue(users.size() > 0);
    }
}
