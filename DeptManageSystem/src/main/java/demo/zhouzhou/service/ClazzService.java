package demo.zhouzhou.service;

import demo.zhouzhou.pojo.Clazz;
import demo.zhouzhou.pojo.ClazzQueryParam;
import demo.zhouzhou.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    PageResult<Clazz> getAllClazz(ClazzQueryParam queryParam);

    void addClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void updateClazz(Clazz clazz);

    void deleteClazz(Integer id) throws Exception;

    List<String> getClazzList();
}
