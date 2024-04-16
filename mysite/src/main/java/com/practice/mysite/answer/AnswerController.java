package com.practice.mysite.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.mysite.question.Question;
import com.practice.mysite.question.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/answer")
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    
    @PostMapping("/create/{id}")
    public String createAnswer(@Valid AnswerForm answerForm, @PathVariable("id") Integer id, Errors errors){
        if (errors.hasErrors()){
            return "question_form";
        }
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }

}
