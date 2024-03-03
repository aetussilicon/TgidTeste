package com.api.tgid.model.dto.companies;

import com.api.tgid.model.dto.generics.GenericUserUpdateDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCompanyDto extends GenericUserUpdateDto {

    private String businessName;
    private int systemFee;

}
