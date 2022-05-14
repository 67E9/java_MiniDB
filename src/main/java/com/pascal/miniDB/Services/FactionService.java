package com.pascal.miniDB.Services;

import com.pascal.miniDB.Entities.Faction;
import com.pascal.miniDB.Entities.Game;

public interface FactionService {

    Faction findFactionById(Integer id);

    void addGameToFaction(Faction faction, Game game);
}
