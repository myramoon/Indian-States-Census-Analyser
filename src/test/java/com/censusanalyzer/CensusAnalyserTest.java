package com.censusanalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv" ;
    private static final String WRONG_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv" ;
    private static final String WRONG_CENSUS_CSV_FILE_EXTENSION = "./src/main/resources/IndiaStateCensusData.ppt" ;
    private static final String WRONG_CENSUS_CSV_DELIMITER = "./src/main/resources/IndiaStateCensusDataWrongDelimiter.csv" ;
    private static final String WRONG_CENSUS_CSV_HEADER = "./src/main/resources/WrongHeaderStateCensusData.csv" ;

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
    public void GivenStateCensusCSVFile_WhenFileExtensionIncorrect_ShouldThrowException()  {
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

    @Test
    public void givenStateCensusCSVFile_WhenHavingWrongDelimiter_ShouldThrowException()  {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            int count = censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_DELIMITER);
            System.out.println(count);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenHavingWrongHeader_ShouldThrowException()  {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            int count = censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_HEADER);
            System.out.println(count);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }
}
