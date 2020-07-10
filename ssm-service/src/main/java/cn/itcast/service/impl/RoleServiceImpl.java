package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.doamin.Permission;
import cn.itcast.doamin.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
      /*  给id进行赋值操作*/
       role.setId( UUID.randomUUID().toString().replace("-","").toUpperCase());
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }


    @Override
    public List<Permission> findOtherPermission(String id) {
        return roleDao.findOtherPermission(id);
    }

    @Override
    public void addRoleToPermission(String roleId, String permissionId []) {
        /*System.out.println("service");*/
        for (String pId:permissionId)
        {
            System.out.println(pId);
            roleDao.addRoleToPermission(roleId,pId);
        }
    }
}
