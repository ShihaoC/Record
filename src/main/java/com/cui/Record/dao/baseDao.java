package com.cui.Record.dao;

import com.cui.Record.config.SQLConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.*;

@Component
@RestController
public class baseDao {
    public ResultSet rs;
    @Resource
    private SQLConfig config;
    private Connection con;
    private PreparedStatement pstm;

    /**
     * 连接数据库
     */
    public void getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(config.getUrl() + config.getDatabase() + config.getEULA(),
                    config.getUser(),
                    config.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行增删改操作
     *
     * @param sql  SQL语句
     * @param objs 防止SLQ注入
     * @return 影响的行数
     */
    public int DML(String sql, Object[] objs) {
        getCon();
        int result = 0;
        try {
            pstm = con.prepareStatement(sql);
            if (objs != null) {
                for (int i = 0; i < objs.length; i++) {
                    pstm.setObject(i + 1, objs[i]);
                }
            }
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    /**
     * 执行查询操作
     *
     * @param sql  SQL语句
     * @param objs 防止SQL注入
     */
    public void Query(String sql, Object[] objs) {
        getCon();
        try {
            pstm = con.prepareStatement(sql);
            if (objs != null) {
                for (int i = 0; i < objs.length; i++) {
                    pstm.setObject(i + 1, objs[i]);
                }
            }
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
