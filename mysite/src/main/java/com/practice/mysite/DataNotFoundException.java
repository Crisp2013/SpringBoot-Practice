package com.practice.mysite;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException{
        private static final long serialVersionUID = 1L;
        public DataNotFoundException(String message){
            super(message);//메시지 반환
        }
    
}
