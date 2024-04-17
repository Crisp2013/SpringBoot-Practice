package com.practice.mysite.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository 상속, Question엔티티로 (제너릭) 생성, Question의 기본키가 Integer
//그런데 이렇게 인터페이스만 만들면 다 된다고? JpaRepsitory에 CRUD가 다 구현되어 있나?



public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Question findBySubject(String subString);//이러면 알아서 만들어주나? 여튼 기본 지원은 아니어서 추가
    Question findBySubjectAndContent(String subject, String content);//https://wikidocs.net/160890
    Page<Question> findAll(Pageable pageable);//페이지 쪼개기?
    //Like: 문자열 포함
}
