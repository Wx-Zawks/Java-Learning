package demo.zhouzhou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import demo.zhouzhou.mapper.StudentMapper;
import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Student;
import demo.zhouzhou.pojo.StudentQueryParam;
import demo.zhouzhou.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public PageResult<Student> getStudentsPage(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> studentList = studentMapper.selectStudents(studentQueryParam);
        Page<Student> page = (Page<Student>) studentList;
        return new PageResult<Student>(page.getResult(), page.getTotal());
    }
}
