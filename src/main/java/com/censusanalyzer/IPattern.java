package com.censusanalyzer;

@FunctionalInterface
public interface IPattern {

    boolean patternMatcher(String input , String pattern);
}
