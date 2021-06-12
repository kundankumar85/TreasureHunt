package com.treasure.hunt.treasurehunt.dto;

import lombok.Getter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo class to accept matrix.
 */
@Getter
public final class TreasureMatrix {
    @Valid
    List<@Valid List<@Valid Cell>> matrix = new ArrayList<>();


}
