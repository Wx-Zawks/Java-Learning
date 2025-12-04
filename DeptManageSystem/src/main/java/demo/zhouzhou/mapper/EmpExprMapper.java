package demo.zhouzhou.mapper;

import demo.zhouzhou.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void saveEmpExprBatch(List<EmpExpr> exprList);
}
