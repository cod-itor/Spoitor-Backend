package com.example.spoitorreplacement.Repository;

import com.example.spoitorreplacement.Model.Entities.User;
import com.example.spoitorreplacement.Model.Request.UserRequestDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {

    @Results(id = "userMapping" , value = {
            @Result(property = "firstName" , column = "first_name"),
            @Result(property = "lastName" , column = "last_name"),
            @Result(property = "phoneNumber" , column = "phone_number")
    })
    //don't know how to fix this
    @Select("SELECT * FROM users ORDER BY LIMIT #{req.size} OFFSET #{req.page} ")
    List<User> getAllUser(@Param("req") int page , Integer size);
    @ResultMap("userMapping")
    @Select("SELECT * FROM users WHERE username =  #{userName}")
    User getUserByName(String userName);
    @Select("INSERT INTO users VALUES (default, #{req.userName}, #{req.email}, #{req.password}, #{req.firstName}, #{req.lastName}, #{req.phoneNumber}, #{req.country}, #{req.city}, #{req.address}) RETURNING *")
    User saveUser(@Param("req") UserRequestDto userRequestDto);



}
