package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.Clazz;
import demo.zhouzhou.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> selectClazzs(ClazzQueryParam queryParam);
}
