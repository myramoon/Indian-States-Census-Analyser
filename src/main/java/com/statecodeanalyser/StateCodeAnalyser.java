package com.statecodeanalyser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCodeAnalyser {

    public int loadStateCodeData(String csvFilePath ) throws StateCodeAnalyserException {
        int recordCounter = 0;
        try {
            InputValidator inputValidator = new InputValidator();
            boolean result = inputValidator.validateFileExtension(csvFilePath);
            if (!result)
                throw new StateCodeAnalyserException("Please check extension of your file", StateCodeAnalyserException.ExceptionType.INCORRECT_EXTENSION);
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<StateCodeData> csvToBeanBuilder = new CsvToBeanBuilder<StateCodeData>(reader);
            csvToBeanBuilder.withType(StateCodeData.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<StateCodeData> csvToBean = csvToBeanBuilder.build();
            Iterator<StateCodeData> stateCodeIterator = csvToBean.iterator();
            while(stateCodeIterator.hasNext()) {
                recordCounter++;
                stateCodeIterator.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordCounter;
    }
}
