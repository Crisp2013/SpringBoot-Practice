package com.practice.mysite.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message="네영은 필수 항목입니다.")
    private String content;
    
}
