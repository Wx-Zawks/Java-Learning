package demo.zhouzhou.exception;

import demo.zhouzhou.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错：", e);
        return Result.error("程序出错了");
    }

    @ExceptionHandler
    public Result handleDuplicatedException(DuplicateKeyException e) {
        log.error("程序出错：", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error("错误：" + arr[2] + " 已存在");
    }

}
