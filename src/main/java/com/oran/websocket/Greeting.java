package com.oran.websocket;

/**
 * Spring will use the Jackson JSON library to automatically marshal instances of type Greeting into JSON
 */
public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}