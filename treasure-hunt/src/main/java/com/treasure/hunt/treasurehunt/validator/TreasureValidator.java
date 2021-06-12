package com.treasure.hunt.treasurehunt.validator;
@FunctionalInterface
public interface TreasureValidator<S,T> {

    /**
     * To validate input source (S) .
     * @param source : Source input
     * @return T : Retrun value.
     */
    T validate(S source);
}
