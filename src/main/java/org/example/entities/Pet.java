package org.example.entities;

import org.springframework.stereotype.Component;

@Component("myPet")
public interface Pet {
    public String getVoice();
}
