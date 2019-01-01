package com.huawei.customer.csecustomerservice.service.intf;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.huawei.customer.csecustomerservice.entity.TAccount;

@FeignClient("account-service")
public interface AccountServiceIntf {

  @GetMapping("/account/getAllAccount")
  ResponseEntity<List<TAccount>> getAllAccount();

  @PostMapping(value = "/account/create")
  ResponseEntity<String> createAccount(@RequestBody TAccount account);

  @DeleteMapping(value = "/account/delete/{id}")
  ResponseEntity<String> deleteAccount(@PathVariable(value = "id") String id);

  @GetMapping(value = "/account/search/{id}")
  ResponseEntity<TAccount> searchAccount(@PathVariable(value = "id") String id);

  @GetMapping(value = "/account/save")
  ResponseEntity<String> saveMoney(@RequestParam("money") double money, @RequestParam("id") String id);

  @GetMapping(value = "/account/consume")
  ResponseEntity<String> consume(@RequestParam("money") double money, @RequestParam("id") String id);
}
