package cn.itcast.service.impl;

import cn.itcast.dao.sysLogDao;
import cn.itcast.doamin.SysLog;
import cn.itcast.service.sysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class sysLogServiceImpl implements sysLogService {
    @Autowired
   private sysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) {
    sysLog.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        sysLogDao.save(sysLog);
    }


    public List<SysLog> findAll(int page,int size) {
        /**
         * 页面初始化大小*/
        PageHelper.startPage(page, size);
        return sysLogDao.findAll();
    }
}
