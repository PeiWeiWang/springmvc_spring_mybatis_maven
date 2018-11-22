package net.wanho.mapper;

import net.wanho.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> queryUsers() throws Exception;

    void insertUser(User user);

    void deleteUser(User user);
}
