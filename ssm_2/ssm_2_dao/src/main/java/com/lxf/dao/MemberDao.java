package com.lxf.dao;

import com.lxf.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member where id = #{id}")
    Member findById(String id);
}
