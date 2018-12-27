package com.huawei.user.cseuserservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.user.cseuserservice.entity.TUser;
import com.huawei.user.cseuserservice.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
  private final static Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  UserService userService;

  @ResponseBody
  @PostMapping(value = "/register")
  public String registerUser(@RequestBody TUser tUser) {
    if (tUser == null) {
      logger.error("when register user, user is null");
      return null;
    }
    return userService.insertUser(tUser);
  }

  @ResponseBody
  @DeleteMapping(value = "/unRegister")
  public void unRegister(@RequestParam("id") String id) {
    userService.deleteUserById(id);
  }

  @ResponseBody
  @GetMapping(value = "/getUserInfoById")
  public TUser getUserInfoById(@RequestParam("id") String id) {
    return userService.findUserById(id);
  }

  @GetMapping(value = "/getAllUser")
  @ResponseBody
  public List<TUser> getAllUser() {
    List<TUser> user = userService.getAllUsers();
    if (user.size() == 0) {
      logger.warn(" user list is empty");
    }
    return user;
  }
}
