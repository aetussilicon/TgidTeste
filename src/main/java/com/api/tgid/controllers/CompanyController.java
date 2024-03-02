package com.api.tgid.controllers;

import com.api.tgid.model.dto.companies.CompanySighUpDto;
import com.api.tgid.model.entities.Company;
import com.api.tgid.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

   @PostMapping("signup")
    public ResponseEntity<Company> signUpCompany(@RequestBody @Valid CompanySighUpDto companySighUpDto) {
        return new ResponseEntity<>(companyService.signUpCompany(companySighUpDto), HttpStatus.CREATED);
    }

}
