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
    private final CNPJValidator taxNumberValidator;

    private Company checkCompanyInDatabase(String username) {
        Optional<Company> checkInDatabase = companyRepository.findCompanyByUsername(username);
        if (checkInDatabase.isPresent()) {
            return checkInDatabase.get();
        } throw new RuntimeException("Empresa não encontrada!");
    }

    public Company signUpCompany(CompanySighUpDto companySighUpDto) {
        companySighUpDto.setUsername(
                usernameGenerator.
                        usernameGenerator(companySighUpDto.getName()));
        companySighUpDto.
                setTaxNumber(taxNumberValidator
                        .cnpjValidator(companySighUpDto.getTaxNumber()));
        return companyRepository.save(companyMapper.signUpCompanyDtoToModel(companySighUpDto));
    }

    public CompanyDto listCompany (String username) {
        return companyMapper.
                companyModelToDto(checkCompanyInDatabase(username));

    }


}
