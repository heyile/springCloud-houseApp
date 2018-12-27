package com.huawei.account.cseaccountservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.account.cseaccountservice.entity.TAccount;
import com.huawei.account.cseaccountservice.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
  private final static Logger logger = LoggerFactory.getLogger(AccountService.class);

  @Autowired
  private AccountService accountService;

  @ResponseBody
  @GetMapping("/getAllAccount")
  public List<TAccount> getAllAccount() {
    List<TAccount> allAccounts = accountService.getAllAccounts();
    if (allAccounts == null || allAccounts.size() == 0) {
      logger.warn("accounts list is empty");
    }
    return allAccounts;
  }

  @ResponseBody
  @PostMapping(value = "/create")
  public String createAccount(@RequestBody TAccount account) {
    return accountService.insertAccount(account);
  }

  @ResponseBody
  @DeleteMapping(value = "/delete/{id}")
  public void createAccount(@PathVariable(value = "id") String id) {
    accountService.deleteAccountById(id);
  }

  @ResponseBody
  @GetMapping(value = "/search/{id}")
  public TAccount searchAccount(@PathVariable(value = "id") String id) {
    return accountService.findAccountById(id);
  }

  @ResponseBody
  @GetMapping(value = "save")
  public double saveMoney(@RequestParam("money") double money, @RequestParam("id") String id) {
    return accountService.saveMoney(id, money);
  }

  @ResponseBody
  @GetMapping(value = "consume")
  public double consume(@RequestParam("money") double money, @RequestParam("id") String id) {
    return accountService.consume(id, money);
  }
}
