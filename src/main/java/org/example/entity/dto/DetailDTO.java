package org.example.entity.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.validation.CheckEmail;

@NoArgsConstructor
@Getter
@Setter
public class DetailDTO {
    @NotNull
    private String city;
    @Size(min = 12, max = 12, message = "Phone must be 12 symbols")
    @Pattern(regexp = "^\\+7\\d{3,14}$", message = "it must be mobile phone number format")
    private String phone;
    @NotEmpty(message = "email cann tot be empty") // here we can use spaces
    @NotBlank(message = "email can't be empty or space symbols")
    @CheckEmail(value = "mail.ru",message = "email must be mail.ru")
    private String email;
}
