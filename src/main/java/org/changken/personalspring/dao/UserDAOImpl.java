package org.changken.personalspring.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.changken.personalspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Repository
public class UserDAOImpl implements UserDAO {
    //@Autowired
    private DataSource dataSource;

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection conn = dataSource.getConnection();
        String sql = "SELECT nid, vchusername, vchpassword, vchlevel, dbirthday, dcreated_at, dupdated_at FROM usertbl ORDER BY nid DESC";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            users.add(getUser(rs));
        }
        conn.close();
        return users;
    }

    @Override
    public User findOne(Long id) throws SQLException {
        User user = new User();
        Connection conn = dataSource.getConnection();
        String sql = "SELECT nid, vchusername, vchpassword, vchlevel, dbirthday, dcreated_at, dupdated_at FROM usertbl WHERE nid=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            user = getUser(rs);
        }
        conn.close();
        return user;
    }

    @Override
    public int insert(User user) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO usertbl (vchusername, vchpassword, vchlevel, dbirthday) VALUES (?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, new DigestUtils("SHA3-256").digestAsHex(user.getPassword()));
        stmt.setString(3, user.getLevel());
        stmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
        int result = stmt.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public int update(User user) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "UPDATE usertbl SET vchusername=?, vchpassword=?, vchlevel=?, dbirthday=?, dupdated_at=CURRENT_TIMESTAMP() WHERE nid=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, new DigestUtils("SHA3-256").digestAsHex(user.getPassword()));
        stmt.setString(3, user.getLevel());
        stmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
        stmt.setLong(5, user.getId());
        int result = stmt.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public int delete(Long id) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "DELETE FROM usertbl WHERE nid=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        int result = stmt.executeUpdate();
        conn.close();
        return result;
    }

    public User getUser(ResultSet rs) throws SQLException{
        return new User(rs.getLong("nid"),
                rs.getString("vchusername"),
                rs.getString("vchpassword"),
                rs.getString("vchlevel"),
                rs.getDate("dbirthday"),
                rs.getDate("dcreated_at"),
                rs.getDate("dupdated_at"));
    }

}
