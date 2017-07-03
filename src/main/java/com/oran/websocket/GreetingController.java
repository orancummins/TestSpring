package com.oran.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    /**
     * The @MessageMapping annotation ensures that if a message is sent to destination "/hello", then the greeting()
     * method is called. The payload of the message is bound to a HelloMessage object which is passed into greeting().
     * @param message - simple message
     * @return - simple greeting
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings") // message sent to anyone subscribing to /topic/greetings
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

}