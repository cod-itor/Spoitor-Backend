package com.example.spoitorreplacement.Repository;

import com.example.spoitorreplacement.Model.Entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM users")
    List<User> getAllUser();



}
