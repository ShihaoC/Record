package com.cui.Record.Mapper;

import com.cui.Record.entity.Bookkeeping;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    List<Bookkeeping> getList();
    List<Bookkeeping> getSimple(Map map);
    int remove(Map map);
    int insert(Map map);
    int update(Map map);
}
