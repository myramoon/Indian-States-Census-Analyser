package com.bridgelabz.indiancensusanalyzer;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IndianCensusAnalyser {

    public static void validateExtension(String csvFilePath) throws CensusAnalyserException {
        InputValidator inputValidator = new InputValidator();
        boolean result = inputValidator.validateFileExtension(csvFilePath);
        if (!result)
            throw new CensusAnalyserException("Please check extension of your file", CensusAnalyserException.ExceptionType.INCORRECT_EXTENSION);
    }

    public int loadCensusData(String csvFilePath ) throws CensusAnalyserException {
        validateExtension(csvFilePath);
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
            Iterator<IndianCensusData> censusDataIterator = this.getCSVFileIterator(reader , IndianCensusData.class);
            Iterable<IndianCensusData> csvIterable = () -> censusDataIterator;
            int recordCounter = this.getCountOfRecords(csvIterable);
            return recordCounter;
        } catch (IOException e) {
            throw new CensusAnalyserException("Please check your file path", CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch (RuntimeException e) {
            throw new CensusAnalyserException("Internal file error.Please check your csv file." , CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES);
        }
    }

    public int loadStateCodeData(String csvFilePath ) throws CensusAnalyserException {
        validateExtension(csvFilePath);
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
            Iterator<StateCodeData> stateCodeIterator = this.getCSVFileIterator(reader , StateCodeData.class);
            Iterable<StateCodeData> csvIterable = () -> stateCodeIterator;
            int recordCounter = this.getCountOfRecords(csvIterable);
            return recordCounter;
        } catch (IOException e) {
            throw new CensusAnalyserException("Please check your file path", CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch (RuntimeException e) {
            throw new CensusAnalyserException("Internal file error.Please check your csv file." , CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES);
        }
    }

    private <E> int getCountOfRecords(Iterable<E> csvIterable) {
        int recordCounter = (int) StreamSupport.stream(csvIterable.spliterator() , false).count();
        return recordCounter;
    }

    private <E> Iterator<E> getCSVFileIterator(Reader reader , Class<E> csvClass) throws CensusAnalyserException {
        try {
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<E> csvToBean = csvToBeanBuilder.build();
            return csvToBean.iterator();
        } catch (IllegalStateException e) {
            throw new CensusAnalyserException("Unable to parse.", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}
