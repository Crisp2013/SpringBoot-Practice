package com.practice.mysite.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity //엔티티(django의 모델)이라는 표시
@Getter
@Setter //왠만해서 setter메서드를 사용하지 않기를 권장, 메서드를 새로 작성하는게 좋음
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)//중복 금지
    private String username;

    private String password;

    @Column(unique = true)
    private String email;
    
}
