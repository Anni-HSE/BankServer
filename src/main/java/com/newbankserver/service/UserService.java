package com.newbankserver.service;

import com.newbankserver.entity.User;
import com.newbankserver.interfaces.UserInterface;
import com.newbankserver.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserInterface {

    @Resource
    private UserRepository userRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserService() {
        RestTemplate restTemplate = new RestTemplate();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setSecondName(newUser.getSecondName());
                    user.setFatherName(newUser.getFatherName());
                    user.setTelephoneNumber(newUser.getTelephoneNumber());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setUserId(id);
                    return userRepository.save(newUser);
                });
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}