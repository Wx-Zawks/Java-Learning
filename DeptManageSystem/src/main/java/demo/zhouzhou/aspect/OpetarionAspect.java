package demo.zhouzhou.aspect;

import demo.zhouzhou.mapper.OperateLogMapper;
import demo.zhouzhou.pojo.OperateLog;
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
        OperateLog log = new OperateLog();
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        log.setOperateTime(LocalDateTime.now());
        log.setCostTime(time);
        log.setMethodName(joinPoint.getSignature().getName());
        log.setClassName(joinPoint.getTarget().getClass().getName());
        log.setMethodParams(joinPoint.getArgs().toString());
        log.setReturnValue(result.toString());
        log.setOperateEmpId(1);
        operateLogMapper.insert(log);
        return result;
    }
}
