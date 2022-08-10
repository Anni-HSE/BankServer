package com.newbankserver.controller;

import com.newbankserver.entity.User;
import com.newbankserver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http:/localhost:3000/", maxAge = 3600)
@Api(tags = "UserController")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping(path = "/getUsers", produces = "application/json")
    @ApiOperation(value = "Получить всех пользователей", notes = "Получить подробную информацию на основе URL-адреса")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @ResponseBody
    @GetMapping(path = "/getUser={userId}", produces = "application/json")
    @ApiOperation(value = "Получить пользователя по индентификатору", notes = "Получить подробную информацию на основе URL-адреса")
    @ApiImplicitParam(name = "userId", value = "ID", readOnly = true, dataType = "int", paramType = "path")
    public User getUserById(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @ResponseBody
    @PostMapping(path = "/createUser", produces = "application/json")
    @ApiOperation(value = "Создать нового пользователя", notes = "Создать пользователя на основе информации URL-адреса")
    @ApiImplicitParam(name = "User", value = "user", readOnly = true, dataType = "User", paramType = "path")
    public User createUser(@RequestBody User user) {
        return  userService.createUser(user);
    }

    @ResponseBody
    @PutMapping(path = "/updateUser={userId}", produces = "application/json")
    @ApiOperation(value = "Обновить данные о пользователе", notes = "Получить подробную информацию на основе URL-адреса и обновить их")
    @ApiImplicitParam(name = "userId", value = "ID", readOnly = true, dataType = "int", paramType = "path")
    public User replaceUser(@PathVariable int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteUser={userId}")
    @ApiOperation(value = "Удалить пользователя", notes = "Удалить пользователя на основе информации URL-адреса")
    @ApiImplicitParam(name = "User", value = "user", readOnly = true, dataType = "User", paramType = "path")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
