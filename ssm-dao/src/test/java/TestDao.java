import cn.itcast.dao.IUserDao;
import cn.itcast.dao.OrderDao;
import cn.itcast.dao.RoleDao;
import cn.itcast.doamin.Orders;
import cn.itcast.doamin.Role;
import cn.itcast.doamin.UserInfo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

public class TestDao {
    @Test
    public void fun()
    {
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleDao bean = cp.getBean(RoleDao.class);
        /*UserInfo userInfo = new UserInfo();*/
     /*   userInfo.setUsername("xiaogaoago");
        userInfo.setEmail("256@qq.com");
        userInfo.setPassword("123456");
        userInfo.setPhoneNum("13603735691");
        userInfo.setStatus(1);
        bean.save(userInfo);*/
       /* List<Role> otherRoles = bean.findOtherRoles("111222");
        System.out.println(otherRoles);*/
       /* UserInfo byId = bean.findById("222");
        System.out.println(byId);*/

     /*   List<UserInfo> all = bean.findAll();
        System.out.println(all);

        UserInfo byId = bean.findById("111222");
        System.out.println(byId);*/
        Role byId = bean.findById("111");
        System.out.println(byId);

    }

    @Test
    public void fun1()
    {
        String s = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        System.out.println(s.length());
    }

}
