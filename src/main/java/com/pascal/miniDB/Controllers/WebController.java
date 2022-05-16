package com.pascal.miniDB.Controllers;

import com.pascal.miniDB.Entities.Miniature;
import com.pascal.miniDB.Services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/miniDB/api")
public class WebController {

    MiniatureService miniatureService;
    GameService gameService;
    ManufacturerService manufacturerService;
    MiniCollectionService miniCollectionService;
    FactionService factionService;

    public WebController(MiniatureService miniatureService, GameService gameService, ManufacturerService manufacturerService, MiniCollectionService miniCollectionService, FactionService factionService) {
        this.miniatureService = miniatureService;
        this.gameService = gameService;
        this.manufacturerService = manufacturerService;
        this.miniCollectionService = miniCollectionService;
        this.factionService = factionService;
    }

    //Miniature Methods

    @GetMapping("/miniature")
    public ResponseEntity<List<Miniature>> getAllMiniatures(){
        return new ResponseEntity<>(miniatureService.findAllMiniatures(), HttpStatus.OK);
    }

    @PostMapping("/miniature")
    public ResponseEntity<Void> postMiniature(@RequestBody Miniature newMini){
        try {
            miniatureService.addMiniature(newMini);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
