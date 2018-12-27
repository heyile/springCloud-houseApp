package com.huawei.account.cseaccountservice.service;

import java.util.ArrayList;
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

  public String insertAccount(TAccount tAccount) {
    int insert = accountMapper.insert(tAccount);
    logger.info("result : " + insert);
    logger.info("id : " + tAccount.getId());
    return tAccount.getId();
  }

  public List<TAccount> getAllAccounts() {
    List<TAccount> tAccounts = accountMapper.selectAll();
    if (tAccounts != null && tAccounts.size() != 0) {
      return tAccounts;
    }
    logger.warn("No Account in the list");
    return new ArrayList<>();
  }

  public TAccount findAccountById(String id) {
    TAccount tAccount = accountMapper.selectByPrimaryKey(id);
    if (tAccount != null) {
      return tAccount;
    }
    logger.warn("the Account {} is not exist ", id);
    return null;
  }

  public int deleteAccountById(String id) {
    int i = accountMapper.deleteByPrimaryKey(id);
    if (i == 0) {
      logger.warn("the Account {} may not exist ", id);
    }
    return i;
  }

  public double saveMoney(String id, Double money) {
    TAccount tAccount = accountMapper.selectByPrimaryKey(id);
    if (tAccount == null) {
      logger.warn("the Account {} may not exist ", id);
      return 0;
    }
    double allMoney = money + tAccount.getRestMoney();
    updateMoney(id, allMoney);
    return allMoney;
  }

  public double consume(String id, Double money) {
    TAccount tAccount = accountMapper.selectByPrimaryKey(id);
    if (tAccount == null) {
      logger.warn("the Account {} may not exist ", id);
      return 0;
    }
    double allMoney = tAccount.getRestMoney() - money;
    updateMoney(id, allMoney);
    return allMoney;
  }

  private void updateMoney(String id, Double money) {
    int i = accountMapper.updateMoneyById(id, money);
    if (i == 0) {
      logger.warn("the Account {} may not exist ", id);
    }
  }
}
