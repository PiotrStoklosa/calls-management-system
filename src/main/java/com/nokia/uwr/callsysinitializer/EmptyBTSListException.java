package com.nokia.uwr.callsysinitializer;

import com.nokia.uwr.model.BTS;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class EmptyBTSListException extends RuntimeException {
    public EmptyBTSListException(List<BTS> btsList) {
        super("BTS List is Empty: " + btsList);
    }
}
