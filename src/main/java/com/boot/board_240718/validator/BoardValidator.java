package com.boot.board_240718.validator;

import com.boot.board_240718.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Slf4j
public class BoardValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {
        log.info("@# validate()");
        Board b = (Board) obj;

        log.info("@# b.getContent => " + b.getContent());
        if(b.getContent().equals("") || b.getContent().isEmpty()) {
            e.rejectValue("content", "key","내용을 입력하세요.");
        }
    }
}
