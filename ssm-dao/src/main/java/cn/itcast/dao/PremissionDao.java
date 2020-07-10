package cn.itcast.dao;

import cn.itcast.doamin.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PremissionDao {
    @Select("SELECT * FROM permission WHERE id IN(SELECT permissionId  FROM role_permission WHERE roleId=#{id})")
public List<Permission> findById(String id);

    /**
     *查找所有权限
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAll();
@Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void save(Permission permission);
}
