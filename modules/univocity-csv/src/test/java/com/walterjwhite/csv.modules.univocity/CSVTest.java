package com.walterjwhite.csv.modules.univocity;

import com.walterjwhite.csv.api.service.reader.CSVReader;
import com.walterjwhite.csv.api.service.reader.CSVReaderProducer;
import com.walterjwhite.google.guice.GuiceHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(CSVTest.class);

  @Before
  public void onBefore() throws Exception {
    GuiceHelper.addModules(new UnivocityCSVModule());
    GuiceHelper.setup();
  }

  @Test
  public void testParseCSV() throws Exception {
    final String name = "pizza.csv";
    final String filename = "src/test/resources/pizza.csv";
    final String[] columns = new String[] {"Order Id", "Description", "Customer", "Price"};

    CSVReaderProducer csvReaderProducer =
        GuiceHelper.getGuiceInjector().getInstance(CSVReaderProducer.class);

    final CSVReader csvReader =
        csvReaderProducer.get(
            new InputStreamReader(new FileInputStream(new File(filename))), columns);

    // Univosity is not implemented at the moment
    /*
        int count = 0;
        final Iterator<String[]> csvIterator = csvReader.iterator();
        while (csvIterator.hasNext()) {
          csvIterator.next();
          count++;
        }

        Assert.equals(count, expectedCount);
    */
  }

  @Test
  public void testCountRecords() throws Exception {
    final String name = "pizza.csv";
    final String filename = "src/test/resources/pizza.csv";
    final String[] columns = new String[] {"Order Id", "Description", "Customer", "Price"};

    CSVReaderProducer csvReaderProducer =
        GuiceHelper.getGuiceInjector().getInstance(CSVReaderProducer.class);

    final CSVReader csvReader =
        csvReaderProducer.get(
            new InputStreamReader(new FileInputStream(new File(filename))), columns);

    /*
        CSVRecordCounter csvRecordCounter =
            GuiceHelper.getGuiceInjector().getInstance(CSVRecordCounter.class);
        Assert.equals(csvRecordCounter.count(csvReader), expectedCount);
    */
  }

  //  @Test
  //  public void testValidateCount() throws Exception {
  //    CSVValidator csvValidator = GuiceHelper.getGuiceInjector().getInstance(CSVValidator.class);
  //    csvValidator.validate("src/test/resources/counts.csv");
  //  }
}
