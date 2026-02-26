package demo.zhouzhou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import demo.zhouzhou.mapper.StudentMapper;
import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Student;
import demo.zhouzhou.pojo.StudentQueryParam;
import demo.zhouzhou.service.StudentService;
import demo.zhouzhou.utils.NumberStringParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    @Override
    public void addStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insertStudent(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudents(String ids) throws Exception {
        List<Integer> idList = NumberStringParser.parseNumStringToList(ids);
        if(idList.size()>0){
            studentMapper.deleteStudent(idList);
        } else {
            throw new Exception("无效id");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStudentViolation(Integer id, Integer score) {
        Student student = studentMapper.selectStudent(id);
        student.setUpdateTime(LocalDateTime.now());
        if (student != null) {
            studentMapper.updateStudentViolation(id, score);
        }
    }
}
