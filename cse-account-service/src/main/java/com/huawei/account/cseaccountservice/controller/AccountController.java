package com.huawei.account.cseaccountservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.account.cseaccountservice.entity.TAccount;
import com.huawei.account.cseaccountservice.service.AccountService;

@Controller
@RequestMapping("/test")
public class AccountController {
  private final static Logger logger = LoggerFactory.getLogger(AccountService.class);

  @Autowired
  private AccountService accountService;

  @ResponseBody
  @RequestMapping("/getAll")
  public List<TAccount> getAllAccount() {
    List<TAccount> tAccounts = accountService.findAllAccounts();

    if (tAccounts != null && tAccounts.size() == 0) {
      return null;
    }
    return tAccounts;
  }
}
