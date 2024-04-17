package com.practice.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.practice.mysite.question.Question;
// import com.practice.mysite.question.QuestionRepository;
import com.practice.mysite.question.QuestionService;

//DB에 주입이 안되는데 JUnit이 주입이 되는게 비정상적인 상황인가?
//DB가 2개가 됨-> 왜???? 테스트용 DB가 따로 생성이 되었다.

@SpringBootTest //테스트 클래스 후보
class MysiteApplicationTests {
	//의존성주입, 객체를 알아서 만들어 주입해줌. 순환참조문제때문에 내가 직접 만드는것보단 나음
	//다만 실제 작업에는 생성자를 사용하는 것을 권장
	// @Autowired 
	// private QuestionRepository questionRepository;
	
	@Autowired 
	private QuestionService questionService;

	// void testJpa() {
	// 	Question q1 = new Question();
	// 	q1.setSubject("테스트 제목1");
	// 	q1.setContent("테스트내용!");
	// 	q1.setCreateDate(LocalDateTime.now());
	// 	this.questionRepository.save(q1); //django는 q1.save()인데 여기는 진짜 repository에 집어넣는 다는 얘기
		
	// 	Question q2 = new Question();
	// 	q2.setSubject("테스트 제목2");
	// 	q2.setContent("테스트내용?");
	// 	q2.setCreateDate(LocalDateTime.now());
	// 	this.questionRepository.save(q2); //django는 q1.save()인데 여기는 진짜 repository에 집어넣는 다는 얘기
		
	// }
	// void testJpa2() {
	// 	List<Question> all = this.questionRepository.findAll();
	// 	// assertEquals(2, all.size());
		
	// 	Question q = all.get(0);
	// 	assertEquals("테스트 제목1", q.getSubject());

	// 	//Optional - 존재안할수도 있으므로 -> None을 처리하기 위함
	// 	Optional<Question> oq = this.questionRepository.findById(1);
	// 	if(oq.isPresent()){
	// 		Question q3 = oq.get();
	// 		assertEquals("테스트 제목1", q3.getSubject());
	// 	}
	// 	//db에 여러개 있어서 unique 하지 못하다고 함, 일단 패스
	// 	// Question q4 = this.questionRepository.findBySubject("테스트 제목1");
    //     // assertEquals(1, q4.getId());

	// }
	//DB세션을 유지하는 코드
	//AnswerList()를 이용할때 테스트코드에서는 세션이 끊어져서 오류가 일어남
	// void testJpa3() {
	// 	Optional<Question> oq = this.questionRepository.findById(1);
	// 	assertTrue(oq.isPresent());
	// 	Question q = oq.get(); //이렇게 가져와야함
	// 	q.setSubject("수정된제목");
	// 	this.questionRepository.save(q);//생각해보니 django랑 똑같네?
	// 	this.questionRepository.delete(q);//삭제
	// 	// q.getAnswerList()	
	// }

	// @Transactional//이거쓰면 DB랑 연결이 안끊이는 대신에 저장이 안됨
	@Test
	void testJpa4() {
		System.out.println("d");
		for (int i = 1; i <= 300; i++) {
            String subject = String.format("테s스트 데이터입니다:[%03d]", i);
            String content = "내s용무";
            this.questionService.createQuestion(subject, content);
        }
	}
}
