package com.walterjwhite.csv.plugins.index.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/** The "Entity" that gets pushed into the indexing service provider (ElasticSearch) */
public class CSVIndexRecord implements Serializable {
  // CSV filename
  protected String name;
  protected Map<String, String> values = new HashMap<>();

  public CSVIndexRecord(String name, Map<String, String> values) {
    super();
    this.name = name;

    this.values.putAll(values);
  }

  public CSVIndexRecord() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, String> getValues() {
    return values;
  }

  public void setValues(Map<String, String> values) {
    this.values = values;
  }

  @Override
  public String toString() {
    return "CSVIndexRecord{" + "name='" + name + '\'' + ", values=" + values + '}';
  }
}
