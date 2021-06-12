package com.treasure.hunt.treasurehunt.validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.treasure.hunt.treasurehunt.dto.TreasureMatrix;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;

public abstract class AbstractTreasureTest {
    private static final String REQUEST_TREASURE_MATRIX_JSON = "request/treasure_matrix_request.json";

    protected TreasureMatrix getMockTreasureMatrix() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource =  new ClassPathResource(REQUEST_TREASURE_MATRIX_JSON);
        String requestMatrix = new String(
                Files.readAllBytes(resource.getFile().toPath()));

        return objectMapper.readValue(requestMatrix,TreasureMatrix.class);
    }
}
