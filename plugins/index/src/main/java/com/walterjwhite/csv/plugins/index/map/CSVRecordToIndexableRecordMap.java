package com.walterjwhite.csv.plugins.index.map;

import com.walterjwhite.csv.api.model.CSVRecord;
import com.walterjwhite.csv.plugins.index.model.CSVIndexRecord;
import com.walterjwhite.datastore.criteria.EntityTypeRepository;
import com.walterjwhite.index.api.model.index.IndexableRecord;
import com.walterjwhite.index.api.service.IndexRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.inject.Provider;

/** Maps a CSVRecord to an IndexableRecord (which can be ingested by the indexService) */
public class CSVRecordToIndexableRecordMap implements Function<CSVRecord, IndexableRecord> {
  protected final Provider<IndexRepository> indexRepositoryProvider;
  protected final Provider<EntityTypeRepository> entityTypeRepositoryProvider;

  public CSVRecordToIndexableRecordMap(
      Provider<IndexRepository> indexRepositoryProvider,
      Provider<EntityTypeRepository> entityTypeRepositoryProvider) {
    this.indexRepositoryProvider = indexRepositoryProvider;
    this.entityTypeRepositoryProvider = entityTypeRepositoryProvider;
  }

  @Override
  public IndexableRecord apply(CSVRecord csvRecordData) {
    return new IndexableRecord(
        indexRepositoryProvider.get().getDefault(),
        entityTypeRepositoryProvider.get().findByName(csvRecordData.getCsvFilename()),
        Long.toString(csvRecordData.getRowNumber()),
        createCSVIndexRecord(csvRecordData));
  }

  public static CSVIndexRecord createCSVIndexRecord(
      /*final String csvFilename, final String[] columnNames, final String[] csvRecordData*/
      CSVRecord csvRecord) {
    return (new CSVIndexRecord(
        csvRecord.getCsvFilename(), getMap(csvRecord.getColumNames(), csvRecord.getData())));
  }

  // TODO: convert to a JSON response (use the CSV headers)
  protected static Map<String, String> getMap(final String[] columnNames, String[] csvRecordData) {
    final Map<String, String> map = new HashMap<>();
    int i = 0;
    for (final String columnName : columnNames) {
      map.put(columnName, csvRecordData[i++]);
    }

    return (map);
  }
}
