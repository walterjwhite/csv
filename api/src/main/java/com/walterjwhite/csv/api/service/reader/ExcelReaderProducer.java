package com.walterjwhite.csv.api.service.reader;

import java.io.IOException;
import java.io.Reader;

@FunctionalInterface
public interface ExcelReaderProducer {
  ExcelReader get(final String tabName, Reader reader) throws IOException;
}
