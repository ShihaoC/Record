package com.cui.Record.controller;

import com.cui.Record.config.Status;
import com.cui.Record.entity.Staff;
import com.cui.Record.entity.Bookkeeping;
import com.cui.Record.service.staffService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys-employee")
@CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class RecordController {
    Logger logger = Logger.getLogger(RecordController.class);
//    @Resource
    private staffService service = new staffService();
//
    @GetMapping("getMapping")
    public List<Bookkeeping> getList(String str) {
        logger.info("查询员工考勤信息-" + str);
        return service.getList(str);
    }

    @GetMapping("delete")
    public String delete(int id) {
        int delete = service.delete(id);
        logger.info("删除考勤信息" + id);
        if (delete > 0) {
            return Status.PASS.toString();
        } else {
            return Status.ERROR.toString();
        }
    }

    @GetMapping("insert")
    public String insert(String date, String name, double work) {
        logger.info("添加考勤信息" + date + "\t" + name + "\t" + work);
        int insert = service.insert(name, date, work);
        if (insert > 0) {
            return Status.PASS.toString();
        } else {
            return Status.ERROR.toString();
        }
    }
    @GetMapping("getStaffs")
    public List<Staff> getList() {
        logger.info("调取员工对象集合");
        return service.getStaffs();
    }

    @PostMapping("updateStaff")
    @ResponseBody
    public String update(@RequestBody Bookkeeping request){
        int update = service.update(request.getDate(), request.getWork(), request.getId());
        if(update>0){
            return Status.PASS.toString();
        }else {
            return Status.ERROR.toString();
        }
    }
}
