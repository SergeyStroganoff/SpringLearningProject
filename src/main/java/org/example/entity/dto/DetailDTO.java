package org.example.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailDTO implements Serializable {
    private String city;
   // @Size(min = 12, max = 12, message = "Phone must be 12 symbols")
    private String phoneNumber;
    //@NotEmpty(message = "email cann tot be empty") // here we can use spaces
    //NotBlank(message = "email can't  be empty or space symbols")
    private String email;
}
