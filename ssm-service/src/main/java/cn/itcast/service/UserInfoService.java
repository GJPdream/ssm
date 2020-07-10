package cn.itcast.service;

import cn.itcast.doamin.Role;
import cn.itcast.doamin.UserInfo;

import java.util.List;

public interface UserInfoService {
   /* 查询所有的用户信息*/
    List<cn.itcast.doamin.UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    UserInfo findById1(String id);

    List<Role> findOtherRoles(String id);

    void addRoleToUser(String userId, String[] ids);
}
