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
    @Select("SELECT * FROM users OFFSET #{offset} LIMIT #{size} ")
    List<User> getAllUser( Integer offset , Integer size);
    @ResultMap("userMapping")
    @Select("SELECT * FROM users WHERE username =  #{userName}")
    User getUserByName(String userName);
    @Select("INSERT INTO users VALUES (default, #{req.userName}, #{req.email}, #{req.password}, #{req.firstName}, #{req.lastName}, #{req.phoneNumber}, #{req.country}, #{req.city}, #{req.address}) RETURNING *")
    User saveUser(@Param("req") UserRequestDto userRequestDto);

    @ResultMap("userMapping")
    @Select("UPDATE users SET email = #{req.email}, password = #{req.password}, first_name = #{req.firstName}, last_name = #{req.lastName}, phone_number = #{req.phoneNumber}, country = #{req.country}, city = #{req.city}, address = #{req.address} WHERE username = #{userName} RETURNING *")
    User updateUserByName(@Param("userName") String userName, @Param("req") UserRequestDto userRequestDto);

    @Delete("DELETE FROM users WHERE username = #{userName}")
    void deleteUserByName(String userName);
}
