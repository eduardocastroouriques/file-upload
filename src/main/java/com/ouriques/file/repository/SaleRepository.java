package com.ouriques.file.repository;

import com.ouriques.file.model.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Long> {
    long countAllByType(String type);
}
