package org.changken.personalspring.dao;

import org.changken.personalspring.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public List<User> findAll() throws SQLException;
    public User findOne(Long id) throws SQLException;

    public int insert(User user) throws SQLException;
    public int update(User user) throws SQLException;
    public int delete(Long id) throws SQLException;
}
