package com.group7.config;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-18:20
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.config
 * @Description:
 **/
@Configuration
@Component
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 所有方法都会处理跨域请求
//                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .allowedOrigins("http://127.0.0.1:8080")    // 允许请求的域名
                .allowedHeaders("*");    // 允许的请求头

        WebMvcConfigurer.super.addCorsMappings(registry);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**")
//                //放行路径，可以添加多个
//                .excludePathPatterns("/api/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // get the resource location (resources/static)
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String projectDir = System.getProperty("user.dir");
        String resourceLocation = projectDir  + "\\src\\main\\resources\\static\\";
        if(System.getProperty("os.name").toLowerCase().contains("linux")){
            resourceLocation = projectDir  + "src/main/resources/static/";
        }
        System.out.println("============================================");
        System.out.println(resourceLocation);
        System.out.println("============================================");

        // map the resources/static dir to the http://.../img/
        registry.addResourceHandler("/static/**")
                .addResourceLocations("file:" + resourceLocation);

    }
}
