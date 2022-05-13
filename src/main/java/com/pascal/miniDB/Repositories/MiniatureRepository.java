package com.pascal.miniDB.Repositories;

import com.pascal.miniDB.Entities.Miniature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiniatureRepository extends CrudRepository<Miniature, Integer> {

    List<Miniature> findMiniaturesByNameContainingIgnoreCase(String name);


}
