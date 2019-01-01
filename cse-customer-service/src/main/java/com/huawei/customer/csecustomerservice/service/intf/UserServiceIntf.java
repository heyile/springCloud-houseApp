package com.huawei.customer.csecustomerservice.service.intf;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.huawei.customer.csecustomerservice.entity.TUser;

@FeignClient("user-service")
public interface UserServiceIntf {

  @PostMapping(value = "/user/register")
  ResponseEntity<String> registerUser(@RequestBody TUser tUser);

  @DeleteMapping(value = "/user/unRegister")
  ResponseEntity<String> unRegister(@RequestParam("id") String id);

  @GetMapping(value = "/user/getUserInfoById")
  ResponseEntity<TUser> getUserInfoById(@RequestParam("id") String id);

  @GetMapping(value = "/user/getAllUser")
  ResponseEntity<List<TUser>> getAllUser();
}
