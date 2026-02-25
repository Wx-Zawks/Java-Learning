package demo.zhouzhou.service;

import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Student;
import demo.zhouzhou.pojo.StudentQueryParam;

public interface StudentService {
    PageResult<Student> getStudentsPage(StudentQueryParam studentQueryParam);
}
