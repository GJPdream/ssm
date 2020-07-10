package cn.itcast.controller;

import cn.itcast.doamin.Permission;
import cn.itcast.service.PremissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class premissionController {
    @Autowired
    PremissionService premissionService;
    @RequestMapping("/findAll")
    public ModelAndView findAll()
    {
        ModelAndView mv = new ModelAndView();
        List<Permission> all = premissionService.findAll();
        mv.addObject("premissionList",all);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Permission permission)
    {
        premissionService.save(permission);
        return "redirect:findAll";
    }
}
