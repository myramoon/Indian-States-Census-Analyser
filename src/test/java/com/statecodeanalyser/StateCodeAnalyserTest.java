package com.statecodeanalyser;
import org.junit.Assert;
import org.junit.Test;

public class StateCodeAnalyserTest {

    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv" ;

    @Test
    public void givenStateCensusCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            StateCodeAnalyser codeAnalyser = new StateCodeAnalyser();
            int count = codeAnalyser.loadStateCodeData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(37 , count);
        }catch (StateCodeAnalyserException e) {
        }
    }
}

