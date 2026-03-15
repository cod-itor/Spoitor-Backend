package com.example.spoitorreplacement.Model.Config;

import com.example.spoitorreplacement.Model.Entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public User user(){
        return new User("Coditor" , "Rector@gmail.com" , "rector" , "rector" ,"Dita" , "012312", "PhnomPenh", "sdf", "sdfasdf");
    }
}
