package io.github.grajeev.demoapp;

import io.github.grajeev.demoapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
public class DemoappApplication {

    @Autowired
    MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoappApplication.class, args);
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Message saveMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return message;

    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public Message getMessage (@PathVariable("id") Long messageId) {

        Optional<Message> message = messageRepository.findById(messageId);

        return message.get();

    }


}
