package com.walterjwhite.csv.api.model;

import java.util.Objects;

public class CSVRecord {
  protected final String csvFilename;
  protected final String[] columNames;
  protected final int rowNumber;
  protected final String[] data;

  public CSVRecord(String csvFilename, String[] columNames, int rowNumber, String[] data) {
    super();
    this.csvFilename = csvFilename;
    this.columNames = columNames;
    this.rowNumber = rowNumber;
    this.data = data;
  }

  public String getCsvFilename() {
    return csvFilename;
  }

  public String[] getColumNames() {
    return columNames;
  }

  public int getRowNumber() {
    return rowNumber;
  }

  public String[] getData() {
    return data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CSVRecord csvRecord = (CSVRecord) o;
    return rowNumber == csvRecord.rowNumber && Objects.equals(csvFilename, csvRecord.csvFilename);
  }

  @Override
  public int hashCode() {
    return Objects.hash(csvFilename, rowNumber);
  }
}
