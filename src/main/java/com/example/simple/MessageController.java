package com.example.simple;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

    @PostMapping(value = "/send")
    public ResponseEntity<Object> send(@RequestBody MessageDTO param) {

        Message dbParam = new Message();
        BeanUtils.copyProperties(param, dbParam);
        Message savedMessage = messageRepository.save(dbParam);

        return ResponseEntity.ok(savedMessage);
    }
}
