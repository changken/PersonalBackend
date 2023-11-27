package org.changken.personalspring.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.changken.personalspring.pojo.User;
import org.changken.personalspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserDAOImplByJPA implements UserDAO{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) throws Exception {
        return userRepository.findById(id).get();
    }

    @Override
    public int insert(User user) throws Exception {
        user.setPassword(new DigestUtils("SHA3-256").digestAsHex(user.getPassword()));
        user.setCreated_at(new Date());
        user.setUpdated_at(new Date());
        User newUser = userRepository.save(user);
        return newUser!=null ? 1 : 0;
    }

    @Override
    public int update(User user) throws Exception {
        User editUser = findOne(user.getId());

        editUser.setUsername(user.getUsername());
        editUser.setPassword(new DigestUtils("SHA3-256").digestAsHex(user.getPassword()));
        editUser.setLevel(user.getLevel());
        editUser.setBirthday(user.getBirthday());
        editUser.setUpdated_at(new Date());

        User updateUser = userRepository.save(editUser);
        return updateUser!=null ? 1 : 0;
    }

    @Override
    public int delete(Long id) throws Exception {
        User deleteUser = findOne(id);
        userRepository.delete(deleteUser);
        return 1;
    }
}
