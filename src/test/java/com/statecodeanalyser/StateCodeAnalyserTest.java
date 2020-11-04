package com.statecodeanalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StateCodeAnalyserTest {

    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv" ;
    private static final String WRONG_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv" ;

    @Test
    public void givenStateCensusCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            StateCodeAnalyser codeAnalyser = new StateCodeAnalyser();
            int count = codeAnalyser.loadStateCodeData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(37 , count);
        }catch (StateCodeAnalyserException e) {
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenPathIsIncorrect_ShouldThrowException() {
        try {
            StateCodeAnalyser censusAnalyser = new StateCodeAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCodeAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_CENSUS_CSV_FILE_PATH);
        } catch (StateCodeAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCodeAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM , e.type);
        }
    }

}

