package com.group7.filters;

import com.auth0.jwt.interfaces.Claim;
import com.group7.utils.common.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-22:21
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.filters
 * @Description:
 **/
@WebFilter(filterName = "jwtFilter", urlPatterns = "/secure/*")
public class JwtFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(JwtFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setCharacterEncoding("UTF-8");
        //获取header里的token
        String token = request.getHeader("Authorization");
        if ("OPTIONS".equals(request.getMethod())) {              //除了 OPTIONS请求以外, 其它请求应该被JWT检查
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        } else {
            if (token == null) {
                response.getWriter().write("No token！");
                return;
            }
        }

        Map<String, Claim> userData = JwtUtil.verifyToken(token);

        if (userData == null) {
            response.getWriter().write("token不合法！");
            return;
        }
        String id = userData.get("id").asString();
        String username = userData.get("username").asString();
        String openid = userData.get("openid").asString();
        String roles = userData.get("roles").asString();
        String email = userData.get("email").asString();

        //拦截器 拿到用户信息，放到request中
//        System.out.println("id:" + id + " username:" + username + " openid:" + openid);
        request.setAttribute("id", id);
        request.setAttribute("username", username);
        request.setAttribute("openid", openid);
        request.setAttribute("roles", roles);
        request.setAttribute("email", email);

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
