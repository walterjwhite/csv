package com.walterjwhite.csv.modules.apache;

import com.google.inject.AbstractModule;
import com.walterjwhite.csv.api.service.reader.CSVReaderProducer;
import com.walterjwhite.csv.api.service.writer.CSVWriterProducer;
import com.walterjwhite.csv.impl.CSVModule;
import com.walterjwhite.csv.modules.apache.reader.ApacheCommonsCSVReaderProducer;
import com.walterjwhite.csv.modules.apache.writer.ApacheCommonsCSVWriterProducer;

public class ApacheCommonsCSVModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(CSVReaderProducer.class).to(ApacheCommonsCSVReaderProducer.class);
    bind(CSVWriterProducer.class).to(ApacheCommonsCSVWriterProducer.class);

    install(new CSVModule());
  }
}
