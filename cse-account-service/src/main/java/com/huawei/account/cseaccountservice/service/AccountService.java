package com.huawei.account.cseaccountservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.account.cseaccountservice.entity.TAccount;
import com.huawei.account.cseaccountservice.mapper.TAccountMapper;

@Service
public class AccountService {

  private final static Logger logger = LoggerFactory.getLogger(AccountService.class);

  @Autowired
  private TAccountMapper accountMapper;

  public List<TAccount> findAllAccounts() {
    List<TAccount> tAccounts = accountMapper.selectAll();
    if (tAccounts != null && tAccounts.size() == 0) {
      return null;
    }
    return tAccounts;
  }
}
