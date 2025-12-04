package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id, name, create_time, update_time from dept order by update_time desc;")
    List<Dept> findAll();

    @Select("select id, name, create_time, update_time from dept where id = #{id};")
    Dept findById(Integer id); // 新增：根据id查询部门

    @Delete("delete from dept where id = #{id};")
    Integer deleteById(Integer id); // 修改：返回影响的行数（1表示删除成功，0表示未找到）

    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime});")
    void add(Dept dept);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id};")
    void update(Dept dept);
}
