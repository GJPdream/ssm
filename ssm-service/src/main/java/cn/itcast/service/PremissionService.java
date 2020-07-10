package cn.itcast.service;

import cn.itcast.doamin.Permission;
import sun.rmi.log.LogInputStream;

import java.util.List;

public interface PremissionService {
    /**
     * 查找全部资源
     * @return
     */
    List<Permission> findAll();

    void save(Permission permission);
}
