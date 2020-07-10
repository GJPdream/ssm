package cn.itcast.dao;

import cn.itcast.doamin.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao {
    @Select("select* from product")
    List<Product> findAll();
    @Insert("insert into product(pname,pdate,psort) values(#{pname},#{pdate},#{psort})")
    void save(Product pt);

    /**
     * 通过id进行查询接
     * @param id
     * @return
     */
    @Select("select * from product where pid=#{id}")
    Product findById(int id);

}
