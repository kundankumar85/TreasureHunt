package com.treasure.hunt.treasurehunt.validator.impl;

import com.treasure.hunt.treasurehunt.dto.Cell;
import com.treasure.hunt.treasurehunt.dto.TreasureMatrix;
import com.treasure.hunt.treasurehunt.exception.InvalidTreasureMatrixException;
import com.treasure.hunt.treasurehunt.validator.TreasureValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Class is to validate {@link TreasureMatrix}.
 */
@Component
@Slf4j
public class TreasureValidatorImpl implements TreasureValidator<TreasureMatrix,Boolean> {

    private static final int MATRIX_CAPACITY = 5;

    /**
     * Validate {@link TreasureMatrix} input data.
     * @param source : TreasureMatrix
     * @return Boolean : True or throws exception.
     */
    @Override
    public Boolean validate(TreasureMatrix source) {
        log.info("Validator {} method validate called.",TreasureValidatorImpl.class);
        List<List<Cell>> matrix = source.getMatrix();
        int rowCount = matrix.size();
        int colCount = matrix.get(0).size();
        if(rowCount != MATRIX_CAPACITY || colCount != MATRIX_CAPACITY)
            throw new InvalidTreasureMatrixException("Invalid matrix, Matrix should be 5X5");
        log.info("Validator {} method validate finished.",TreasureValidatorImpl.class);
        return Boolean.TRUE;
    }
}
