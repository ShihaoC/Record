package com.cui.Record.service;

import com.cui.Record.Mapper.StaffMapper;
import com.cui.Record.entity.Staff;
import com.cui.Record.util.MybatisHelp;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EmployeeService {
    // 产生ID的方法
    public String getId() {
        StringBuilder buffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }
    // 获取员工对象
    public List<Staff> getList() {
        SqlSession session = MybatisHelp.getSession();
        return session.getMapper(StaffMapper.class).selectAll();
    }
    // 添加员工
    public int insert(String name, String date) {
        SqlSession session = MybatisHelp.getSession();
        Map<String, String> map = new HashMap<>();
        map.put("id", getId());
        map.put("name", name);
        map.put("date", date);
        int insert = session.getMapper(StaffMapper.class).insert(map);
        session.commit();
        return insert;
    }
    // 删除员工对象
    public int delete(long id){
        SqlSession session = MybatisHelp.getSession();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        int delete = session.getMapper(StaffMapper.class).delete(map);
        session.commit();
        return delete;
    }
    // 修改员工数据
    public int update(Staff staff){
        Map<String,Object> map = new HashMap<>();
        SqlSession session = MybatisHelp.getSession();
        map.put("name",staff.getName());
        map.put("date",staff.getDate());
        map.put("id",staff.getId());
        int update = session.getMapper(StaffMapper.class).update(map);
        session.commit();
        return update;
    }
}
