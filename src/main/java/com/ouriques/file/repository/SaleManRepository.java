package com.ouriques.file.repository;

import com.ouriques.file.model.SaleMan;
import org.springframework.data.repository.CrudRepository;

public interface SaleManRepository extends CrudRepository<SaleMan, Long> {
    long countAllByType(String type);
}
