package com.boot.board_240718.controller;

import com.boot.board_240718.model.User;
import com.boot.board_240718.repository.BoardRepository;
import com.boot.board_240718.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardApiController {
/*
    @Autowired
    private BoardRepository boardRepository;

    @Secured("ROLE_ADMIN") //보안 관련 어노테이션
    @DeleteMapping("/boards/{id}")
    public void deleteBoard(@PathVariable Long id) {
        log.info("@# deleteBoard");

        boardRepository.deleteById(id);
    }
*/
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<User> users = null;
        if("query".equals(method)) {
            users = userRepository.findByUsernameQuery(text);
        } else {
            users = userRepository.findAll();
        }

        return users;
    }
}
