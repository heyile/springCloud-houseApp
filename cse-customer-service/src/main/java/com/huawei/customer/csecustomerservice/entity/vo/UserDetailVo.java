package com.huawei.customer.csecustomerservice.entity.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.customer.csecustomerservice.entity.TAccount;
import com.huawei.customer.csecustomerservice.entity.TUser;

public class UserDetailVo {
  private final static Logger logger = LoggerFactory.getLogger(UserDetailVo.class);

  private String accountId;

  private String userId;

  private String userName;

  /**
   * 0 -- false -- 女
   * 1 -- true -- 男
   */
  private Boolean sex;

  private String phoneNumber;

  private String email;

  private String userAccount;

  private String userPwd;

  private Double restMoney;

  public UserDetailVo(TUser tUser, TAccount tAccount) {
    if (tUser.getId() == null || tAccount == null || !tUser.getId().equals(tAccount.getUserId()) ||
        !tUser.getAccountId().equals(tAccount.getId())) {
      logger.error("Failed to build UserDetailVo object from TUser and TAccount");
      return;
    }
    this.userId = tUser.getId();
    this.userName = tUser.getUserName();
    this.sex = tUser.getSex();
    this.phoneNumber = tUser.getPhoneNumber();
    this.email = tUser.getEmail();

    this.userAccount = tAccount.getUserAccount();
    this.accountId = tAccount.getId();
    this.userPwd = tAccount.getUserPwd();
    this.restMoney = tAccount.getRestMoney();
  }

  public static Logger getLogger() {
    return logger;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Boolean getSex() {
    return sex;
  }

  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(String userAccount) {
    this.userAccount = userAccount;
  }

  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  public Double getRestMoney() {
    return restMoney;
  }

  public void setRestMoney(Double restMoney) {
    this.restMoney = restMoney;
  }
}
