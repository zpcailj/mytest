package com.jswl.dao;

import java.util.List;

public interface UserDao {
    void save(User user);
    void delete(Integer id);
    void update(User user);
    User getUserById(Integer id);
    Integer getCount();
    List<User> getAll();
    
}
