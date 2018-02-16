package com.walterjwhite.csv.api.service.writer;

import java.io.IOException;

public interface ExcelWriter extends AutoCloseable {
  void writeRecord(String[] record) throws IOException;
}
