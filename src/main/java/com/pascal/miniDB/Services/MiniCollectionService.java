package com.pascal.miniDB.Services;

import com.pascal.miniDB.Entities.MiniCollection;
import com.pascal.miniDB.Entities.Miniature;

public interface MiniCollectionService {

    MiniCollection findMiniCollectionByID(Integer id);

    void addMiniatureToMiniCollection(Miniature miniature, MiniCollection miniCollection);

}
