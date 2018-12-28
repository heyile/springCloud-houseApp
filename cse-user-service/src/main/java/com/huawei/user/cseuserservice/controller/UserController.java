package com.huawei.user.cseuserservice.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huawei.user.cseuserservice.entity.TUser;
import com.huawei.user.cseuserservice.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
  private final static Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  UserService userService;

  @PostMapping(value = "/register")
  public ResponseEntity<String> registerUser(@RequestBody TUser tUser) {
    if (tUser == null) {
      logger.error("when register user, user can not be null");
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(userService.insertUser(tUser));
  }

  @DeleteMapping(value = "/unRegister")
  public ResponseEntity<String> unRegister(@RequestParam("id") String id) {
    if (StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().body("id can not be empty");
    }
    userService.deleteUserById(id);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("删除 %s成功", id));
  }

  @GetMapping(value = "/getUserInfoById")
  public ResponseEntity<TUser> getUserInfoById(@RequestParam("id") String id) {
    if (StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(userService.findUserById(id));
  }

  @GetMapping(value = "/getAllUser")
  public ResponseEntity<List<TUser>> getAllUser() {
    List<TUser> user = userService.getAllUsers();
    if (user.size() == 0) {
      logger.warn(" user list is empty");
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.ok(user);
  }
}
