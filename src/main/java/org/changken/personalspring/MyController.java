package org.changken.personalspring;

import org.changken.personalspring.mapper.UserMapper;
import org.changken.personalspring.pojo.*;
import org.changken.personalspring.repository.MemoRepository;
import org.changken.personalspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MyController {
//    @Autowired
//    private UserMapper userMapper;

//    @GetMapping("/get_name")
//    public List<String> getNames(){
//        List<String> res = new ArrayList<>();
//        res.add("Makato");
//        res.add("some thing");
//        return res;
//    }

//    @GetMapping("/get_all_users")
//    public List<User> getAllUsers(){
//        List<User> users = userMapper.selectUserList();
//        return users;
//    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    MemoRepository memoRepository;

    @GetMapping("/get_all_users")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/get_all_memos")
    public  Iterable<Memo> getAllMemos(){
        return memoRepository.findAll();
    }
}
