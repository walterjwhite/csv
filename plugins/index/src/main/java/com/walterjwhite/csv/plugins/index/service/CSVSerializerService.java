package com.walterjwhite.csv.plugins.index.service;

import com.walterjwhite.csv.plugins.index.model.CSVIndexRecord;
import com.walterjwhite.serialization.api.service.JSONSerializationService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/** Simply takes a String of key-value pairs and converts them into a JSON object. */
public class CSVSerializerService
    implements JSONSerializationService<CSVIndexRecord, Class<? extends CSVIndexRecord>> {
  @Override
  public byte[] serialize(CSVIndexRecord data) throws Exception {
    final StringBuilder buffer = new StringBuilder();

    buffer.append("{");
    int i = 0;
    for (final String columnName : data.getValues().keySet()) {
      buffer.append("\"" + columnName + "\": \"" + data.getValues().get(columnName) + "\"");

      if (i < data.getValues().size() - 1) buffer.append(",");
      i++;
    }

    buffer.append("}");
    return (buffer.toString().getBytes(Charset.defaultCharset()));
  }

  @Override
  public void serialize(CSVIndexRecord data, OutputStream outputStream) throws Exception {
    outputStream.write(serialize(data));
  }

  @Override
  public CSVIndexRecord deserialize(byte[] data) throws IOException {
    throw (new UnsupportedOperationException("not implemented"));
  }

  @Override
  public CSVIndexRecord deserialize(InputStream inputStream) throws IOException {
    throw (new UnsupportedOperationException("not implemented"));
  }

  @Override
  public CSVIndexRecord deserialize(
      InputStream inputStream, Class<? extends CSVIndexRecord> entityType) throws IOException {
    throw (new UnsupportedOperationException("not implemented"));
  }

  @Override
  public CSVIndexRecord deserialize(byte[] data, Class<? extends CSVIndexRecord> entityType)
      throws IOException {
    throw (new UnsupportedOperationException("not implemented"));
  }
}
