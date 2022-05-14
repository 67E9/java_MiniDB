package com.pascal.miniDB.Controllers;

import com.pascal.miniDB.Entities.Game;
import com.pascal.miniDB.Entities.Miniature;
import com.pascal.miniDB.Services.GameService;
import com.pascal.miniDB.Services.ManufacturerService;
import com.pascal.miniDB.Services.MiniatureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DatabaseController implements CommandLineRunner {

    MiniatureService miniatureService;
    GameService gameService;
    ManufacturerService manufacturerService;

    public DatabaseController(MiniatureService miniatureService, GameService gameService) {
        this.miniatureService = miniatureService;
        this.gameService = gameService;
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


    //LINKING METHODS

    public void addGameToMiniature(Miniature miniature, Game game){
        miniatureService.addGameToMiniature(miniature, game);
    }

        //CommandlinerRunner method for test:
    @Override
    public void run(String... args) throws Exception {

    }
}
