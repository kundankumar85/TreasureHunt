package com.treasure.hunt.treasurehunt.service;

import com.treasure.hunt.treasurehunt.dto.Cell;
import com.treasure.hunt.treasurehunt.dto.TreasureMatrix;

import java.util.Set;

/**
 * Interface to find treasure in given {@link TreasureMatrix} .
 */
public interface TreasureHuntService {
    Set<Cell> findTreasure(TreasureMatrix treasureMatrix);
}
