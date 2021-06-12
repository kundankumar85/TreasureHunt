package com.treasure.hunt.treasurehunt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cell {

    @Max(value = 4,message = "Row '${validatedValue}' should be less than or equal to  '{value}'")
    @Min(value = 0,message = "Row  '${validatedValue}'should be greater than  or equal to  '{value}'")
    private Integer row;
    @Max(value = 4,message = "Column '${validatedValue}' should be less than or equal to '{value}'")
    @Min(value = 0,message = "Column '${validatedValue}' should be greater than or equal to '{value}'")
    private Integer col;
    @Max(value = 55,message = "Value '${validatedValue}' should be less than or equal to '{value}'")
    @Min(value = 11,message = "Value '${validatedValue}' should be greater than or equal to '{value}'")
    private Integer value;

}


