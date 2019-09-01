package com.walterjwhite.csv.modules.univocity;

import com.google.inject.AbstractModule;
import com.walterjwhite.csv.api.service.reader.CSVReaderProducer;
import com.walterjwhite.csv.impl.CSVModule;
import com.walterjwhite.csv.modules.univocity.reader.UnivocityCSVReaderProducer;

public class UnivocityCSVModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(CSVReaderProducer.class).to(UnivocityCSVReaderProducer.class);

    install(new CSVModule());
  }
}
