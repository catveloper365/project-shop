package com.catveloper365.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    /**
     * 스프링 시큐리티 기능 비활성화
     */
    @Bean
    public WebSecurityCustomizer configure(){
        return web -> web.ignoring()
                .antMatchers("/*.html", "/img/**", "/css/**", "/js/**");
    }

    /**
     * 특정 HTTP 요청에 대한 웹 기반 보안 구성
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                //인증,인가 설정
                .authorizeRequests()
                .mvcMatchers("/", "/users/**").permitAll() //모두 접근 가능
                .anyRequest().authenticated() //인증 필요
                .and().build();
    }

    /**
     * 패스워드 인코더로 사용할 빈 등록
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //해시함수를 통해 비밀번호를 암호화하여 저장
    }

}
