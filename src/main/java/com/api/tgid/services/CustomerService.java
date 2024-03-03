package com.api.tgid.services;

import com.api.tgid.model.dto.customer.CustomerDto;
import com.api.tgid.model.dto.customer.CustomerSighUpDto;
import com.api.tgid.model.dto.customer.UpdateCustomerDto;
import com.api.tgid.model.entities.Customer;
import com.api.tgid.model.mappers.CustomerMapper;
import com.api.tgid.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final UsernameGenerator usernameGenerator;
    private final CPFValidatorService cpfValidator;

    private Customer checkCustomerInDatabase(String username) {
        Optional<Customer> checkInDatabase = repository.findCustomerByUsername(username);
        if (checkInDatabase.isPresent()) {
            return checkInDatabase.get();
        } throw new RuntimeException("Cliente não encontrado!");
    }

    public Customer signUpCustomer(CustomerSighUpDto customerSighUpDto) {
        customerSighUpDto.
                setUsername(usernameGenerator.
                        usernameGenerator(customerSighUpDto.getName()));

        customerSighUpDto.
                setTaxNumber(cpfValidator.
                        cpfValidator(customerSighUpDto.getTaxNumber()));

        return repository.save(mapper.signUpCustomerDtoToModel(customerSighUpDto));
    }

    public Customer updateCustomer(String username, UpdateCustomerDto updateCustomerDto) {

        Customer checkedCustomer = checkCustomerInDatabase(username);
        Customer fieldsToUpdate = mapper.updateCustomerDtoToModel(updateCustomerDto);

        for (Field field : Customer.class.getSuperclass().getDeclaredFields()) {
            field.setAccessible(true);

            try {
                if (field.get(fieldsToUpdate) != null && !field.get(fieldsToUpdate).equals(field.get(checkedCustomer))) {
                    field.set(checkedCustomer, field.get(fieldsToUpdate));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Não foi possível atualizar o usuário!" + e.getMessage());
            }
        }

        return checkedCustomer;
    }

    public CustomerDto listCustomer (String username) {
        return mapper.customerModelToDto(checkCustomerInDatabase(username));
    }

}
