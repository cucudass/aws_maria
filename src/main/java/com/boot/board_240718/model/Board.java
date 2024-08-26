package com.boot.board_240718.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
//Entity가 다른 Entity와 연관관계가 있는 상태에서 둘 다 @Data 어노테이션이 붙어있을 경우
//Lombok에서 생성하는 equals, hashCode 혹은 toString() 메서드가 서로를 순환 참조하는 문제가 발생
//@Data
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2자이상 30자 이하입니다.")
    private String title;
    @NotNull
    private String content;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
