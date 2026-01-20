package demo.zhouzhou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import demo.zhouzhou.mapper.ClazzMapper;
import demo.zhouzhou.pojo.Clazz;
import demo.zhouzhou.pojo.ClazzQueryParam;
import demo.zhouzhou.pojo.PageResult;
import demo.zhouzhou.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> getAllClazz(ClazzQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.selectClazzs(queryParam);
//        处理班级课程信息
        clazzList.forEach(clazz -> {
            if (LocalDateTime.now().isBefore(clazz.getBeginDate().atStartOfDay())) {
                clazz.setStatus("未开班");
            } else if (LocalDateTime.now().isAfter(clazz.getEndDate().atStartOfDay())) {
                clazz.setStatus("已结课");
            } else  {
                clazz.setStatus("在读中");
            }
        });
        Page<Clazz> page = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(page.getResult(), page.getTotal());
    }
}
