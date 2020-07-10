package cn.itcast.controller;

import cn.itcast.doamin.Permission;
import cn.itcast.doamin.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll()
    {
        ModelAndView mv= new ModelAndView();
        List<Role> all = roleService.findAll();
        mv.addObject("roleList",all);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 角色添加
     * @param role
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Role role)
    {
        roleService.save(role);
        return "redirect:findAll";
    }

    /**
     * 角色和权限的查询
     * @param id
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name ="id") String id)
{
    ModelAndView mv = new ModelAndView();
     Role role=roleService.findById(id);
     List<Permission> permissions=roleService.findOtherPermission(id);
    mv.addObject("role",role);
    mv.addObject("permissionList",permissions);
    mv.setViewName("role-permission-add");
    return mv;
}

@RequestMapping("/addRoleToPermission")
    public String addRoleToPermission(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String permissionId [])
{
    System.out.println("controoler");
    roleService.addRoleToPermission(roleId,permissionId);
    return "redirect:findAll";
}

}
