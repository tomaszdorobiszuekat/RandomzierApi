package com.tomekdorobisz.model.dto;

public class HighestPlayDTO {

    private Integer sessionID;

    private Integer noOfMoves;

    public HighestPlayDTO() {
    }

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }

    public Integer getNoOfMoves() {
        return noOfMoves;
    }

    public void setNoOfMoves(Integer noOfMoves) {
        this.noOfMoves = noOfMoves;
    }

    @Override
    public String toString() {
        return "HighestPlayDTO{" +
                "sessionID=" + sessionID +
                ", noOfMoves=" + noOfMoves +
                '}';
    }
}
