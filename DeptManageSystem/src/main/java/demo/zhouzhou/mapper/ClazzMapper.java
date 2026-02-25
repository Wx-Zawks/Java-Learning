package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.Clazz;
import demo.zhouzhou.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> selectClazzs(ClazzQueryParam queryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insertClazz(Clazz clazz);

    @Select("select c.* , e.name as masterName from clazz c left join emp e on c.master_id = e.id where c.id = #{id}")
    Clazz selectClazzById(Integer id);

    void updateClazz(Clazz clazz);

    @Delete("delete from clazz where id = #{id}")
    void deleteClazz(Integer id);

    @Select("select name from clazz")
    List<String> selectClazzName();
}
