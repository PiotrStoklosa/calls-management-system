package com.nokia.uwr.controller.newturncontroller;

import com.nokia.uwr.service.newturnhandler.NewTurnHandler;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/turns")
public class NewTurnController {

    private static final Logger LOGGER = LogManager.getLogger(NewTurnController.class);

    private final NewTurnHandler newTurnHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void newTurnSignal(@RequestBody int TurnNumber){
        LOGGER.info("Got a request to start turn number:" + TurnNumber);

        newTurnHandler.setNewTurn(TurnNumber);

        LOGGER.info("New turn started correctly");
    }

}
