package cn.itcast.service;

import cn.itcast.doamin.SysLog;

import java.sql.Savepoint;
import java.util.List;

public interface sysLogService {

    void save(SysLog sysLog);

    List<SysLog> findAll(int page,int size);
}
