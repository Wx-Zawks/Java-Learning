package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.JobOption;
import demo.zhouzhou.pojo.JobOptionList;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticMapper {

    List<JobOptionList> getJobOption();

    @MapKey("name")
    List<Map<String, Object>> getGenderStastistic();
}
