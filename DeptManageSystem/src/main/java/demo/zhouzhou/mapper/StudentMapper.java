package demo.zhouzhou.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {

    @Select("SELECT COUNT(*) from student where clazz_id = #{id}")
    public Integer countByClazzId(Integer id);
}
