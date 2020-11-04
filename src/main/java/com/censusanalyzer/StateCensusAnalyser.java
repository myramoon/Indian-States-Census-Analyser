package com.censusanalyzer;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser {

    public int loadCensusData(String csvFilePath ) throws CensusAnalyserException {
        int recordCounter = 0;
        try {

            InputValidator inputValidator = new InputValidator();
            boolean result = inputValidator.validateFileExtension(csvFilePath);
            if (!result)
                throw new CensusAnalyserException("Please check extension of your file", CensusAnalyserException.ExceptionType.INCORRECT_EXTENSION);

            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndianStateCode> csvToBeanBuilder = new CsvToBeanBuilder<IndianStateCode>(reader);
            csvToBeanBuilder.withType(IndianStateCode.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianStateCode> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianStateCode> stateCodeIterator = csvToBean.iterator();
            Iterable<IndianStateCode> csvIterable = () -> stateCodeIterator;
            recordCounter = (int) StreamSupport.stream(csvIterable.spliterator() , false).count();

        } catch (IOException e) {
            throw new CensusAnalyserException("Please check given path" , CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new CensusAnalyserException("Unable to parse." , CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
        return recordCounter;
    }
}
