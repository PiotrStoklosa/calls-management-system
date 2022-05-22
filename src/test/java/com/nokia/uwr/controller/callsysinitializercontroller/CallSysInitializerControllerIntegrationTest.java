package com.nokia.uwr.controller.callsysinitializercontroller;

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
class CallSysInitializerControllerIntegrationTest {

    private static final String EMPTY_BTS_LIST = "";
    private static final String ONE_ELEMENT_BTS_LIST = """
            {
            "name": "BTS1",
            "signalPower": 30
            }""";
    private static final String POST_URL = "/api/initializer";

    @Autowired
    private MockMvc restBTSMockMvc;

    @Test
    public void shouldThrowEmptyBTSListExceptionWhileGivenBTSListIsEmpty() throws Exception {
        restBTSMockMvc
                .perform(post(POST_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format("""
                                        [
                                        %s
                                        ]
                                        """,
                                EMPTY_BTS_LIST)
                        ))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldNotThrowExceptionWhileGivenBTSListIsNotEmpty() throws Exception {
        restBTSMockMvc
                .perform(post(POST_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format("""
                                        [
                                        %s
                                        ]
                                        """,
                                ONE_ELEMENT_BTS_LIST)
                        ))
                .andExpect(status().isOk());
    }
}
