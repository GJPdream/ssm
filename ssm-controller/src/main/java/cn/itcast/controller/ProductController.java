package cn.itcast.controller;

import cn.itcast.doamin.Product;
import cn.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController  {
    @Autowired
    private ProductService productService;
    /*保存产品*/
    @RequestMapping("/save")
    public String save(Product pt)
    {
        productService.save(pt);
        /*查询完之后我们重新查询一遍我们的数据
        * 在这个我们重定向一下就行了
        * */
        /*System.out.println(pt);*/
        return "redirect:findAll";
    }
    /*查询产品*/
@RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception
    {
     ModelAndView mv=new ModelAndView();
        List<Product> all = productService.findAll();
        mv.addObject("productList",all);
        mv.setViewName("product-list1");
        return mv;
    }

}
