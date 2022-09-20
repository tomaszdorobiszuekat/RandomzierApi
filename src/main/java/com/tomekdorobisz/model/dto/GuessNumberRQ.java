package com.tomekdorobisz.model.dto;

public class GuessNumberRQ {

    private Integer sessionID;

    private Integer inputNumber;

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }

    public Integer getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(Integer inputNumber) {
        this.inputNumber = inputNumber;
    }
}
