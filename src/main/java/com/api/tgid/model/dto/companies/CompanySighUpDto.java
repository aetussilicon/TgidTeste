package com.api.tgid.model.dto.companies;

import com.api.tgid.model.dto.generics.GenericUserSignUpDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanySighUpDto extends GenericUserSignUpDto {

    @NotNull private String businessName;
    @NotNull private int systemFee;
}
