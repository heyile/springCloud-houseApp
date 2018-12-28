package com.huawei.user.cseuserservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.user.cseuserservice.entity.TUser;
import com.huawei.user.cseuserservice.mapper.TUserMapper;

@Service
public class UserService {
  private final static Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private TUserMapper tUserMapper;

  public String insertUser(TUser tUser) {
    int insert = tUserMapper.insert(tUser);
    logger.info("result : " + insert);
    logger.info("id : " + tUser.getId());
    return tUser.getId();
  }

  public List<TUser> getAllUsers() {
    List<TUser> tUsers = tUserMapper.selectAll();
    if (tUsers != null && tUsers.size() != 0) {
      return tUsers;
    }
    logger.warn("No user in the list");
    return new ArrayList<>();
  }

  public TUser findUserById(String id) {
    TUser tUser = tUserMapper.selectByPrimaryKey(id);
    if (tUser != null) {
      return tUser;
    }
    logger.warn("the user {} is not exist ", id);
    return null;
  }

  public void deleteUserById(String id) {
    int i = tUserMapper.deleteByPrimaryKey(id);
    if (i == 0) {
      logger.warn("the user {} may not exist ", id);
    }
  }
}
