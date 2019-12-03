package com.zza.crud.Mapper;

import com.zza.crud.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User loginUser(String username);
    @Insert("insert into user values(#{username},#{password},#{phnumber},#{QQ})")
    int register(String username,String password,String phnumber,String QQ);
}
