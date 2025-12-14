package demo.zhouzhou.service;

import demo.zhouzhou.pojo.Emp;
import demo.zhouzhou.pojo.EmpQueryParam;
import demo.zhouzhou.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
//    PageResult<Emp> selectEmps(Integer pageNum, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> selectEmps(EmpQueryParam empQueryParam);

    void saveEmp(Emp emp);

    void deleteEmps(List<Integer> ids);
}
