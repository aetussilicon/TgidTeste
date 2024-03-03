package com.api.tgid.services;

import com.api.tgid.model.dto.companies.CompanyDto;
import com.api.tgid.model.dto.companies.CompanySighUpDto;
import com.api.tgid.model.entities.Company;
import com.api.tgid.model.mappers.CompanyMapper;
import com.api.tgid.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UsernameGenerator usernameGenerator;

    public Company signUpCompany(CompanySighUpDto companySighUpDto) {
        companySighUpDto.setUsername(
                usernameGenerator.
                        usernameGenerator(companySighUpDto.getName()));
        companySighUpDto.
                setTaxNumber(taxNumberValidator
                        .cnpjValidator(companySighUpDto.getTaxNumber()));
        return companyRepository.save(companyMapper.signUpCompanyDtoToModel(companySighUpDto));
    }

    }


}
