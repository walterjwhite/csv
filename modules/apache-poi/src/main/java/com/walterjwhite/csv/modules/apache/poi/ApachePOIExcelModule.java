package com.walterjwhite.csv.modules.apache.poi;

import com.google.inject.AbstractModule;
import com.walterjwhite.csv.impl.CSVModule;

public class ApachePOIExcelModule extends AbstractModule {
  @Override
  protected void configure() {
    //    bind(ExcelReaderProducer.class).to(ApachePOICSVReaderProducer.class);
    //    bind(ExcelWriterProducer.class).to(ApacheCommonsCSVWriterProducer.class);

    install(new CSVModule());
  }
}
