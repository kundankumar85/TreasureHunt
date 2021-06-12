package com.treasure.hunt.treasurehunt.service.impl;

import com.treasure.hunt.treasurehunt.dto.Cell;
import com.treasure.hunt.treasurehunt.dto.TreasureMatrix;
import com.treasure.hunt.treasurehunt.exception.TreasureNotFoundException;
import com.treasure.hunt.treasurehunt.service.TreasureHuntService;
import com.treasure.hunt.treasurehunt.validator.impl.TreasureValidatorImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Service class to find treasure in supplied matrix {@link TreasureMatrix}
 */
@Service
@Slf4j
public class TreasureHuntServiceImpl implements TreasureHuntService {

    /**
     * Method to find treasure in the matrix.
     * @param treasureMatrix : TreasureMatrix
     * @return Set : Set<Cell> or throws {@link TreasureNotFoundException}.
     */
    @Override
    public Set<Cell> findTreasure(TreasureMatrix treasureMatrix) {
        log.info("Service {} method findTreasure called.", TreasureHuntServiceImpl.class);
        LinkedHashSet<Cell> visitedCells = new LinkedHashSet<>();
        Cell value = treasureMatrix.getMatrix().get(0).get(0);
        boolean found = find(treasureMatrix.getMatrix(),visitedCells,value);
        if(Objects.equals(Boolean.FALSE,found)){
            throw new TreasureNotFoundException("Treasure not found");
        }
        log.info("Service {} method findTreasure finished.", TreasureHuntServiceImpl.class);
        return visitedCells;
    }

    /**
     * Recursive method to find treasure in the matrix.
     * @param matrix : Matrix
     * @param visitedCells : Set of visited cells.
     * @param currentCell : Current Cel
     * @return boolean : True = Treasure found /False =Treasure not found.
     */
    private boolean find(List<List<Cell>> matrix, LinkedHashSet<Cell> visitedCells, Cell currentCell) {

        if(visitedCells.contains(currentCell)){

            return Boolean.FALSE;/*Loop is there in matrix */
        }
        int value = currentCell.getValue();

        int nextRow = (value / 10) -1;
        int  nexCol= (value % 10)-1;

        Cell nextCell = matrix.get(nextRow).get(nexCol);

        if(Objects.equals(currentCell,nextCell)){/*Current and Next cell is same so treasure found */
            visitedCells.add(currentCell);
            return Boolean.TRUE;
        }else{
            visitedCells.add(currentCell);
            return find(matrix,visitedCells,nextCell);/*Check next cell in matrix*/
        }
    }
}
