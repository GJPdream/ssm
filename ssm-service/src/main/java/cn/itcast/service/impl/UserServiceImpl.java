package cn.itcast.service.impl;

import cn.itcast.dao.IUserDao;
import cn.itcast.doamin.Role;
import cn.itcast.doamin.UserInfo;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
/*加上一个事务的形式的意思是，这个service是以事务的形式打开的*/

public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Override
    /*spring-security把我们的用户名进行验证*/
   /*当我们还有创建一个dao进行方法的创建操作*/
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =null;
        try {
         userInfo = userDao.findByUsername(username);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
          /* 在这里判断status是否能激活的状态吧
          *
          * "{noop}" +这个其实就是没有写秘钥的形式要加的，现在我们写上秘钥了所以我们就不需要添加了*/
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }
  /*  这个方法的返回就是一个list的集合*/
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())); }
        return list;
    }


}
