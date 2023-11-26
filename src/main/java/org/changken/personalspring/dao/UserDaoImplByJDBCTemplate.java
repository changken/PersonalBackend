package org.changken.personalspring.dao;

import org.changken.personalspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class UserDaoImplByJDBCTemplate  implements UserDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.TAIWAN);
    @Override
    public List<User> findAll() throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT nid, vchusername, vchpassword, vchlevel, dbirthday, dcreated_at, dupdated_at FROM usertbl ORDER BY nid DESC";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Iterator it = rows.iterator();

        while(it.hasNext()){
            Map<String, Object> userMap = (Map<String, Object>) it.next();
            User user = new User();
            user.setId(Long.parseLong(userMap.get("nid").toString()));
            user.setUsername(userMap.get("vchusername").toString());
            user.setPassword(userMap.get("vchpassword").toString());
            user.setLevel(userMap.get("vchlevel").toString());
            user.setBirthday(formatter.parse(userMap.get("dbirthday").toString()));
            user.setCreated_at(formatter.parse(userMap.get("dcreated_at").toString()));
            user.setUpdated_at(formatter.parse(userMap.get("dupdated_at").toString()));
            users.add(user);
        }

        return users;
    }

    @Override
    public User findOne(Long id) throws Exception {
        User user = new User();
        String sql = "SELECT nid, vchusername, vchpassword, vchlevel, dbirthday, dcreated_at, dupdated_at FROM usertbl WHERE nid=?";
        Map<String, Object> userMap = jdbcTemplate.queryForMap(sql, id);

        user.setId(Long.parseLong(userMap.get("nid").toString()));
        user.setUsername(userMap.get("vchusername").toString());
        user.setPassword(userMap.get("vchpassword").toString());
        user.setLevel(userMap.get("vchlevel").toString());
        user.setBirthday(formatter.parse(userMap.get("dbirthday").toString()));
        user.setCreated_at(formatter.parse(userMap.get("dcreated_at").toString()));
        user.setUpdated_at(formatter.parse(userMap.get("dupdated_at").toString()));

        return user;
    }

    @Override
    public int insert(User user) throws Exception {
        return 0;
    }

    @Override
    public int update(User user) throws Exception {
        return 0;
    }

    @Override
    public int delete(Long id) throws Exception {
        return 0;
    }
}
