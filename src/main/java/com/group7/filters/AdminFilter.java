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
 * @Date: 2023/2/27-13:00
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.filters
 * @Description:
 **/
@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

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

        String role = userData.get("role").asString();
        if (role.equals("admin")) {
            request.setAttribute("isAdmin", true);
        }
        else {
            request.setAttribute("isAdmin", false);
        }
        filterChain.doFilter(request, response);

    }
}
