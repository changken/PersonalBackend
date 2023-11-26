package org.changken.personalspring;

import org.changken.personalspring.dao.UserDAO;
import org.changken.personalspring.mapper.UserMapper;
import org.changken.personalspring.pojo.*;
import org.changken.personalspring.repository.MemoRepository;
import org.changken.personalspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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

    @Autowired
    UserDAO userDAO;

    @GetMapping("/get_all_users")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/get_all_memos")
    public  Iterable<Memo> getAllMemos(){
        return memoRepository.findAll();
    }

    @GetMapping("/get_users_jdbc")
    public List<User> getAllUsersByJDBC(){
        List<User> users = new ArrayList<>();
        try{
            users.addAll(userDAO.findAll());
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return users;
    }

    @GetMapping("/get_users_jdbc/{id}")
    public User getUsersByIdByJDBC(@PathVariable("id") long id){
        User user = new User();
        try{
            user = userDAO.findOne(id);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return user;
    }

    @PostMapping("/add_user_jdbc")
    public Map<String, Object> insertUserByJDBC(@RequestBody User user){
        Map<String, Object> res = new HashMap<>();
        int affected_rows = 0;
        try{
            affected_rows = userDAO.insert(user);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        res.put("status", (affected_rows > 0) ? "ok" : "notok");
        res.put("message", (affected_rows > 0) ? "successfully inserted" : "inserted failure");

        return res;
    }

    @RequestMapping(value = "/update_user_jdbc", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public Map<String, Object> updateUserByJDBC(@RequestBody User user){
        Map<String, Object> res = new HashMap<>();
        int affected_rows = 0;
        try{
            affected_rows = userDAO.update(user);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        res.put("status", (affected_rows > 0) ? "ok" : "notok");
        res.put("message", (affected_rows > 0) ? "successfully updated" : "updated failure");

        return res;
    }

    @DeleteMapping(value = "/delete_user_jdbc/{id}")
    public Map<String, Object> deleteUserByJDBC(@PathVariable("id") Long id){
        Map<String, Object> res = new HashMap<>();
        int affected_rows = 0;
        try{
            affected_rows = userDAO.delete(id);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        res.put("status", (affected_rows > 0) ? "ok" : "notok");
        res.put("message", (affected_rows > 0) ? "successfully deleted" : "deleted failure");

        return res;
    }


}
