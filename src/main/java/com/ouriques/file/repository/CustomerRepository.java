package com.ouriques.file.repository;

import com.ouriques.file.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    long countAllByType(String type);
}
