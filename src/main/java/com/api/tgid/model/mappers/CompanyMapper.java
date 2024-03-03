package com.api.tgid.model.mappers;

import com.api.tgid.model.dto.companies.CompanyDto;
import com.api.tgid.model.dto.companies.CompanySighUpDto;
import com.api.tgid.model.dto.companies.UpdateCompanyDto;
import com.api.tgid.model.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface CompanyMapper {

    CompanyMapper INSTASNCE = Mappers.getMapper(CompanyMapper.class);

    @Mapping(target = "geid", expression = "java(UUID.randomUUID())")
    Company signUpCompanyDtoToModel (CompanySighUpDto companySignUpDto);

    Company updateCompanyDtoToModel (UpdateCompanyDto updateCompanyDto);

    CompanyDto companyModelToDto (Company company);
}
