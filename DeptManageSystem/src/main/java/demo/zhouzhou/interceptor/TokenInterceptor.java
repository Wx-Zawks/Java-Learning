package demo.zhouzhou.interceptor;

import demo.zhouzhou.utils.JWTutils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

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
                JWTutils.parseJWT(token);
            } catch (Exception e) {
                log.info("令牌错误，禁止放行");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
            log.info("校验通过放行");
            return true;
        }
    }
}
