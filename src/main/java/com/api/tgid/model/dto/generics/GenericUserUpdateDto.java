package com.api.tgid.model.dto.generics;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GenericUserUpdateDto {

    private String name;
    @Email private String email;
    private String password;
    private String phoneNumber;
    private float balance;

}
