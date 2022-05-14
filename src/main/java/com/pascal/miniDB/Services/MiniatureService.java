package com.pascal.miniDB.Services;

import com.pascal.miniDB.Entities.Faction;
import com.pascal.miniDB.Entities.Game;
import com.pascal.miniDB.Entities.Manufacturer;
import com.pascal.miniDB.Entities.Miniature;

import java.util.List;

public interface MiniatureService {

    void addMiniature(Miniature miniature);

    Miniature findMiniatureById(Integer id);

    List<Miniature> findMiniaturesByNameContainingIgnoreCase(String name);

    void updateMiniature(Miniature miniature);

    void deleteMiniature(Miniature miniature);

    void addGameToMiniature (Miniature miniature, Game game);

    void addManufacturerToMiniature (Miniature miniature, Manufacturer manufacturer);

    void addFactionToMiniature (Miniature miniature, Faction faction);
}
