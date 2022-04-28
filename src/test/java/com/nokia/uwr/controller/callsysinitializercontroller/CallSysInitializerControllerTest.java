package com.nokia.uwr.controller.callsysinitializercontroller;

import com.nokia.uwr.model.BTS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CallSysInitializerControllerTest {

    @Autowired
    private CallSysInitializerController controller;

    @Test
    public void shouldThrowEmptyBTSListExceptionWhileGivenBTSListIsEmpty() {
        // given
        List<BTS> btsList = new ArrayList<>();

        // then
        assertThrows(EmptyBTSListException.class, () -> controller.initialize(btsList));
    }

    @Test
    public void shouldNotThrowExceptionWhileGivenBTSListIsEmpty() {
        List<BTS> btsList = new ArrayList<>(List.of(new BTS("BTS1", 30)));

        assertDoesNotThrow(() -> controller.initialize(btsList));
    }
}