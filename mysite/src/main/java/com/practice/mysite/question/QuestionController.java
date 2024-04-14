package com.practice.mysite.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final이 붙은 생성자를 자동으로 만들어줌->questionRepository에 자동으로 모델 주입
@Controller
public class QuestionController {
    
    private final QuestionService questionService;
    
    @GetMapping("/question/list")
    public String list(Model model){//모델객체는 알아서 생김, 탬플릿에 전달해주는 것, django에서는 context
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }
    
}
