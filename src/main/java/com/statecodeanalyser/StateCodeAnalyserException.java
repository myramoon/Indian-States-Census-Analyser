package com.statecodeanalyser;

public class StateCodeAnalyserException extends Exception {
    enum ExceptionType {
        CENSUS_FILE_PROBLEM , UNABLE_TO_PARSE , INCORRECT_EXTENSION , INTERNAL_FILE_ISSUES
    }
    ExceptionType type;

    public StateCodeAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
