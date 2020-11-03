package com.censusanalyzer;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadCensusData(String csvFilePath) throws CensusAnalyserException {
        int recordCounter = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndianStateCode> csvToBeanBuilder = new CsvToBeanBuilder<IndianStateCode>(reader);
            csvToBeanBuilder.withType(IndianStateCode.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianStateCode> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianStateCode> stateCodeIterator = csvToBean.iterator();
            while(stateCodeIterator.hasNext()) {
                recordCounter++;
                stateCodeIterator.next();
            }
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        return recordCounter;
    }
}
