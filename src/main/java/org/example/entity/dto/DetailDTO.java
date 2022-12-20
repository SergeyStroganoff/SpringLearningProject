package org.example.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailDTO implements Serializable {
    @Pattern(regexp = "[A-Z]\\D{1,12}", message = "please use right name of City")
    private String city;
    @Size(min = 12, max = 12, message = "Phone must be 12 symbols")
    private String phoneNumber;
    @NotEmpty(message = "email can tot be empty") // here we can use spaces
    @NotBlank(message = "email can't  be empty or space symbols")
    private String email;
}
