package com.walterjwhite.csv.plugins.index;

import com.google.inject.AbstractModule;
import com.walterjwhite.csv.plugins.index.service.CSVIndexNameService;
import com.walterjwhite.csv.plugins.index.service.CSVSerializerService;
import com.walterjwhite.index.api.service.IndexNameService;
import com.walterjwhite.serialization.api.service.JSONSerializationService;

public class CSVIndexingModule extends AbstractModule {
  @Override
  protected void configure() {
    //    bind(IndexingRecordReader.class);
    // using Java 8 lambda instead to do the plumbing
    //    bind(IndexBridgeService.class).to(CSVIndexBridgeService.class);
    bind(IndexNameService.class).to(CSVIndexNameService.class);

    bind(JSONSerializationService.class).to(CSVSerializerService.class);
  }
}
