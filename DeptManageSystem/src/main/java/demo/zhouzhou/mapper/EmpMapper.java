package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.Emp;
import demo.zhouzhou.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//原始分页查询
//    @Select("select count(*) from emp;")
//    Long countEmps();
//
//    @Select("select emp.*, dept.name deptName from emp left join dept on emp.dept_id = dept.id  order by emp.update_time  desc limit #{start}, #{pageSize};")
//    List<Emp> selectEmps(Integer start, Integer pageSize);

    //使用分页插件后的分页查询
//    @Select("select emp.*, dept.name deptName from emp left join dept on emp.dept_id = dept.id " +
//            "where #{} like " +
//            "order by emp.update_time desc")
//    List<Emp> selectEmps(String name, Integer gender, LocalDate begin,LocalDate end);

    List<Emp> selectEmps(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) VALUES (#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void saveEmp(Emp emp);

    void deleteEmps(List<Integer> ids);
}
