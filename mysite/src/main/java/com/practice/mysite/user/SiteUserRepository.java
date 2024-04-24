package com.practice.mysite.user;

import org.springframework.data.jpa.repository.JpaRepository;
//Long: id값이므로 잊지 말기
public interface SiteUserRepository extends JpaRepository<SiteUser,Long> {

}
