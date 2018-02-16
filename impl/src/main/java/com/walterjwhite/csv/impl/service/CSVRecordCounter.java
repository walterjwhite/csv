package com.walterjwhite.csv.impl.service;

import com.walterjwhite.csv.api.service.reader.CSVReader;
import java.io.IOException;
import java.util.Iterator;

public class CSVRecordCounter {
  public int count(CSVReader csvReader) throws IOException {
    int i = 0;
    final Iterator<String[]> csvIterator = csvReader.iterator();
    while (csvIterator.hasNext()) {
      i++;
      csvIterator.next();
    }

    return (i);
  }
}
