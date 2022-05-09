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
class CallSysInitializerControllerTest {

    private static final String emptyBtsList = "";
    private static final String oneElementBtsList = """
            {
            "name": "BTS1",
            "signalPower": 30
            }""";
    private static final String postUrl = "/api/initializer";

    @Autowired
    private MockMvc restBTSMockMvc;

    @Test
    public void shouldThrowEmptyBTSListExceptionWhileGivenBTSListIsEmpty() throws Exception {
        restBTSMockMvc
                .perform(post(postUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format("""
                                        [
                                        %s
                                        ]
                                        """,
                                emptyBtsList)
                        ))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldNotThrowExceptionWhileGivenBTSListIsNotEmpty() throws Exception {
        restBTSMockMvc
                .perform(post(postUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format("""
                                        [
                                        %s
                                        ]
                                        """,
                                oneElementBtsList)
                        ))
                .andExpect(status().isOk());
    }
}
