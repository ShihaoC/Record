package com.cui.Record.util;

import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisHelp {
    private static SqlSession session = null;
    @SneakyThrows
    public static SqlSession getSession(){
        Reader resources = Resources.getResourceAsReader("mybatis.xml");
        // 根据配置文件生成session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resources);
        // 生成一个session
        session = factory.openSession();
        return session;
    }

    public static void closeSession(){
        if(session != null) session.close();
    }
}
