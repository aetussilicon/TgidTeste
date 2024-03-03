package com.api.tgid.services;

import com.api.tgid.model.entities.Company;
import com.api.tgid.model.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.*;

@Service
@RequiredArgsConstructor
public class TransactionalService {

    private final CompanyService companyService;
    private final CustomerService customerService;


    public void withdraw (String companyUsername, String customerUsername, BigDecimal withdrawValue) {
        Company company = companyService.checkCompanyInDatabase(companyUsername);
        Customer customer = customerService.checkCustomerInDatabase(customerUsername);

        BigDecimal systemFee = company.getSystemFee();
        BigDecimal fee = withdrawValue.multiply(systemFee.divide(BigDecimal.valueOf(100)));

        BigDecimal liquidValue = withdrawValue.subtract(fee);


        if (company.getBalance().compareTo(withdrawValue) >= 0) {
            company.setBalance(company.getBalance().subtract(withdrawValue));
            customer.setBalance(customer.getBalance().add(liquidValue));

            System.out.println("Transação concluída");
        }
        System.out.println("Transação não pode ser concluída");
    }

}
