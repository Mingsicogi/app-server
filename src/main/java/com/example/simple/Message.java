package com.example.simple;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id; // pk

    @Column(name = "from_user")
    private String fromUser; // 발신자
    private String text; // 메세지 내용
}
