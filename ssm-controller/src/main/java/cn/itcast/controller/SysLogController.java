package cn.itcast.controller;

import cn.itcast.doamin.SysLog;
import cn.itcast.service.sysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    sysLogService sysLogService;

    @RequestMapping("/findAll")
public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue ="1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "10")Integer size)
    {
        ModelAndView mv=new ModelAndView();
       List<SysLog> sysLogs= sysLogService.findAll(page,size);
        PageInfo sysLog = new PageInfo(sysLogs);
        mv.addObject("sysLogs",sysLog);
       mv.setViewName("syslog-list");
        return mv;
    }
}
