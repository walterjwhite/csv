package com.walterjwhite.csv.plugins.index.map;

import com.walterjwhite.csv.api.model.CSVRecord;
import com.walterjwhite.csv.plugins.index.model.CSVIndexRecord;
import com.walterjwhite.datastore.api.model.entity.EntityReference;
import com.walterjwhite.datastore.api.model.entity.EntityType;
import com.walterjwhite.datastore.api.repository.Repository;
import com.walterjwhite.datastore.query.entityReference.FindEntityReferenceByTypeAndIdQuery;
import com.walterjwhite.datastore.query.entityType.FindEntityTypeByFilenameQuery;
import com.walterjwhite.index.api.model.index.Index;
import com.walterjwhite.index.api.model.index.IndexableRecord;
import com.walterjwhite.index.query.FindIndexByNameQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.inject.Provider;

/** Maps a CSVRecord to an IndexableRecord (which can be ingested by the indexService) */
public class CSVRecordToIndexableRecordMap implements Function<CSVRecord, IndexableRecord> {
  protected final Provider<Repository> repositoryProvider;

  public CSVRecordToIndexableRecordMap(Provider<Repository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public IndexableRecord apply(CSVRecord csvRecordData) {
    Repository repository = repositoryProvider.get();

    Index index =
        repository.query(new FindIndexByNameQuery(FindIndexByNameQuery.DEFAULT_INDEX_NAME) /*,
            PersistenceOption.Create*/);

    EntityType entityType =
        repository.query(new FindEntityTypeByFilenameQuery(csvRecordData.getCsvFilename()) /*,
            PersistenceOption.Create*/);
    EntityReference entityReference =
        repository.query(
            new FindEntityReferenceByTypeAndIdQuery(entityType, csvRecordData.getRowNumber()));

    return new IndexableRecord(index, entityReference, csvRecordData.getData());

    // createCSVIndexRecord(csvRecordData));
  }

  // TODO: shouldn't this be in the bridge?
  // once we know the entity reference, we will go through the bridge to get the underlying data ...
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
