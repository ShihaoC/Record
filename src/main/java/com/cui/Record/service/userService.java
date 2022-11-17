package com.cui.Record.service;

import com.cui.Record.Mapper.UserMapper;
import com.cui.Record.util.MybatisHelp;
import com.cui.Record.entity.user;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class userService {
    public user login(String name,String password){
        SqlSession session = MybatisHelp.getSession();
        Map<String,String> map = new HashMap<>();
        map.put("userName",name);
        map.put("password",password);
        user login = session.getMapper(UserMapper.class).login(map);
        session.close();
        return login;
    }
}
