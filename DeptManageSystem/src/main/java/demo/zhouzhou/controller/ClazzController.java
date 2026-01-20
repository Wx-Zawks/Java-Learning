package demo.zhouzhou.controller;


import demo.zhouzhou.pojo.Clazz;
import demo.zhouzhou.pojo.ClazzQueryParam;
import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result getAllClazz(ClazzQueryParam queryParam){
        log.info("分页查询班级信息: {}", queryParam.toString());
        PageResult<Clazz> result = clazzService.getAllClazz(queryParam);
        return Result.success(result);
    }
}
