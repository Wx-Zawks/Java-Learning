package demo.zhouzhou.controller;

import demo.zhouzhou.pojo.Dept;
import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
//        System.out.println("查询全部部门信息");
        log.info("查询全部部门信息");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts")
    public Result delete(@RequestParam(required = true) Integer id) throws Exception {
//        System.out.println("删除部门信息");
        log.info("删除部门信息: {}", id);
        Dept dept = deptService.deleteById(id);
        return Result.success(dept);
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
//        System.out.println("添加部门信息");
        log.info("添加部门信息: {}", dept);
        deptService.add(dept);
        return Result.success(dept);
    }

    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable Integer id) throws NotFoundException {
//        System.out.println("根据ID查询部门信息");
        log.info("根据ID查询部门信息");
        Dept dept = deptService.findById(id); // 复用删除方法来查询
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) throws NotFoundException {
//        System.out.println("更新部门信息");
        log.info("更新部门信息");
        deptService.update(dept); // 复用添加方法来保存更新
        return Result.success();
    }
}
