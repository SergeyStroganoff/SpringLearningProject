package org.example.entities;

import org.springframework.stereotype.Component;

@Component("myDog")
public class Dog implements Pet {
    @Override
    public String getVoice() {
        return "Gav Gav";
    }

    public void init() {
        System.out.println(this.toString());
    }
}
