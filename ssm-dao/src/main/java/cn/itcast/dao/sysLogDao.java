package cn.itcast.dao;

import cn.itcast.doamin.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sysLogDao {
    /**
     * 插入数据
     * @param sysLog
     */
    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
   /* @Insert("insert into syslog values (#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")*/
   public void save(SysLog sysLog);

    /**
     * 查询所有，进行遍历
     * @return
     */
    @Select("select * from syslog")
    List<SysLog> findAll();
}
