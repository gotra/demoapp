package io.github.grajeev.demoapp;

import io.github.grajeev.demoapp.model.Message;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class MessageController {

    private final ReactiveRedisOperations<String, Message> messageOps;

    MessageController(ReactiveRedisOperations<String, Message> messageOps ) {
        this.messageOps = messageOps;
    }



    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Mono<Boolean> saveMessage(@RequestBody Message message) {
        return messageOps.opsForValue().set(message.getId(),message);

    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public Mono<Message> getMessage (@PathVariable("id") String messageId) {

        return  messageOps.opsForValue().get(messageId);

    }

}
