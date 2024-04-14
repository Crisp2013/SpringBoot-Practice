package com.practice.mysite.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.mysite.DataNotFoundException;

import lombok.RequiredArgsConstructor;

//Entity(DB 모델)->Repository(인터페이스)->Service(엔티티->DTO)->Controller(화면 출력)

//레포지토리에서 데이터 처리를 해서 컨트롤러로 넘겨주는 클래스
//취약점 공격? 같은것을 막기 위해 DTO객체를 서로 변환하는 곳
//엔티티->DTO로 변환하는 곳
@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }
    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()){
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }


    }
    
}
