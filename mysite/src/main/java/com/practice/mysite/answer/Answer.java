package com.practice.mysite.answer;

import java.time.LocalDateTime;

import com.practice.mysite.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id; //자바는 자료형 풀네임이었던가. 아니면 이거 객체였나...

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne // 외래키의 관계를 이렇게 표시함!
    private Question question; //외래키
}
