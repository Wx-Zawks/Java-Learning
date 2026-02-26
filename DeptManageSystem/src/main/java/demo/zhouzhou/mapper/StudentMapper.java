package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.Student;
import demo.zhouzhou.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT COUNT(*) from student where clazz_id = #{id}")
    public Integer countByClazzId(Integer id);

    List<Student> selectStudents(StudentQueryParam studentQueryParam);

    @Insert("insert into student (name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, create_time, update_time)" +
            "values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    void insertStudent(Student student);

    @Select("select s.*,c.name as clazzName from student s left join clazz c on s.clazz_id = c.id where s.id = #{id}")
    Student selectStudent(Integer id);

    void updateStudent(Student student);

    void deleteStudent(List<Integer> idList);

    @Update("update student set violation_score = violation_score + #{score},violation_count = violation_count + 1 where id = #{id}")
    void updateStudentViolation(Integer id, Integer score);
}
