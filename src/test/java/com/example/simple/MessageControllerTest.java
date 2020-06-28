package com.example.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void send() throws Exception{
        // GIVE
        MessageDTO param = new MessageDTO();
        param.setFromUser("minssogi");
        param.setText("HI~");

        // THEN
        mockMvc.perform(
                post("/message/send")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(param))

        ).andExpect(status().isOk());
    }
}