package com.practice.mysite.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.mysite.answer.AnswerForm;
import com.practice.mysite.question.QuestionForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RequestMapping("/question")
@RequiredArgsConstructor //final이 붙은 생성자를 자동으로 만들어줌->questionRepository에 자동으로 모델 주입
@Controller
public class QuestionController {
    
    private final QuestionService questionService;
    
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue ="0") int page){//모델객체는 알아서 생김, 탬플릿에 전달해주는 것, django에서는 context
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging",paging);
        return "question_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }
    
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.createQuestion(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/question/list";
    }
    
}
