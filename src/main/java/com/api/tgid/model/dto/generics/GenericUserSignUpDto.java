package com.api.tgid.model.dto.generics;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class GenericUserSignUpDto {

    private UUID geid;
    @NotNull private String name;
    @NotNull private String taxNumber;
    @NotNull @Email private String email;
    @NotNull private String password;
    @NotNull private String phoneNumber;

}
