package com.bridgelabz.indiancensusanalyzer;

public class CensusAnalyserException extends Exception {

    enum ExceptionType {
        CENSUS_FILE_PROBLEM , UNABLE_TO_PARSE , INCORRECT_EXTENSION , INTERNAL_FILE_ISSUES
    }
    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}



