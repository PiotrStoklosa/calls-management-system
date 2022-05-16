package com.nokia.uwr.controller.callscontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CallsControllerIntegrationTest {

    private static final String postUrl = "/api/calls/start";

    String measurements = "{\"name\":\"UE3\"," +
            "\"signals\":{\"BTS[name=1, signalPower=1]\":1," +
            "\"BTS[name=2, signalPower=2]\":6," +
            "\"BTS[name=3, signalPower=5]\":7," +
            "\"BTS[name=4, signalPower=7]\":3}}";

    @Autowired
    private MockMvc restBTSMockMvc;

    /*
    @Test
    public void shouldNotThrowExceptionWhileGivenMeasurementsArentEmptyAndCallSysIsInitialized() throws Exception {
        restBTSMockMvc
                .perform(post(postUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(measurements))
                .andExpect(status().isOk());
    }
    */
}