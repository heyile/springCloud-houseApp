package com.huawei.customer.csecustomerservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.huawei.customer.csecustomerservice.entity.TAccount;
import com.huawei.customer.csecustomerservice.entity.TUser;
import com.huawei.customer.csecustomerservice.entity.vo.UserDetailVo;
import com.huawei.customer.csecustomerservice.service.intf.AccountServiceIntf;
import com.huawei.customer.csecustomerservice.service.intf.UserServiceIntf;

@Service
public class UserService {

  private final static Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserServiceIntf userServiceIntf;

  @Autowired
  private AccountServiceIntf accountServiceIntf;

  public UserDetailVo searchUserById(String id) {
    ResponseEntity<TUser> userInfoById = userServiceIntf.getUserInfoById(id);
    if (userInfoById != null && userInfoById.getBody() != null) {
      TUser user = userInfoById.getBody();
      ResponseEntity<TAccount> accountResponseEntity = accountServiceIntf.searchAccount(user.getAccountId());
      if (accountResponseEntity != null && accountResponseEntity.getBody() != null) {
        return new UserDetailVo(user, accountResponseEntity.getBody());
      }
    }
    logger.warn(" user with id {} is null", id);
    return null;
  }
}
