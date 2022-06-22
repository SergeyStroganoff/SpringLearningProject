package org.example.entities;

//@Component("myDog")
public class Dog implements Pet {
    @Override
    public String getVoice() {
        return "Gav Gav";
    }

    public void init() {
        System.out.println(this.toString());
    }
}
