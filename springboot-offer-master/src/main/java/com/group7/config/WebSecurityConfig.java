package com.group7.config;

import com.group7.controller.auth.AuthEntryPointJwt;
import com.group7.controller.user.UserDetailsServiceImpl;
import com.group7.filters.AuthTokenFilter;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/2-17:41
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.config
 * @Description:
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {



    @Value("${spring.h2.console.path}")
    private String h2ConsolePath;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web..requestMatchers("/login").and().;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/*").permitAll()
                .requestMatchers("/instances/**").permitAll()
                .requestMatchers("/actuator/**").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/instances/**").permitAll()
                .requestMatchers("/api/test/**").permitAll()
//                .requestMatchers("/**").permitAll()
                .requestMatchers("/admin/**").permitAll()
                .requestMatchers("/login/**").permitAll()
                .requestMatchers(h2ConsolePath + "/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/static/**").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .requestMatchers("/api/school/public/**").permitAll()
                .requestMatchers("/api/program/public/**").permitAll()
                .requestMatchers("/api/application/public/**").permitAll()
                .requestMatchers("/api/post/public/**").permitAll()
                .requestMatchers("/rest/applications/**").permitAll()
                .requestMatchers("/rest/programs/**").permitAll()
                .requestMatchers("/rest/users/**").permitAll()
                .anyRequest().authenticated();
//                .requestMatchers("/rest/**").permitAll()
//                .requestMatchers("/secure/getUser").permitAll()

//
//                .requestMatchers("/secure/getUser").permitAll()
        // fix H2 database console: Refused to display ' in a frame because it set 'X-Frame-Options' to 'deny'
        http.headers().frameOptions().sameOrigin();

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}