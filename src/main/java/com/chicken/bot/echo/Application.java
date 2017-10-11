package com.chicken.bot.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.message.VideoMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class Application {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        return new TextMessage(event.getMessage().getText());
    
    }
    
    @EventMapping
    public Message handleImageMessageEvent(MessageEvent<ImageMessageContent> event) {
    	return new TextMessage("이미지로구나.");
    
    }
    
    @EventMapping
    public Message handleVideoMessageEvent(MessageEvent<VideoMessageContent> event) {
    	return new TextMessage("동영상이로구나.");
    	
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    
    }
}
