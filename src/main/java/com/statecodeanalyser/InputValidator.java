package com.statecodeanalyser;

public class InputValidator  {
    private static final String REGEX_EXTENSION = ".*.csv$";
    IPattern iPattern;
    public InputValidator() {
        iPattern = ((input, pattern) -> input.matches(pattern));
    }
    public boolean validateFileExtension(String path) throws StateCodeAnalyserException {
        return iPattern.patternMatcher(path , REGEX_EXTENSION);
    }

}

