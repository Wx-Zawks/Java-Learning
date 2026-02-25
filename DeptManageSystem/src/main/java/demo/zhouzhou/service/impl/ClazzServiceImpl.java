package demo.zhouzhou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import demo.zhouzhou.mapper.ClazzMapper;
import demo.zhouzhou.mapper.StudentMapper;
import demo.zhouzhou.pojo.Clazz;
import demo.zhouzhou.pojo.ClazzQueryParam;
import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> getAllClazz(ClazzQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.selectClazzs(queryParam);
//        处理班级课程信息
        clazzList.forEach(clazz -> clazz.setClazzStatus());
        Page<Clazz> page = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(page.getResult(), page.getTotal());
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insertClazz(clazz);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        Clazz clazz = clazzMapper.selectClazzById(id);
        clazz.setClazzStatus();
        return clazz;
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazz.setClazzStatus();
        clazzMapper.updateClazz(clazz);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteClazz(Integer id) throws Exception {
        // 步骤1：检查班级是否存在（可选，避免删除不存在的班级）
        Clazz clazz = clazzMapper.selectClazzById(id);
        if (clazz == null) {
            throw new Exception("班级不存在");
        }

        if (studentMapper.countByClazzId(id) > 0) {
            throw new Exception("班级人数不为0");
        }
        clazzMapper.deleteClazz(id);
    }

    @Override
    public List<String> getClazzList() {
        List<String> clazzList = clazzMapper.selectClazzName();
        return clazzList;
    }
}
