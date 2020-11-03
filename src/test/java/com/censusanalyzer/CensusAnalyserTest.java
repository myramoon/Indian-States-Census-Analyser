package com.censusanalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class CensusAnalyserTest {

    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv" ;
    private static final String WRONG_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv" ;

    @Test
    public void givenStateCensusCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int count = censusAnalyser.loadCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, count);
        }catch (CensusAnalyserException e) {
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenPathIsIncorrect_ShouldThrowCustomException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM , e.type);
        }
    }

}
