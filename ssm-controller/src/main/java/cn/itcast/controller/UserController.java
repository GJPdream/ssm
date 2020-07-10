package cn.itcast.controller;

import cn.itcast.doamin.Role;
import cn.itcast.doamin.UserInfo;
import cn.itcast.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/findAll")
    /*权限注解admin*/
    /*@RolesAllowed("ADMIN")*/
   /* @Secured("ROLE_ADMIN")*/
    /*@PreAuthorize("hasRole('ROLE_ADMIN')")*/
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> all = userInfoService.findAll();
        mv.addObject("userList",all);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/save")
    public String save(UserInfo userInfo)
    {
        userInfoService.save(userInfo);
          /* 这个就是重定向操作*/
        return "redirect:findAll";

    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id)
    {
        ModelAndView mv = new ModelAndView();
        UserInfo byId = userInfoService.findById(id);
        mv.addObject("user",byId);
        mv.setViewName("user-show");
        return  mv;
    }

    /**
     * 添加角色
     * @param id
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String id)
    {
        System.out.println(123456);
        ModelAndView mv = new ModelAndView();
        /*根据id进行查询角色信息*/
        UserInfo byId = userInfoService.findById1(id);
        System.out.println(byId);
        /*根据id查询查询可以添加的id*/
        List<Role> otherRoles= userInfoService.findOtherRoles(id);
        System.out.println(otherRoles);
        mv.addObject("user",byId);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
      /*  return mv;*/
    }

/*给用户添加角色*/
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String ids[] )
    {
        userInfoService.addRoleToUser(userId,ids);
        return "redirect:findAll";
    }

}
