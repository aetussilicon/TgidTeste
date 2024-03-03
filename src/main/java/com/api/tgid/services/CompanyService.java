package com.api.tgid.services;

import com.api.tgid.model.dto.companies.CompanyDto;
import com.api.tgid.model.dto.companies.CompanySighUpDto;
import com.api.tgid.model.dto.companies.UpdateCompanyDto;
import com.api.tgid.model.entities.Company;
import com.api.tgid.model.mappers.CompanyMapper;
import com.api.tgid.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UsernameGenerator usernameGenerator;
    private final CNPJValidatorService taxNumberValidator;

    protected Company checkCompanyInDatabase(String username) {
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

    public Company updateCompany(String username, UpdateCompanyDto updateCompanyDto) {
        Company chekedCompany = checkCompanyInDatabase(username);
        Company fieldsToUpdate = companyMapper.updateCompanyDtoToModel(updateCompanyDto);

        for (Field field : Company.class.getSuperclass().getDeclaredFields()) {
            field.setAccessible(true);

            try {
                if (field.get(fieldsToUpdate) != null && !field.get(fieldsToUpdate).equals(field.get(chekedCompany))) {
                    field.set(chekedCompany, field.get(fieldsToUpdate));
                    }
                } catch (IllegalAccessException e) {
                throw new RuntimeException("Não foi possível atualizar a empresa" + e.getMessage());
            }
        }
        return chekedCompany;
    }

    public CompanyDto listCompany (String username) {
        return companyMapper.
                companyModelToDto(checkCompanyInDatabase(username));

    }


}
