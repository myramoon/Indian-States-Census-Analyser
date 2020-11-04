package com.censusanalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv" ;
    private static final String WRONG_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv" ;
    private static final String WRONG_CENSUS_CSV_FILE_EXTENSION = "./src/main/resources/IndiaStateCensusData.ppt" ;

    @Test
    public void givenStateCensusCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            InputValidator inputValidator = new InputValidator();
            boolean result = inputValidator.validateFileExtension(INDIAN_CENSUS_CSV_FILE_PATH);
            int count = censusAnalyser.loadCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, count);
        }catch (CensusAnalyserException e) {
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenPathIsIncorrect_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM , e.type);
        }
    }
    @Test
    public void GivenStateCensusCSVFile_WhenFileExtensionIncorrect_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_FILE_EXTENSION);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_EXTENSION , e.type);
        }
    }
}
