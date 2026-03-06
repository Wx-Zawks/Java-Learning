package demo.zhouzhou.interceptor;

import demo.zhouzhou.utils.CurrentHolder;
import demo.zhouzhou.utils.JWTutils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if(request.getRequestURI().endsWith("login")){
//            log.info("登录接口，放行");
//            return true;
//        }
        String token = request.getHeader("token");
        if(token == null || "".equals(token)){
            log.info("令牌为空，禁止放行");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        } else {
            try {
                Claims claims = JWTutils.parseJWT(token);
                Integer empId = (Integer) claims.get("id");
                CurrentHolder.setCurrentId(empId);
                log.info("记录当前用户id：{}并存入ThreadLocal", empId);
            } catch (Exception e) {
                log.info("令牌错误，禁止放行");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
            log.info("校验通过放行");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        CurrentHolder.remove();
        log.info("postHandle");
        log.info("清空ThreadLocal");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

    }
}
