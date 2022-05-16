package com.pascal.miniDB.Controllers;

import com.pascal.miniDB.Entities.Faction;
import com.pascal.miniDB.Entities.Game;
import com.pascal.miniDB.Entities.Manufacturer;
import com.pascal.miniDB.Entities.Miniature;
import com.pascal.miniDB.Services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
public class DatabaseController implements CommandLineRunner {

    MiniatureService miniatureService;
    GameService gameService;
    ManufacturerService manufacturerService;
    MiniCollectionService miniCollectionService;
    FactionService factionService;

    public DatabaseController(MiniatureService miniatureService, GameService gameService, ManufacturerService manufacturerService, MiniCollectionService miniCollectionService, FactionService factionService) {
        this.miniatureService = miniatureService;
        this.gameService = gameService;
        this.manufacturerService = manufacturerService;
        this.miniCollectionService = miniCollectionService;
        this.factionService = factionService;
    }

    //Miniature CRUD Methods

    //CREATE
    public void addMiniature(Miniature miniature) {
        miniatureService.addMiniature(miniature);
    }

    //READ
    public Miniature findMiniatureById(Integer id){
        return miniatureService.findMiniatureById(id);
    }

    public List<Miniature> findMiniaturesByNameContainingIgnoreCase(String name) {
        return miniatureService.findMiniaturesByNameContainingIgnoreCase(name);
    }


    //UPDATE
    public void updateMiniature(Miniature miniature){
        miniatureService.updateMiniature(miniature);
    }

    //DELETE
    public void deleteMiniature(Miniature miniature) {
        miniatureService.deleteMiniature(miniature);
    }

    //Game CRUD Methods

    //CREATE
    public void addGame(Game game) {
        gameService.addGame(game);
    }

    //READ
    public Game findGameById(Integer id){
        return gameService.findGameById(id);
    }

    //Manufacturer GRUD methods

    //READ

    public Manufacturer findManufacturerByID(Integer id){
        return manufacturerService.findManufacturerById(id);
    }

    //LINKING METHODS

    public void addGameToMiniature(Miniature miniature, Game game){
        miniatureService.addGameToMiniature(miniature, game);
    }

    public void addManufacturerToMiniature(Miniature miniature, Manufacturer manufacturer) {
        miniatureService.addManufacturerToMiniature(miniature,manufacturer);
    }

    public void addFactionToMiniature (Miniature miniature, Faction faction){
        miniatureService.addFactionToMiniature(miniature,faction);
    }

    public void addGameToFaction(Faction faction, Game game){
        factionService.addGameToFaction(faction, game);
    }

    //CommandlinerRunner method for test:
    @Override
    public void run(String... args) throws Exception {
    var saga = findGameById(1);
    var infinity = findGameById(2);
    var grippingBeast = findManufacturerByID(1);
    var corvusBelli = findManufacturerByID(2);
    var berserker = findMiniatureById(1);
    var alguacil = findMiniatureById(2);

    addGameToMiniature(berserker,saga);
    addGameToMiniature(alguacil,infinity);
    addManufacturerToMiniature(berserker, grippingBeast);
    addManufacturerToMiniature(alguacil, corvusBelli);

    }
}
