package com.api.tgid.model.mappers;

import com.api.tgid.model.dto.customer.CustomerDto;
import com.api.tgid.model.dto.customer.CustomerSighUpDto;
import com.api.tgid.model.dto.customer.UpdateCustomerDto;
import com.api.tgid.model.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "geid", expression = "java(UUID.randomUUID())")
    Customer signUpCustomerDtoToModel (CustomerSighUpDto customerSighUpDto);

    Customer updateCustomerDtoToModel (UpdateCustomerDto updateCustomerDto);

    CustomerDto customerModelToDto (Customer customer);

}
