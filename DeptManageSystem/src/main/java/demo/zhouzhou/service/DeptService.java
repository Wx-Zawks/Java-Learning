package demo.zhouzhou.service;

import demo.zhouzhou.pojo.Dept;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();

    public Dept deleteById(Integer id) throws NotFoundException;

    void add(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
