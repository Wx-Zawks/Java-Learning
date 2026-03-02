package demo.zhouzhou.filter;

import demo.zhouzhou.utils.JWTutils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(request.getRequestURI().endsWith("login")){
            log.info("登录接口，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String token = request.getHeader("token");
        if(token == null || "".equals(token)){
            log.info("令牌为空，禁止放行");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        } else {
            try {
                JWTutils.parseJWT(token);
            } catch (Exception e) {
                log.info("令牌错误，禁止放行");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            log.info("校验通过放行");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
