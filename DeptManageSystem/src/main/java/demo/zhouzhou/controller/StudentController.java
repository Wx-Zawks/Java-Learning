package demo.zhouzhou.controller;

import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.pojo.Student;
import demo.zhouzhou.pojo.StudentQueryParam;
import demo.zhouzhou.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(("/students"))
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public Result getStudents(StudentQueryParam studentQueryParam){
        log.info("分页查询学生信息:{}", studentQueryParam.toString());
        PageResult<Student> pageResult = studentService.getStudentsPage(studentQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result addStudent(@RequestBody Student student){
        log.info("添加学生:{}", student.toString());
        studentService.addStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getStudentById(@PathVariable Integer id){
        log.info("根据id查询学生信息：{}", id);
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        log.info("修改学生信息:{}", student.toString());
        studentService.updateStudent(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteStudentById(@PathVariable String ids) throws Exception {
        log.info("根据id批量删除学生:{}", ids);
        studentService.deleteStudents(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateStudentViolation(@PathVariable Integer id, @PathVariable Integer score) throws Exception {
        log.info("学生违纪处理:{},{}", id, score);
        studentService.updateStudentViolation(id, score);
        return Result.success();
    }
}
