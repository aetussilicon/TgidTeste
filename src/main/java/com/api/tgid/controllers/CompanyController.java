package com.api.tgid.controllers;

import com.api.tgid.model.dto.companies.CompanyDto;
import com.api.tgid.model.dto.companies.CompanySighUpDto;
import com.api.tgid.model.dto.companies.UpdateCompanyDto;
import com.api.tgid.model.entities.Company;
import com.api.tgid.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

   @PostMapping("signup")
    public ResponseEntity<Company> signUpCompany(@RequestBody @Valid CompanySighUpDto companySighUpDto) {
        return new ResponseEntity<>(companyService.signUpCompany(companySighUpDto), HttpStatus.CREATED);
    }

    @PatchMapping("update/{username}")
    public ResponseEntity<Company> patchCompany(@PathVariable String username, @RequestBody @Valid UpdateCompanyDto updateCompanyDto) {
       return new ResponseEntity<>(companyService.updateCompany(username, updateCompanyDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("list/{username}")
    public ResponseEntity<CompanyDto> listCompany (@PathVariable String username) {
       return new ResponseEntity<>(companyService.listCompany(username), HttpStatus.OK);
    }

}
