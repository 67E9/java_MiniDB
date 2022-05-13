package com.pascal.miniDB.Repositories;

import com.pascal.miniDB.Entities.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
}
