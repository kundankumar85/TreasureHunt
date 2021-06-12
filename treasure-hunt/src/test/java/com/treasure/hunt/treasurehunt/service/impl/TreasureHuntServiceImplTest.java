package com.treasure.hunt.treasurehunt.service.impl;

import com.treasure.hunt.treasurehunt.dto.TreasureMatrix;
import com.treasure.hunt.treasurehunt.exception.TreasureNotFoundException;
import com.treasure.hunt.treasurehunt.service.TreasureHuntService;
import com.treasure.hunt.treasurehunt.validator.AbstractTreasureTest;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class TreasureHuntServiceImplTest extends AbstractTreasureTest {


    private TreasureHuntService itemService;

    @BeforeEach
    void setUp() {
        itemService = new TreasureHuntServiceImpl();
    }

    @Test
    void findTreasure() throws IOException {
        TreasureMatrix treasureMatrix = getMockTreasureMatrix();
        itemService.findTreasure(treasureMatrix);
        BDDAssertions.thenNoException();
    }

    @Test
    void findTreasureForInvalidMatrix() throws IOException {
        TreasureMatrix treasureMatrix = getMockTreasureMatrix();
        treasureMatrix.getMatrix().get(0).get(0).setValue(11);
        itemService.findTreasure(treasureMatrix);
        BDDAssertions.thenExceptionOfType(TreasureNotFoundException.class);
    }


}