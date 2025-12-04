package demo.zhouzhou.controller;

import demo.zhouzhou.pojo.Emp;
import demo.zhouzhou.pojo.EmpQueryParam;
import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.service.DeptService;
import demo.zhouzhou.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result selectEmps(@RequestParam(defaultValue = "1") Integer pageNum,
//                             @RequestParam(defaultValue = "10") Integer pageSize,
//                             String name, Integer gender,
//                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
//        log.info("查询员工信息: {}, {}, {}, {}, {}, {}", pageNum, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.selectEmps(pageNum, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result selectEmps(EmpQueryParam empQueryParam) {
        log.info("查询员工信息: {}", empQueryParam.toString());
        PageResult<Emp> pageResult = empService.selectEmps(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result saveEmp(@RequestBody Emp emp) {
        log.info("新增员工信息: {}", emp);
        empService.saveEmp(emp);
        return Result.success();

    }
}
