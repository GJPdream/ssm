package cn.itcast.service;

import cn.itcast.doamin.Permission;
import cn.itcast.doamin.Role;

import java.util.List;

public interface RoleService {
   List<Role> findAll();
    void save(Role role);

    Role findById(String id);

    List<Permission> findOtherPermission(String id);

    void addRoleToPermission(String roleId, String permissionId [] );
}
