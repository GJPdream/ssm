package cn.itcast.dao;

import cn.itcast.doamin.Role;
import cn.itcast.doamin.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.List;

@Repository
public interface IUserDao {
    @Select("select * from users where username=#{Username}")
  /*  来指定一下获取信息的类型*/
    @Results({
            @Result(id = true,property = "id" ,column = "id"),
            @Result(property = "username" ,column = "username"),
            @Result(property = "password" ,column = "password"),
            @Result(property = "phoneNum" ,column = "phoneNum"),
            @Result (property = "status" ,column = "status"),
            @Result (property = "roles" ,column = "id",many = @Many(select = "cn.itcast.dao.IRoleDao.findByRoleUserId"))
    }
    )
    public UserInfo findByUsername(String Username);

    /**
     * 查询所有信息
     * @return
     */
    @Select("select * from users")
    public List<UserInfo> findAll();

    @Insert("insert into users(id,username,password,phoneNum,email,status) values(#{id},#{username},#{password},#{phoneNum},#{email},#{status})")
    void save(UserInfo userInfo);

    /**
     * 通过id进行查询操作
     * @param id
     */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property ="id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles" ,column = "id",many = @Many(select = "cn.itcast.dao.IRoleDao.findById"))
    })
       UserInfo findById(String id);


    @Select("select * from users where id=#{id}")
    UserInfo findById1(String id);

    @Select("SELECT * FROM role WHERE id  NOT IN (SELECT roleId FROM users_role WHERE userId=#{id})")
    List<Role> findOtherRoles(String id);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role values(#{userId}, #{roleId})")
    /**
     * 这个其实不能这样写，原因就是他会默认的是第一个参数里面去找值
     */
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
