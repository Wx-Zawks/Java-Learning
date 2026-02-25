package demo.zhouzhou.controller;

import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.pojo.Student;
import demo.zhouzhou.pojo.StudentQueryParam;
import demo.zhouzhou.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
