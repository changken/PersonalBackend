package org.changken.personalspring;

import org.changken.personalspring.mapper.UserMapper;
import org.changken.personalspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MyController {
    @Autowired
    private UserMapper userMapper;

//    @GetMapping("/get_name")
//    public List<String> getNames(){
//        List<String> res = new ArrayList<>();
//        res.add("Makato");
//        res.add("some thing");
//        return res;
//    }
    @GetMapping("/get_all_users")
    public List<User> getAllUsers(){
        List<User> users = userMapper.selectUserList();
        return users;
    }
}
