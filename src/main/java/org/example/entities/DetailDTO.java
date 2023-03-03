package org.example.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailDTO implements Serializable {

    private String city;
    private String phoneNumber;
    private String email;
}
