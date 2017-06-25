package com.oran;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * This is an entity, something to be persisted
 */

@Entity
public class RandomNumber {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateTime;
    private String name;
    private String userAgent;
    private double randomNumber;

    protected RandomNumber() {}

    public RandomNumber(LocalDateTime dateTime, String name, String userAgent, double randomNumber) {
        this.dateTime = dateTime;
        this.name = name;
        this.userAgent = userAgent;
        this.randomNumber = randomNumber;
    }

    public LocalDateTime getDateTime() { return dateTime; }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getUserAgent() { return userAgent; }

    public double getRandomNumber() { return randomNumber; }

    @Override
    public String toString() {
        return String.format(
                "RandomNumber[id=%d, dateTime='%s', name='%s', userAgent=%s, randomNumber=%s]",
                id, dateTime, name, userAgent, randomNumber);
    }

}
