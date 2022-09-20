package com.tomekdorobisz.model.dto;

public class GuessNumberRS {

    private boolean isResultCorrect;

    private Integer inputNumber;

    private Integer randomNumber;

    private String result;

    public Boolean getResultCorrect() {
        return isResultCorrect;
    }

    public void setResultCorrect(Boolean resultCorrect) {
        isResultCorrect = resultCorrect;
    }

    public Integer getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(Integer inputNumber) {
        this.inputNumber = inputNumber;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
