package com.example.demo.config;

import com.example.demo.jwt_token.AuthEntryPointJwt;
import com.example.demo.jwt_token.AuthTokenFilter;
import com.example.demo.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //WebSecurityConfigurerAdapter là mấu chốt của việc triển khai bảo mật của chúng tôi.// Nó cung cấp cấu hình HttpSecurity để định cấu hình cors, csrf,quản lý phiên, quy tắc cho tài nguyên được bảo vệ. Chúng tôi cũng có thể mở rộng và tùy chỉnh cấu hình mặc định chứa các phần tử bên dưới.
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    //Giao diện UserDetailsService có một phương thức để tải Người dùng bằng tên người dùng và trả về một đối tượng UserDetails mà Spring Security có thể sử dụng để xác thực và xác nhận.
//UserDetails chứa thông tin cần thiết (chẳng hạn như: tên người dùng, mật khẩu, quyền hạn) để xây dựng một đối tượng Xác thực.

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/menu/**").permitAll()
                .antMatchers("/**").permitAll()

                .antMatchers("/api/account/login","/api/account/userName","/api/account/refreshPassword").permitAll()
                .and().authorizeRequests().antMatchers("/api/account/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")

                .and().authorizeRequests().antMatchers("/api/table/delete", "/api/table/add").access("hasAnyRole('ROLE_ADMIN')")
                .and().authorizeRequests().antMatchers("/api/table/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .anyRequest().authenticated();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}