package com.bridgelabz.indiancensusanalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusDataAnalyserTest {

    private static final String INDIAN_CENSUS_DATA_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv" ;
    private static final String WRONG_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv" ;
    private static final String WRONG_CENSUS_CSV_FILE_EXTENSION = "./src/main/resources/IndiaStateCensusData.ppt" ;
    private static final String WRONG_CENSUS_CSV_DELIMITER = "./src/main/resources/IndiaStateCensusDataWrongDelimiter.csv" ;
    private static final String WRONG_CENSUS_CSV_HEADER = "./src/main/resources/WrongHeaderStateCensusData.csv" ;

    private static final String STATE_CODE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv" ;
    private static final String WRONG_STATE_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv" ;
    private static final String WRONG_STATE_CODE_CSV_FILE_EXTENSION = "./src/main/resources/IndiaStateCode.ppt" ;
    private static final String WRONG_CENSUS_CSV_INTERNAL_FILE_ISSUES = "./src/main/resources/IndiaStateCodeInternalFileIssues.csv" ;

    @Test
    public void givenIndianCensusDataCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            int count = censusAnalyser.loadCensusData(INDIAN_CENSUS_DATA_CSV_FILE_PATH);
            Assert.assertEquals(29, count);
        }catch (CensusAnalyserException e) {
        }
    }

    @Test
    public void givenIndianCensusDataCSVFile_WhenPathIsIncorrect_ShouldThrowException() {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals("Please check your file path" , e.getMessage());
        }
    }

    @Test
    public void givenIndianCensusDataCSVFile_WhenFileExtensionIncorrect_ShouldThrowException()  {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_FILE_EXTENSION);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals("Please check extension of your file" , e.getMessage());
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WhenHavingWrongDelimiter_ShouldThrowException()  {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WhenHavingWrongHeader_ShouldThrowException()  {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_HEADER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            IndianCensusAnalyser codeAnalyser = new IndianCensusAnalyser();
            int count = codeAnalyser.loadStateCodeData(STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37 , count);
        }catch (CensusAnalyserException e) {
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenPathIsIncorrect_ShouldThrowException() {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals("Please check your file path" , e.getMessage());
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenFileExtensionIncorrect_ShouldThrowException()  {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_CSV_FILE_EXTENSION);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals("Please check extension of your file" , e.getMessage());
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenHavingWrongDelimiter_ShouldThrowException()  {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_INTERNAL_FILE_ISSUES);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenHavingWrongHeader_ShouldThrowException() {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_CSV_INTERNAL_FILE_ISSUES);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES, e.type);
        }
    }
}
