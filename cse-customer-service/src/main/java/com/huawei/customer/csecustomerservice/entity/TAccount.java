package com.huawei.customer.csecustomerservice.entity;

public class TAccount {
  private String id;

  private String userId;

  private String userAccount;

  private String userPwd;

  private Double restMoney;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId == null ? null : userId.trim();
  }

  public String getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(String userAccount) {
    this.userAccount = userAccount == null ? null : userAccount.trim();
  }

  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd == null ? null : userPwd.trim();
  }

  public Double getRestMoney() {
    return restMoney;
  }

  public void setRestMoney(Double restMoney) {
    this.restMoney = restMoney;
  }

  @Override
  public String toString() {
    return "TAccount{" +
        "id='" + id + '\'' +
        ", userId='" + userId + '\'' +
        ", userAccount='" + userAccount + '\'' +
        ", userPwd='" + userPwd + '\'' +
        ", restMoney=" + restMoney +
        '}';
  }
}