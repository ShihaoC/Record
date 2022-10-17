package com.cui.Record.service.impl;

import com.cui.Record.dao.baseDao;
import com.cui.Record.entity.user;
import com.cui.Record.service.userService;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class userServiceImpl extends baseDao implements userService {
    public ResultSet rs = null;

    @Override
    public user login(String name, String password) {
        user user = null;
        String sql = "select * from sys_user where name = ? and password = ? ";
        super.Query(sql, new Object[]{name, password});
        rs = super.rs;
        try {
            while (rs.next()) {
                user = new user(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
