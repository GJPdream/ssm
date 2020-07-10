package cn.itcast.dao;

import cn.itcast.doamin.Orders;
import cn.itcast.doamin.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDao {
@Select("select * from orders")
@Results({
        @Result(id = true ,property="oid",column="oid"),
        @Result(property = "otime",column = "odate"),
        @Result(property = "ostratus" ,column = "ostratus"),
        @Result(property = "product",column = "opid",
                one = @One(select = "cn.itcast.dao.ProductDao.findById" ,fetchType = FetchType.EAGER))

})
    public List<Orders> findAll();

@Select("select * from orders where oid=#{oid}")
@Results({
        @Result(id = true,property="oid",column="oid"),
        @Result(property = "otime",column = "odate"),
        @Result(property = "ostratus" ,column = "ostratus"),
        @Result(property = "product",column = "opid", one = @One(select = "cn.itcast.dao.ProductDao.findById" ,fetchType = FetchType.EAGER)),
        @Result(property = "member", column = "omid",one = @One(select = "cn.itcast.dao.MemberDao.findById",fetchType = FetchType.EAGER)),
        @Result(property = "travellers",column ="oid",many = @Many(select = "cn.itcast.dao.TravellerDao.findById"))
})
public Orders findById(int oid);
}
