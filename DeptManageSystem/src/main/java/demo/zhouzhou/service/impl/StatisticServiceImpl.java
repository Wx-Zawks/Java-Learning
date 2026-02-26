package demo.zhouzhou.service.impl;

import demo.zhouzhou.mapper.StatisticMapper;
import demo.zhouzhou.pojo.ClazzStatisticVO;
import demo.zhouzhou.pojo.JobOption;
import demo.zhouzhou.pojo.JobOptionList;
import demo.zhouzhou.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticMapper statisticMapper;

    @Override
    public JobOption getJobOptions() {
        JobOption jobOption = new JobOption();
        List<String> jobList = new ArrayList();
        List<Integer> dataList = new ArrayList();
        List<JobOptionList> jobOptionList = statisticMapper.getJobOption();
        jobOptionList.forEach(item -> {
            jobList.add(item.getPos());
            dataList.add(item.getNum());
        });
        jobOption.setJobList(jobList);
        jobOption.setDataList(dataList);
        return jobOption;
    }

    @Override
    public List<Map<String, Object>> getGenderOptions() {
        return statisticMapper.getGenderStastistic();
    }

    @Override
    public ClazzStatisticVO getStudentCountData() {
        List<Map<String, Object>> mapList = statisticMapper.selectStudentCountData();
        // 2. 初始化 VO 和两个列表
        ClazzStatisticVO vo = new ClazzStatisticVO();
        List<String> clazzList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        // 3. 遍历原始数据，拆分到两个列表（顺序一一对应）
        for (Map<String, Object> map : mapList) {
            String clazzName = (String) map.get("name");
            Integer studentCount = ((Number) map.get("count")).intValue(); // 兼容 Long/Integer

            clazzList.add(clazzName);
            dataList.add(studentCount);
        }

        // 4. 给 VO 赋值
        vo.setClazzList(clazzList);
        vo.setDataList(dataList);

        return vo;
    }
}
