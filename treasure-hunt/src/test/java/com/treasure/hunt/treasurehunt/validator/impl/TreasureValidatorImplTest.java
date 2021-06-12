package com.treasure.hunt.treasurehunt.validator.impl;

import com.treasure.hunt.treasurehunt.dto.TreasureMatrix;
import com.treasure.hunt.treasurehunt.exception.InvalidTreasureMatrixException;
import com.treasure.hunt.treasurehunt.validator.AbstractTreasureTest;
import com.treasure.hunt.treasurehunt.validator.TreasureValidator;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class TreasureValidatorImplTest extends AbstractTreasureTest {

    private TreasureValidator<TreasureMatrix,Boolean> treasureMatrixBooleanTreasureValidator;

    @BeforeEach
    void setUp() {
        treasureMatrixBooleanTreasureValidator = new TreasureValidatorImpl();
    }

    @Test
    void validate() throws IOException {
        TreasureMatrix treasureMatrix = getMockTreasureMatrix();
        treasureMatrixBooleanTreasureValidator.validate(treasureMatrix);
        BDDAssertions.thenNoException();
    }

    @Test
    void validateForInvalidTreasureMatrixException() throws IOException {
        TreasureMatrix treasureMatrix = getMockTreasureMatrix();
        treasureMatrix.getMatrix().remove(4);
        try {
            treasureMatrixBooleanTreasureValidator.validate(treasureMatrix);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(InvalidTreasureMatrixException.class);
        }

    }


}