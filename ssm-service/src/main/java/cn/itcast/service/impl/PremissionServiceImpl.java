package cn.itcast.service.impl;

import cn.itcast.dao.PremissionDao;
import cn.itcast.doamin.Permission;
import cn.itcast.service.PremissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Service
public class PremissionServiceImpl implements PremissionService {
    @Autowired
    PremissionDao premissionDao;
    @Override
    public List<Permission> findAll() {
        return premissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permission.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        premissionDao.save(permission);
    }
}
