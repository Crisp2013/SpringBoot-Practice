package com.practice.mysite.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final SiteUserService userService;

    @GetMapping("/signup")
    public String getMethodName(UserCreateForm userCreateForm) {
        return "signup_form";
    }
    @PostMapping("/signup")
    public String getMethodName(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "signup_form";
        }
        //비밀번호 동일한지 확인하는 방법
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            bindingResult.rejectValue("password2", "passwordIncorrect","2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        try{
            this.userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed","이미등록된 사용자입니다.");
            return "signup_form";
        } catch(Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed",e.getMessage());
            return "signup_form";
        }
        return "redirect:/";
    }
}
