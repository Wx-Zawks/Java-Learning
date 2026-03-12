package demo.zhouzhou.aspect;

import demo.zhouzhou.mapper.OperateLogMapper;
import demo.zhouzhou.pojo.OperateLog;
import demo.zhouzhou.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class OpetarionAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(demo.zhouzhou.annotation.OperatorLogAnnotation)")
    public Object RecordOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("记录操作日志保存至数据库");
        OperateLog olog = new OperateLog();
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        // 封装操作日志
        olog.setOperateTime(LocalDateTime.now());
        olog.setCostTime(time);
        olog.setMethodName(joinPoint.getSignature().getName());
        olog.setClassName(joinPoint.getTarget().getClass().getName());
        olog.setMethodParams(joinPoint.getArgs().toString());
        olog.setReturnValue(result.toString());
        Integer empId = CurrentHolder.getCurrentId();
        olog.setOperateEmpId(empId);
        operateLogMapper.insert(olog);
        log.info("保存操作日志成功");
        return result;
    }
}
