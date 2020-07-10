package cn.itcast.controller;

import cn.itcast.doamin.Orders;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

 /*   @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name ="id",required = true) String ordersId){
        ModelAndView mv = new ModelAndView();
        return mv;
    }*/

/* 查询全部订单没有分页的*/
/*@RequestMapping("/findAll")
    public ModelAndView findAll()
{
    ModelAndView mv = new ModelAndView();
    List<Orders> all = orderService.findAll();
    ModelAndView modelAndView = mv.addObject("ordersList", all);
    System.out.println(all);
    mv.setViewName("orders-list");
   return mv;
}*/


/*分页的*/
@RequestMapping("/findAll")
public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size)
{
    ModelAndView mv = new ModelAndView();
    List<Orders> all = orderService.findAll(page,size);
    /*pageinfo就是一个分页的bean*/
    PageInfo pageInfo = new PageInfo(all);
    ModelAndView modelAndView = mv.addObject("ordersInfo", pageInfo);
    System.out.println(all);
    mv.setViewName("orders-page-list");
    return mv;
}
@RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id" ,required = true)  Integer oid)
{

   /* System.out.println(oid);
    System.out.println("1".equals(oid));*/
    ModelAndView mv = new ModelAndView();
    Orders byId = orderService.findById(oid);
/*    System.out.println(byId);*/
    mv.addObject("orders",byId);
    mv.setViewName("orders-show");
    return mv;
}
}
