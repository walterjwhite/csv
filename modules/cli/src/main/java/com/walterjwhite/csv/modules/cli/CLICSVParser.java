package com.walterjwhite.csv.modules.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: setup operating mode
// 1. count records in CSV
// 2. validate CSV (count file against actual files)
// 3. replace characters in CSV files
public class CLICSVParser {
  private static final Logger LOGGER = LoggerFactory.getLogger(CLICSVParser.class);

  // example implementation
  public static void main(final String[] arguments) {
    //    GuiceHelper.addModules(new JPACSVModule());
    //    GuiceHelper.setup();
    //    CSVProcessor csvProcessor = GuiceHelper.getInstance(CSVProcessor.class);
    //    for(final String arguments:arguments)
    //      csvProcessor.process(new File(argument));
  }
}
