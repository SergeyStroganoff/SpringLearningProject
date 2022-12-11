package org.example.entities;

public class Dog implements Pet {
    @Override
    public String getVoice() {
        return "Gav Gav";
    }

    protected void init() {
        System.out.println(this.toString());
    }
}
