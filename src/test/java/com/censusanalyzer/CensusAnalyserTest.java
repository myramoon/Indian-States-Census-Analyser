package com.censusanalyzer;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class CensusAnalyserTest {

    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv" ;
    @Test
    public void givenStateCensusCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int count = censusAnalyser.loadCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, count);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
