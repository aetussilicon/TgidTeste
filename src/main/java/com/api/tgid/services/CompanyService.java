package com.api.tgid.services;

import com.api.tgid.model.dto.companies.CompanySighUpDto;
import com.api.tgid.model.entities.Company;
import com.api.tgid.model.mappers.CompanyMapper;
import com.api.tgid.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public Company signUpCompany(CompanySighUpDto companySighUpDto) {
        return companyRepository.save(companyMapper.signUpCompanyDtoToModel(companySighUpDto));
    }

}
