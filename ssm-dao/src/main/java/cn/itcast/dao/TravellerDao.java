package cn.itcast.dao;
import cn.itcast.doamin.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface TravellerDao {

    @Select("select * from traveller where tid in (select tid from order_traveller where oid=#{oid})")
    public List<Traveller> findById(int oid);
}
