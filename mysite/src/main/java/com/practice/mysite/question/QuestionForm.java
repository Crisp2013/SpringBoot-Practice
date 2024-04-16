package com.practice.mysite.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

//입력값을 검증하기 위한 폼
//왜 Validation이 작동안하는지 모르겠는데 일단 패스...
@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="제목은 필수 항목입니다.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message="네영은 필수 항목입니다.")
    private String content;
    
}
