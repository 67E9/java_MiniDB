package com.pascal.miniDB.Services;

import com.pascal.miniDB.Entities.Faction;
import com.pascal.miniDB.Entities.Game;
import com.pascal.miniDB.Repositories.FactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class FactionServiceImpl implements FactionService{
    @Autowired
    FactionRepository factionRepository;

    @Override
    public Faction findFactionById(Integer id) {
        return factionRepository.findById(id).orElse(new Faction());
    }

    @Override
    public void addGameToFaction(Faction faction, Game game) {
        faction.setGame(game);
    }
}
