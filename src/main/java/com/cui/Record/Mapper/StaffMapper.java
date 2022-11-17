package com.cui.Record.Mapper;

import com.cui.Record.entity.Staff;

import java.util.List;
import java.util.Map;

public interface StaffMapper {
    List<Staff> selectAll();
    int insert(Map map);
    int delete(Map map);
    int update(Map map);
}
