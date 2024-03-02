package com.api.tgid.model.dto.companies;

import com.api.tgid.model.dto.generics.GenericUserDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto extends GenericUserDto {

    private String businessName;
    private String systemFee;

}
