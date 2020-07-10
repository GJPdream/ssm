package cn.itcast.dao;

import cn.itcast.doamin.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
    @Select("select * from Member1 where mid=#{omid}")
    public Member findById(int omid);
}
