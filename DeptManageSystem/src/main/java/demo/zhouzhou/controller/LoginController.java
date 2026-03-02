package demo.zhouzhou.controller;

import demo.zhouzhou.pojo.Emp;
import demo.zhouzhou.pojo.LoginInfo;
import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("请求登录:{}",emp);
        LoginInfo loginInfo = empService.login(emp);
        if(loginInfo!=null){
            return Result.success(loginInfo);
        } else {
            return Result.error("用户名或密码错误");
        }
    }
}
