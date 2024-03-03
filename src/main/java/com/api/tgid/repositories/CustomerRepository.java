package com.api.tgid.repositories;

import com.api.tgid.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findCustomerByUsername(String username);
}
