package com.bridgelabz.indiancensusanalyzer;
import com.opencsv.bean.CsvBindByName;

public class IndianCensusData {
    @CsvBindByName(column = "State")
    public String state;
    @CsvBindByName(column = "Population")
    public long population;
    @CsvBindByName(column = "AreaInSqKm")
    public long areaInSqKm;
    @CsvBindByName(column = "DensityPerSqKm")
    public long densityPerSqKm;
}
