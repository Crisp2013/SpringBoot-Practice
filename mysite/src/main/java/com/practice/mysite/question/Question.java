package com.practice.mysite.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.practice.mysite.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity //엔티티(django의 모델)이라는 표시
@Getter
@Setter //왠만해서 setter메서드를 사용하지 않기를 권장, 메서드를 새로 작성하는게 좋음
@Validated
public class Question {
    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY )//고유한 번호 생성(유일함)
    private Integer id;

    @Column(length = 200) //column의 설정, 이건 vchar(200)
    private String subject;

    @Column(columnDefinition = "TEXT") //글자수 제한 불가
    private String content;

    private LocalDateTime createDate; //->DB상에서는 create_date로 자동으로 snake_case로 바뀜
    
    //역참조를 위해서는 내가 써줘야 하나봄
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList; //제너릭으로 배열, django와 다르게 배열이 가능
}
