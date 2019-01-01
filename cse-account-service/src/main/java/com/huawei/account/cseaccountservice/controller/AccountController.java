package com.huawei.account.cseaccountservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huawei.account.cseaccountservice.entity.TAccount;
import com.huawei.account.cseaccountservice.service.AccountService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@EnableCircuitBreaker
@RequestMapping("/account")
public class AccountController {
  private final static Logger logger = LoggerFactory.getLogger(AccountService.class);

  @Autowired
  private AccountService accountService;

  @HystrixCommand
  @GetMapping("/getAllAccount")
  public ResponseEntity<List<TAccount>> getAllAccount() {
    List<TAccount> allAccounts = accountService.getAllAccounts();
    if (allAccounts == null || allAccounts.size() == 0) {
      logger.warn("accounts list is empty");
      return ResponseEntity.ok(new ArrayList<>());
    }
    return ResponseEntity.ok(allAccounts);
  }

  @HystrixCommand
  @PostMapping(value = "/create")
  public ResponseEntity<String> createAccount(@RequestBody TAccount account) {
    return ResponseEntity.ok(accountService.insertAccount(account));
  }

  @HystrixCommand
  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<String> deleteAccount(@PathVariable(value = "id") String id) {
    if (StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().body(" id 不能为 空");
    }
    accountService.deleteAccountById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(String.format("删除 %s成功", id));
  }

  @HystrixCommand
  @GetMapping(value = "/search/{id}")
  public ResponseEntity<TAccount> searchAccount(@PathVariable(value = "id") String id) {
    if (StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(accountService.findAccountById(id));
  }

  @HystrixCommand
  @GetMapping(value = "/save")
  public ResponseEntity<String> saveMoney(@RequestParam("money") double money, @RequestParam("id") String id) {
    if (money < 0 || StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(accountService.saveMoney(id, money) + "");
  }

  @HystrixCommand
  @GetMapping(value = "/consume")
  public ResponseEntity<String> consume(@RequestParam("money") double money, @RequestParam("id") String id) {
    if (money < 0 || StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().build();
    }
    double restMoney = accountService.consume(id, money);
    if (restMoney < 0) {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(" 余额不足 ");
    }
    return ResponseEntity.ok(restMoney + "");
  }
}
