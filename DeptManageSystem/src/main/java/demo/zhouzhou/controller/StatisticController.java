package demo.zhouzhou.controller;


import demo.zhouzhou.pojo.JobOption;
import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping(("/report"))
@RestController
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/empJobData")
    public Result getJobOptions() {
        log.info("统计员工职位信息");
        JobOption jobOption = statisticService.getJobOptions();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getGenderData() {
        log.info("统计员工性别信息");
        return Result.success(statisticService.getGenderOptions());
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        log.info("班级人数统计");
        return Result.success(statisticService.getStudentCountData());
    }
}
