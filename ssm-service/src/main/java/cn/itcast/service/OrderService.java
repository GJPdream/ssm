package cn.itcast.service;

import cn.itcast.doamin.Orders;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.List;

public interface OrderService {
    List<Orders>findAll(int page,int size);
    Orders findById(int oid);
}
