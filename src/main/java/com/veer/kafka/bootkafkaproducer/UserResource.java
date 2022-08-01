package com.veer.kafka.bootkafkaproducer;

import com.veer.kafka.bootkafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class UserResource  {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "mytopic";

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message")String message){
        //kafkaTemplate.send(TOPIC,message);
        return "Published successfully";
    }

    @PostMapping("/publish")
    public String post(@RequestBody User user){
        kafkaTemplate.send(TOPIC,user);
        return "Published Successfully";
    }
}
