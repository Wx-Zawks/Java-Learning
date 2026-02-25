package demo.zhouzhou.service;

import demo.zhouzhou.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface StatisticService {
    JobOption getJobOptions();

    List<Map<String, Object>> getGenderOptions();
}
