package com.censusanalyzer;

public class CensusAnalyserException extends Exception {

    enum ExceptionType {
        CENSUS_FILE_PROBLEM , UNABLE_TO_PARSE , INCORRECT_EXTENSION , DELIMITER_ERROR
    }
    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}


