package com.api.tgid.model.dto.generics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GenericUserDto {

    private String name;
    private String username;
    private String taxNumber;
    private String email;
    private String phoneNumber;
    private float balance;

}
