package com.huawei.customer.csecustomerservice.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huawei.customer.csecustomerservice.entity.vo.UserDetailVo;
import com.huawei.customer.csecustomerservice.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  UserService userService;

  @GetMapping(value = "/getUserDetailsByUserId")
  public ResponseEntity<UserDetailVo> getUserInfoById(@RequestParam("id") String id) {
    if (StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(userService.searchUserById(id));
  }
}
