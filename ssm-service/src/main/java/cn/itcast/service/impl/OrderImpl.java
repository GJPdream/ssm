package cn.itcast.service.impl;

import cn.itcast.dao.OrderDao;
import cn.itcast.doamin.Orders;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderImpl implements OrderService {
    @Autowired
   private OrderDao orderDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        //参数pageNum是页码值，参数pageSize代表是每页显示条数
        /*就是第一页开始到第五个结束
        * 必须写在调用代码的前面，不然你那样写就废掉了
        * */
        /*里面是那一页，并且每页显示多少条记录*/
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(int oid) {
      /*  System.out.println("1".equals(oid));
        System.out.println(oid);*/
        return orderDao.findById(oid);

    }
}
