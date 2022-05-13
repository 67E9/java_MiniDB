package com.pascal.miniDB.Services;

import com.pascal.miniDB.Entities.Game;
import com.pascal.miniDB.Repositories.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Override
    public void addGame(Game game) {
        if (game.getId() != null){
            if (gameRepository.existsById(game.getId())){
                log.info("Save failed. Game with ID=" + game.getId() + " already exists in DB.");
            } else{
                gameRepository.save(game);
            }
        } else {
            gameRepository.save(game);
        }
    }
}
