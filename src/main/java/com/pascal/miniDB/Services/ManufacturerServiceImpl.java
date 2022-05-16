package com.pascal.miniDB.Services;

import com.pascal.miniDB.Entities.Manufacturer;
import com.pascal.miniDB.Repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer findManufacturerById(Integer id) {
        return manufacturerRepository.findById(id).orElse(new Manufacturer());
    }


}
