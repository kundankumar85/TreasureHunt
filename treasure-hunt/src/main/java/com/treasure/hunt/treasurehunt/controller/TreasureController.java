package com.treasure.hunt.treasurehunt.controller;

import com.treasure.hunt.treasurehunt.dto.Cell;
import com.treasure.hunt.treasurehunt.dto.TreasureMatrix;
import com.treasure.hunt.treasurehunt.service.TreasureHuntService;
import com.treasure.hunt.treasurehunt.validator.impl.TreasureValidatorImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/treasure")
public class TreasureController {
    private final TreasureHuntService treasureHuntService;
    private final TreasureValidatorImpl treasureValidator;


    @PostMapping
    public ResponseEntity<Object> findTreasure(@RequestBody @Valid TreasureMatrix treasureMatrix){
        log.info("Controller find treasure called.");
        treasureValidator.validate(treasureMatrix);
        Set<Cell> visitedCells = treasureHuntService.findTreasure(treasureMatrix);
        Map<String,Object> response = new HashMap<>();
        response.put("path",visitedCells);
        if(!visitedCells.isEmpty())
            response.put("message","Treasure Found at "+ new LinkedList<>(visitedCells).getLast());
        return ResponseEntity.ok(response);
    }

}
