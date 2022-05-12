package com.nokia.uwr.callsysinitializer.assignmentsmap;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AssignmentsMapFactoryImpl implements AssignmentsMapFactory {

    private static final Logger LOGGER = LogManager.getLogger(AssignmentsMapFactoryImpl.class);
    @Override
    public Map<BTS, List<UEMeasurement>> createAssignmentsMap(List<BTS> btsList) {
        LOGGER.info("Create assignments map from btsList: " + btsList);

        return btsList.stream()
                .map(bts -> Map.entry(bts, new ArrayList<UEMeasurement>()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
