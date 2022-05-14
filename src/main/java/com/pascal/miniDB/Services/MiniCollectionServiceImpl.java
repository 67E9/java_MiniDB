package com.pascal.miniDB.Services;

import com.pascal.miniDB.Entities.MiniCollection;
import com.pascal.miniDB.Entities.Miniature;
import com.pascal.miniDB.Repositories.MiniCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniCollectionServiceImpl implements MiniCollectionService {
    @Autowired
    MiniCollectionRepository miniCollectionRepository;

    @Override
    public MiniCollection findMiniCollectionByID(Integer id) {
        return miniCollectionRepository.findById(id).orElse(new MiniCollection());
    }

    @Override
    public void addMiniatureToMiniCollection(Miniature miniature, MiniCollection miniCollection) {
        miniCollection.getMiniatures().add(miniature);
    }
}
