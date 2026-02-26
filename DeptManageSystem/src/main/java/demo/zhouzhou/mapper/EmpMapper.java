package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.Emp;
import demo.zhouzhou.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
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

    Emp getEmp(Integer id);

    @Select("select * from emp where dept_id = #{deptId}")
    Emp selectEmpByDeptId(Integer deptId);
//    @Update("update emp " +
//            "set username = #{username}, password = #{password}, name = #{name}, gender = #{gender}, phone = #{phone}, job = #{job}, salary = #{salary}, image = #{image}, entry_date = #{entryDate}, dept_id = #{deptId}, create_time = #{createTime}, update_time = #{updateTime} " +
//            "where id = #{id}"
//    )
    void updateEmp(Emp emp);

    @Select("select emp.name from emp")
    List<String> selectEmpNames();
}
