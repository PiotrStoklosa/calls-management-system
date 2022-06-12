package com.nokia.uwr.service.newturnhandler;

import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NewTurnHandlerImpl implements NewTurnHandler {

    private static final Logger LOGGER = LogManager.getLogger(NewTurnHandlerImpl.class);

    private final ConnectionManager connectionManager;

    private int turnNumber;

    @Override
    public void setNewTurn(int number){

        LOGGER.info("Try to set a new turn");

        logMeasurementsForThisTurn();
        turnNumber = number;

        LOGGER.info("New turn set successfully");
    }

    private void logMeasurementsForThisTurn(){

        LOGGER.info("Try to log measurements for turn number " + turnNumber);

        Map<BTS, List<UEMeasurement>> assignments = connectionManager.getAssignments();

        int ueCnt = assignments.keySet()
                .stream()
                .map(assignments::get)
                .map(List::size)
                .reduce(0, Integer::sum);

        int ueSum = assignments.keySet()
                .stream()
                .map(assignments::get)
                .flatMap(List::stream)
                .map(UEMeasurement::measuredSignalPower)
                .reduce(0, Integer::sum);

        LOGGER.info("In turn " + turnNumber + " we have " + ueCnt + " UEs and their summed signal power is " + ueSum);

        LOGGER.info("Logged measurements for turn number  " + turnNumber + " successfully");
    }
}
