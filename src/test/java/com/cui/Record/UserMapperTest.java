package com.cui.Record;

import com.cui.Record.Mapper.RecordMapper;
import com.cui.Record.Mapper.StaffMapper;
import com.cui.Record.service.staffService;
import com.cui.Record.util.MybatisHelp;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserMapperTest {
    @Test
    @SneakyThrows
    void test(){
        staffService service = new staffService();
        SqlSession session = MybatisHelp.getSession();
        Map<String,Object> map = new HashMap<>();
        map.put("id",602045939);
        session.getMapper(StaffMapper.class).delete(map);
        session.commit();
    }
}
