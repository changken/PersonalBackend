package org.changken.personalspring.dao;

import org.changken.personalspring.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public List<User> findAll() throws Exception;
    public User findOne(Long id) throws Exception;

    public int insert(User user) throws Exception;
    public int update(User user) throws Exception;
    public int delete(Long id) throws Exception;
}
