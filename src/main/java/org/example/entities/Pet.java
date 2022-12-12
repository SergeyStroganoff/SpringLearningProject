package org.example.entities;

import org.springframework.stereotype.Component;

@Component("myPet")
public interface Pet {
    String getVoice();
}
