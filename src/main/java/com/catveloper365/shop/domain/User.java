package com.catveloper365.shop.domain;

import com.catveloper365.shop.constant.Address;
import com.catveloper365.shop.constant.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails{
    /*
    UserDetails는 스프링 시큐리티에서 사용자 인증 정보를 담아두는 인터페이스
    UserDetails를 상속받아 인증 객체로 사용
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email; //로그인 id로 사용

    @Column(nullable = false)
    private String password;

    private String name;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String email, String password, String name, Address address){
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    /*
    아래부터는 구현해야하는 UserDatails의 메서드들, 아직 상세 로직 미구현
     */

    //권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    //사용자의 패스워드 반환
    @Override
    public String getPassword() {
        return password;
    }

    //사용자의 id 반환
    @Override
    public String getUsername() {
        return email;
    }

    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        return true; //true 만료되지 않음
    }

    //계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        return true; //true 잠금되지 않음
    }

    //패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true; //true 만료되지 않음
    }

    //계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        return true; //true 사용 가능
    }
}
