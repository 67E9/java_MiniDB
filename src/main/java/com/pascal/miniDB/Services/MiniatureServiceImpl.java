package com.pascal.miniDB.Services;

import com.pascal.miniDB.Entities.Faction;
import com.pascal.miniDB.Entities.Game;
import com.pascal.miniDB.Entities.Manufacturer;
import com.pascal.miniDB.Entities.Miniature;
import com.pascal.miniDB.Repositories.MiniatureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Transactional
@Slf4j
@Service
public class MiniatureServiceImpl implements MiniatureService{

    @Autowired
    MiniatureRepository miniatureRepository;

    @Override
    public void addMiniature(Miniature miniature) {
        if (miniature.getId() != null){
            if (miniatureRepository.existsById(miniature.getId())){
                log.info("Save failed. Miniature with ID=" + miniature.getId() + " already exists in DB.");
            } else{
                miniatureRepository.save(miniature);
            }
        } else {
            miniatureRepository.save(miniature);
        }
    }

    @Override
    public Miniature findMiniatureById(Integer id) {
        return miniatureRepository.findById(id).orElse(new Miniature());
    }

    @Override
    public List<Miniature> findAllMiniatures() {
        return StreamSupport.stream(miniatureRepository
                .findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Miniature> findMiniaturesByNameContainingIgnoreCase(String name) {
        return miniatureRepository.findMiniaturesByNameContainingIgnoreCase(name);
    }

    @Override
    public void updateMiniature(Miniature miniature) {
        if (miniatureRepository.existsById(miniature.getId())){
            miniatureRepository.save(miniature);
        } else {
            log.info("Update failed. No DB entry with ID="+miniature.getId()+". ");
        }
    }

    @Override
    public void deleteMiniature(Miniature miniature) {
        miniatureRepository.delete(miniature);
    }

    @Override
    public void addGameToMiniature(Miniature miniature, Game game) {
        miniature.getGames().add(game);
    }

    @Override
    public void addManufacturerToMiniature(Miniature miniature, Manufacturer manufacturer) {
        miniature.setManufacturer(manufacturer);
    }

    @Override
    public void addFactionToMiniature(Miniature miniature, Faction faction) {
        miniature.setFaction(faction);
    }
}
