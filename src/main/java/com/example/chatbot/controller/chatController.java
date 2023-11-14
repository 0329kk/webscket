package com.example.chatbot.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import com.example.chatbot.entity.Greeting;
import com.example.chatbot.entity.Message;

@Controller

public class chatController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting(HtmlUtils.htmlEscape(message.getName())
                + " : "
                + HtmlUtils.htmlEscape(message.getMessage()) );
    }
    
    
    @GetMapping("/")
    public String chatapp() {
    	return "chat";
    }
}
