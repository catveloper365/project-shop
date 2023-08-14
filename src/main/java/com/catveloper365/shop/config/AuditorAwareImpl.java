package com.catveloper365.shop.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    /**
     * 현재 로그인한 사용자의 정보를 조회하여 사용자의 이름(이메일)을 등록자, 수정자로 지정
     * @return 현재 로그인한 사용자의 이름(이메일)
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = "";
        if(authentication != null){
            userEmail = authentication.getName(); //현재 로그인한 사용자의 이메일
        }
        return Optional.of(userEmail);
    }
}
