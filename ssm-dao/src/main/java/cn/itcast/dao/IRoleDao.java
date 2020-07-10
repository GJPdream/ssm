package cn.itcast.dao;

import cn.itcast.doamin.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRoleDao {
    /* 一个用户可以有多个角色*/
    @Select("select * from role where id in (select roleId from users_role where userId=#{uid} )")
      public List<Role>findByRoleUserId(String uid);

    /**
     * 通过id进行查询返回到role封装起来
     * @param id
     * @return
     */
    @Select("SELECT * FROM role WHERE id IN(SELECT roleId FROM users_role WHERE userId=#{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions" ,column = "id",many = @Many(select = "cn.itcast.dao.PremissionDao.findById"))
    })
    public List<Role> findById(String id);
}
