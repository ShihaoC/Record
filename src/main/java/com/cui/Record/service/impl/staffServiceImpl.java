package com.cui.Record.service.impl;

import com.cui.Record.dao.baseDao;
import com.cui.Record.entity.Staff;
import com.cui.Record.entity.recordE;
import com.cui.Record.service.staffService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class staffServiceImpl extends baseDao implements staffService {
    /**
     * 获取员工考勤记录
     * @param str all为全部 其他为员工名称
     * @return 某个人的信息
     */
    @Override
    public List<recordE> getList(String str) {
        synchronized (this) {
            List<recordE> list = new ArrayList<>();
            ResultSet rs = null;
            if(str.equals("all")){
                super.Query("select * from sys_record",null);
                rs = super.rs;
                try {
                    while (rs.next()){
                        list.add(new recordE(rs.getString("date"),rs.getString("name"),rs.getInt("work")));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else {
                super.Query("select * from sys_record where name = ?",new Object[]{str});
                rs = super.rs;
                try {
                    while (rs.next()){
                        list.add(new recordE(rs.getString("date"),rs.getString("name"),rs.getInt("work")));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return list;
        }
    }

    /**
     * 删除某一条考勤记录
     * @param name 姓名
     * @param date 日期
     * @return 影响的行数
     */
    @Override
    public int delete(String name, String date,long work) {
        synchronized (this) {
            return super.DML("delete from sys_record where name = ? and date = ? and work = ?", new Object[]{name, date,work});
        }
    }

    /**
     * 添加考勤记录
     * @param name 姓名
     * @param date 日期
     * @param work 工数
     * @return 影响的行数
     */
    @Override
    public int insert(String name, String date, int work) {
        return super.DML("insert into sys_record(date,name,work) values(?,?,?)",new Object[]{date,name,work});
    }

    /**
     * 获取员工集合
     * @return 员工集合
     */
    @Override
    public List<Staff> getStaffs() {
        List<Staff> staffList = new ArrayList<>();
        super.Query("select * from sys_staff",null);
        ResultSet rs = super.rs;
        try {
            while (rs.next()){
                staffList.add(new Staff(rs.getLong("id"),rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffList;
    }

    /**
     * 添加员工信息
     * @param id id
     * @param name 姓名
     * @return 影响的行数
     */
    @Override
    public int insertStaff(long id,String name) {
        synchronized (this) {
            return super.DML("insert into sys_staff(id,name) value(?,?)", new Object[]{id, name});
        }
    }

    public String getId(){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }
}
