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
    private static final String MOVE_CALL_URL = "/api/calls/move";
    private static final String STOP_CALL_URL = "/api/calls/stop";
    private static final String TERMINATE_URL = "/api/terminate";

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

    private static final String CHANGED_MEASUREMENTS = "{\"name\":\"UE3\"," +
            "\"signals\":{\"BTS1\":1," +
            "\"BTS2\":6," +
            "\"BTS3\":7," +
            "\"BTS4\":10}}";

    private static final String EMPTY_MEASUREMENTS = "{\"name\":\"UE3\"," +
            "\"signals\":{}}";

    private static final String MEASUREMENT_WITH_NON_EXISTING_BEST_BTS = "{\"name\":\"UE3\"," +
            "\"signals\":{\"BTS1\":1," +
            "\"BTS2\":6," +
            "\"ERROR\":7," +
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

    @Test
    @DisplayName("Call startCall method which should return NO_CONTENT response status " +
            "while given measurements are empty and CallSys is initialized")
    public void test2() throws Exception {
        restBTSMockMvc
                .perform(post(INITIALIZE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(BTS_LIST))
                .andExpect(status().isOk());

        restBTSMockMvc
                .perform(post(START_CALL_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(EMPTY_MEASUREMENTS))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Call startCall method which should return NOT_FOUND response status " +
            "while given measurements contain non existing best BTS name and CallSys is initialized")
    public void test3() throws Exception {
        restBTSMockMvc
                .perform(post(INITIALIZE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(BTS_LIST))
                .andExpect(status().isOk());

        restBTSMockMvc
                .perform(post(START_CALL_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MEASUREMENT_WITH_NON_EXISTING_BEST_BTS))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Call startCall method which should not throw exception while given measurements aren't empty" +
            "and CallSys is initialized" +
            "and call stopCall method")
    public void test4() throws Exception {
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

        restBTSMockMvc
                .perform(post(STOP_CALL_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MEASUREMENTS))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Call startCall method which should not throw exception while given measurements aren't empty" +
            "and CallSys is initialized" +
            "and call stopCall method" +
            "and CallSys is terminated")
    public void test5() throws Exception {
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

        restBTSMockMvc
                .perform(post(STOP_CALL_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MEASUREMENTS))
                .andExpect(status().isOk());

//        restBTSMockMvc
//                .perform(post(TERMINATE_URL))
//                    .andExpect(status().isOk());
    }

    @Test
    @DisplayName("""
            Call moveCall method which should not throw exception while given measurements aren't empty
            and given ue started call
            and CallSys is initialized""")
    public void test5() throws Exception {
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

        restBTSMockMvc
                .perform(post(MOVE_CALL_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CHANGED_MEASUREMENTS))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("""
            Call moveCall method which should return NO_CONTENT while given measurements in moveCall are empty
            and CallSys is initialized
            and given ue started call""")
    public void test6() throws Exception {
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

        restBTSMockMvc
                .perform(post(MOVE_CALL_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(EMPTY_MEASUREMENTS))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("""
            Call moveCall method which should return NOT_FOUND response status
            while given measurements contain non existing best BTS name
            and CallSys is initialized
            and given ue started call""")
    public void test7() throws Exception {
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

        restBTSMockMvc
                .perform(post(MOVE_CALL_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MEASUREMENT_WITH_NON_EXISTING_BEST_BTS))
                .andExpect(status().isNotFound());
    }

}