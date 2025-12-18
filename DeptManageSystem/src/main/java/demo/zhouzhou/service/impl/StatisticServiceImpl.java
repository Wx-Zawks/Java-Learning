package demo.zhouzhou.service.impl;

import demo.zhouzhou.mapper.StatisticMapper;
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
}
