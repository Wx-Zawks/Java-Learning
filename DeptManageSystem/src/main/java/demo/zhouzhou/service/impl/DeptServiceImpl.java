package demo.zhouzhou.service.impl;

import demo.zhouzhou.mapper.DeptMapper;
import demo.zhouzhou.pojo.Dept;
import demo.zhouzhou.service.DeptService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public Dept deleteById(Integer id) throws NotFoundException {
        // 步骤1：先查询要删除的部门
        Dept dept = deptMapper.findById(id);
        if (dept == null) {
            throw new NotFoundException("部门不存在，ID：" + id);
        }
        // 步骤2：执行删除
        deptMapper.deleteById(id);
        // 步骤3：返回被删除的部门
        return dept;
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept findById(Integer id) {
        Dept dept = deptMapper.findById(id);
        if (dept != null) {
            return dept;
        }
        return dept;
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
