package com.newbankserver.interfaces;

import com.newbankserver.entity.User;

import java.util.List;

public interface UserInterface {

    List<User> getAll();
    User getUser(int id);
    User createUser(User user);
    User updateUser(int id, User newUser);
    void deleteUser(int id);
}