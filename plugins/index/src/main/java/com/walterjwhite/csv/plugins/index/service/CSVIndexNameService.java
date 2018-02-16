package com.walterjwhite.csv.plugins.index.service;

import com.walterjwhite.index.api.service.IndexNameService;
import javax.inject.Singleton;

@Singleton
public class CSVIndexNameService implements IndexNameService<String, Long> {

  @Override
  public String getEntityTypeString(String filename) {
    return filename;
  }

  @Override
  public String getEntityType(String entityTypeString) {
    return entityTypeString;
  }

  @Override
  public Long getEntityId(String indexId) {
    return Long.valueOf(indexId);
  }

  @Override
  public String getIndexId(Long entityId) {
    return Long.toString(entityId);
  }
}
