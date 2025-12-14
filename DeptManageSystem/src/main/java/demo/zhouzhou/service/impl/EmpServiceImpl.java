package demo.zhouzhou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import demo.zhouzhou.mapper.EmpExprMapper;
import demo.zhouzhou.mapper.EmpMapper;
import demo.zhouzhou.pojo.Emp;
import demo.zhouzhou.pojo.EmpExpr;
import demo.zhouzhou.pojo.EmpQueryParam;
import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements  EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;
    //原始分页查询
//    @Override
//    public PageResult<Emp> selectEmps(Integer pageNum, Integer pageSize) {
//        Integer start = (pageNum - 1) * pageSize;
//        Long total = empMapper.countEmps();
//        PageResult<Emp> pageResult = new PageResult<>();
//        pageResult.setTotal(total);
//        pageResult.setRows(empMapper.selectEmps(start, pageSize));
//        return pageResult;

    /*
    * 使用分页插件后的分页查询
    * */
//    @Override
//    public PageResult<Emp> selectEmps(Integer pageNum, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Emp> empList = empMapper.selectEmps(name, gender, begin, end);
//        Page<Emp> page = (Page<Emp>) empList;
//        return new PageResult<Emp>(page.getResult(), page.getTotal());
//    }
    @Override
    public PageResult<Emp> selectEmps(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPageNum(), empQueryParam.getPageSize());
        List<Emp> empList = empMapper.selectEmps(empQueryParam);
        Page<Emp> page = (Page<Emp>) empList;
        return new PageResult<Emp>(page.getResult(), page.getTotal());
    }

    @Transactional
    @Override
    public void saveEmp(Emp emp) {
        //1、保存员工基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.saveEmp(emp);

        //2、保存员工经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(e -> {
                e.setEmpId(emp.getId());
            });
            empExprMapper.saveEmpExprBatch(exprList);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteEmps(List<Integer> ids) {
        //1.批量删除员工基本信息
        empMapper.deleteEmps(ids);
        //2.批量删除员工工作经历信息
        empExprMapper.deleteEmpExpr(ids);
    }

    @Override
    public Emp getEmp(Integer id) {
        return empMapper.getEmp(id);
    }

}
