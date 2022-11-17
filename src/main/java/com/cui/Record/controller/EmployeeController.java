package com.cui.Record.controller;

import com.cui.Record.config.Status;
import com.cui.Record.entity.Staff;
import com.cui.Record.service.EmployeeService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@CrossOrigin
@RequestMapping("/Em")
public class EmployeeController {
    @GetMapping("/getList")
    public List<Staff> getList(){
        EmployeeService service = new EmployeeService();
        return service.getList();
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Staff staff){
        EmployeeService service = new EmployeeService();
        int insert = service.insert(staff.getName(), staff.getDate());
        if(insert > 0){
            return Status.PASS.toString();
        }else {
            return Status.ERROR.toString();
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Staff staff){
        EmployeeService service = new EmployeeService();
        int delete = service.delete(staff.getId());
        if(delete >0){
            return Status.PASS.toString();
        }else {
            return Status.ERROR.toString();
        }
    }

    @PostMapping("/update")
    public String update(@RequestBody Staff staff){
        System.out.println(staff);
        EmployeeService service = new EmployeeService();
        int update = service.update(staff);
        if(update > 0){
            return Status.PASS.toString();
        }else {
            return Status.ERROR.toString();
        }
    }
}
