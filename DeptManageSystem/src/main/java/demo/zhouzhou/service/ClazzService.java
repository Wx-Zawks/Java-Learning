package demo.zhouzhou.service;

import demo.zhouzhou.pojo.Clazz;
import demo.zhouzhou.pojo.ClazzQueryParam;
import demo.zhouzhou.pojo.PageResult;

public interface ClazzService {

    PageResult<Clazz> getAllClazz(ClazzQueryParam queryParam);
}
