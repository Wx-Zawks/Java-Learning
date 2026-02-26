package demo.zhouzhou.service;

import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Student;
import demo.zhouzhou.pojo.StudentQueryParam;

public interface StudentService {
    PageResult<Student> getStudentsPage(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void updateStudent(Student student);

    void deleteStudents(String ids) throws Exception;

    void updateStudentViolation(Integer id, Integer score);
}
