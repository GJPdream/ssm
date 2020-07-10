package cn.itcast.dao;

import cn.itcast.doamin.Permission;
import cn.itcast.doamin.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from role")
    List<Role> findAll();
@Insert("insert into role values (#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    /**
     * 查询所有的角色
     * @param id
     * @return
     */
    @Select("select* from role where id=#{id}")
    Role findById(String id);

    /**
     * 查询没有选择的权限
     * @param id
     * @return
     */
    @Select("SELECT* FROM permission WHERE id NOT IN (SELECT permissionId FROM role_permission WHERE roleId=#{id})")
    List<Permission> findOtherPermission(String id);

    /**
     * 给角色添加权限
     * @param roleId
     * @param pId
     */
    @Insert("insert into role_permission(permissionId,roleId) values(#{pId},#{roleId})")
    void addRoleToPermission(@Param("roleId") String roleId, @Param("pId") String pId);
}
