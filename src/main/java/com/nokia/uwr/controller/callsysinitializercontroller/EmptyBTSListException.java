package com.nokia.uwr.controller.callsysinitializercontroller;

public class EmptyBTSListException extends RuntimeException {
    public EmptyBTSListException(String errorMessage) {
        super("BTS List is Empty: " + errorMessage);
    }
}
