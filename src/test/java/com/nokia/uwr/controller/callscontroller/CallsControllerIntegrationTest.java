package com.nokia.uwr.controller.callscontroller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CallsControllerIntegrationTest {

    private static final String INITIALIZE_URL = "/api/initializer";
    private static final String START_CALL_URL = "/api/calls/start";

    private static final String BTS_LIST = """
            [   {
                    "name": "BTS1",
                    "signalPower": 60
                },
                {
                    "name": "BTS2",
                    "signalPower": 70
                },
                {
                    "name": "BTS3",
                    "signalPower": 80
                },
                {
                    "name": "BTS4",
                    "signalPower": 90
                }
            ]""";

    private static final String MEASUREMENTS = "{\"name\":\"UE3\"," +
            "\"signals\":{\"BTS1\":1," +
            "\"BTS2\":6," +
            "\"BTS3\":7," +
            "\"BTS4\":3}}";

    @Autowired
    private MockMvc restBTSMockMvc;


    @Test
    @DisplayName("Call startCall method which should not throw exception while given measurements aren't empty" +
            "and CallSys is initialized")
    public void test1() throws Exception {
        restBTSMockMvc
                .perform(post(INITIALIZE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(BTS_LIST))
                .andExpect(status().isOk());

        restBTSMockMvc
                .perform(post(START_CALL_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MEASUREMENTS))
                .andExpect(status().isOk());
    }

}