package com.statecodeanalyser;

@FunctionalInterface
public interface IPattern {
    boolean patternMatcher(String input , String pattern);
}
