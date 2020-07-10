package cn.itcast.service.impl;

import cn.itcast.dao.IUserDao;
import cn.itcast.doamin.Role;
import cn.itcast.doamin.UserInfo;
import cn.itcast.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserInfoImpl implements UserInfoService {
    @Autowired
   private IUserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<cn.itcast.doamin.UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
 /*       System.out.println("service");
        System.out.println(userInfo.getStatus()==1);*/
         /*uuid 进行id赋值操作*/
        userInfo.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        String encode = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);
        System.out.println(userInfo.getPassword());
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }
    public UserInfo findById1(String id) {
        return userDao.findById1(id);
    }

    public List<Role> findOtherRoles(String id) {
        return userDao.findOtherRoles(id);
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param ids
     */
    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String roleId:ids)
        {
            userDao.addRoleToUser(userId,roleId);
        }

    }
}
