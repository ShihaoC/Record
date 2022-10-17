package com.cui.Record.service;

import com.cui.Record.entity.Staff;
import com.cui.Record.entity.recordE;

import java.util.List;

public interface staffService {
    List<recordE> getList(String str);

    int delete(String name, String date, long work);

    int insert(String name, String date, int work);

    List<Staff> getStaffs();

    int insertStaff(long id, String name);
}
