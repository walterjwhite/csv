package com.walterjwhite.csv.plugins.index.map;

import com.walterjwhite.csv.api.model.CSVRecord;
import com.walterjwhite.csv.api.service.reader.CSVReader;
import com.walterjwhite.index.api.model.index.IndexableRecord;
import java.util.Iterator;
import java.util.function.Function;

/** Maps a CSVRecord to an IndexableRecord (which can be ingested by the indexService) */
public class IndexRecordToCSVIndexRecordMap implements Function<IndexableRecord, CSVRecord> {
  protected final CSVReader csvReader;

  public IndexRecordToCSVIndexRecordMap(CSVReader csvReader) {
    this.csvReader = csvReader;
  }

  @Override
  public CSVRecord apply(IndexableRecord indexableRecord) {
    final long index = Long.valueOf(indexableRecord.getEntityReference().getEntityId());

    final Iterator<String[]> csvIterator = csvReader.iterator();
    String[] data = null;
    int i = 0;
    while (csvIterator.hasNext() && i < index) {
      data = csvIterator.next();
      i++;
    }

    if (i != index) throw new RuntimeException("Record not found:" + index);

    return new CSVRecord(
        indexableRecord.getEntityReference().getEntityType().getName(),
        csvReader.getHeaders(),
        (int) index,
        data);
  }
}
