package demo.zhouzhou.controller;


import demo.zhouzhou.pojo.Clazz;
import demo.zhouzhou.pojo.ClazzQueryParam;
import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
        log.info("添加班级: {}", clazz.toString());
        clazzService.addClazz(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable Integer id){
        log.info("根据ID查询班级信息：{}",id);
        Clazz clazz = clazzService.getClazzById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz){
        log.info("更新班级信息：{}",clazz.toString());
        clazzService.updateClazz(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id) throws Exception {
        log.info("根据id删除班级: {}",id);
        clazzService.deleteClazz(id);
        return Result.success();
    }
}
