package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.Student;
import demo.zhouzhou.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT COUNT(*) from student where clazz_id = #{id}")
    public Integer countByClazzId(Integer id);

    List<Student> selectStudents(StudentQueryParam studentQueryParam);
}
