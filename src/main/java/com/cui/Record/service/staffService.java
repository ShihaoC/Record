package com.cui.Record.service;

import com.cui.Record.Mapper.RecordMapper;
import com.cui.Record.Mapper.StaffMapper;
import com.cui.Record.util.MybatisHelp;
import com.cui.Record.entity.Staff;
import com.cui.Record.entity.Bookkeeping;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class staffService {
    /**
     * 获取员工考勤记录
     *
     * @param str all为全部 其他为员工名称
     * @return 某个人的信息
     */
    public List<Bookkeeping> getList(String str) {
        SqlSession session = MybatisHelp.getSession();
        List<Bookkeeping> list = new ArrayList<>();
        if(str == null || str.equals("") || str.equals("所有人") || str.equals("all")){
            list = session.getMapper(RecordMapper.class).getList();
        }else {
            Map<String,String> map = new HashMap<>();
            map.put("name",str);
            list = session.getMapper(RecordMapper.class).getSimple(map);
        }
        return list;
    }

    /**
     * 删除某一条考勤记录
     *
     * @return 影响的行数
     */
    public int delete(int id) {
        SqlSession session = MybatisHelp.getSession();
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        int remove = session.getMapper(RecordMapper.class).remove(map);
        session.commit();
        return remove;
    }

    /**
     * 添加考勤记录
     *
     * @param name 姓名
     * @param date 日期
     * @param work 工数
     * @return 影响的行数
     */
    public int insert(String name, String date, double work) {
        Map<String,Object> map = new HashMap<>();
        map.put("date",date);
        map.put("name",name);
        map.put("work",work);
        SqlSession session = MybatisHelp.getSession();
        int insert = session.getMapper(RecordMapper.class).insert(map);
        session.commit();
        return insert;
    }

    /**
     * 获取员工集合
     *
     * @return 员工集合
     */
    public List<Staff> getStaffs() {
        List<Staff> staffList = new ArrayList<>();
        staffList = MybatisHelp.getSession().getMapper(StaffMapper.class).selectAll();
        return staffList;
    }
//
//    /**
//     * 添加员工信息
//     *
//     * @param id   id
//     * @param name 姓名
//     * @return 影响的行数
//     */
//    public int insertStaff(long id, String name) {
//        synchronized (this) {
//            int result;
//            super.Query("select * from sys_staff", null);
//            try {
//                if (super.rs.next()) {
//                    return 0;
//                }
//                result = super.DML("insert into sys_staff(id,name) value(?,?)", new Object[]{id, name});
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//
//            return result;
//        }
//    }
//
    public String getId() {
        StringBuilder buffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }

    public int update(String date, double work,int id) {
        SqlSession session = MybatisHelp.getSession();
        Map<String,Object> map = new HashMap<>();
        map.put("date",date);
        map.put("work",work);
        map.put("id",id);
        int update = session.getMapper(RecordMapper.class).update(map);
        session.commit();
        return update;
    }
}
