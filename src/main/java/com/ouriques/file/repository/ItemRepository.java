package com.ouriques.file.repository;

import com.ouriques.file.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
