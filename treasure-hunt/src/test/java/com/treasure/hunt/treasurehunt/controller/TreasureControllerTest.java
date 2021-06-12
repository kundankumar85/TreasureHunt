package com.treasure.hunt.treasurehunt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.treasure.hunt.treasurehunt.dto.Cell;
import com.treasure.hunt.treasurehunt.dto.TreasureMatrix;
import com.treasure.hunt.treasurehunt.service.TreasureHuntService;
import com.treasure.hunt.treasurehunt.validator.impl.TreasureValidatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TreasureController.class)
@AutoConfigureJsonTesters
class TreasureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TreasureHuntService treasureHuntService;

    @MockBean
    private TreasureValidatorImpl treasureValidator;

    @Value("classpath:request/treasure_matrix_request.json")
    Resource requstJson;
    @Value("classpath:response/treasure_matrix_response.json")
    Resource responseJson;

    @Autowired
    private JacksonTester<TreasureMatrix> requestJacksonTester;


    @Test
    void findTreasure() throws Exception {
        TreasureMatrix treasureMatrix = getMockRequest();
        Set<Cell> treasureResponse = new LinkedHashSet<>();
        BDDMockito.given(treasureHuntService.findTreasure(eq(treasureMatrix))).willReturn(treasureResponse);
        BDDMockito.given(treasureValidator.validate(eq(treasureMatrix))).willReturn(Boolean.TRUE);
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/treasure")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJacksonTester.write(treasureMatrix).getJson())
        ).andReturn().getResponse();

        then(mockHttpServletResponse.getStatus()).isEqualTo(HttpStatus.OK.value());

    }
    @Test
    void findTreasureBadRequestForMatrixNotValid() throws Exception {
        TreasureMatrix treasureMatrix = getMockRequest();
        treasureMatrix.getMatrix().remove(4);
        Set<Cell> treasureResponse = new LinkedHashSet<>();
        BDDMockito.given(treasureHuntService.findTreasure(eq(treasureMatrix))).willReturn(treasureResponse);
        BDDMockito.given(treasureValidator.validate(any())).willCallRealMethod();
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/treasure")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJacksonTester.write(treasureMatrix).getJson())
        ).andReturn().getResponse();

        then(mockHttpServletResponse.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

    private TreasureMatrix getMockRequest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestMatrix = new String(
                Files.readAllBytes(requstJson.getFile().toPath()));

        return objectMapper.readValue(requestMatrix,TreasureMatrix.class);
    }



}