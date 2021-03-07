package com.jeetprksh.reddimg.reddit.http;

import java.util.Map;
import java.util.StringJoiner;

class QueryParamFormatter {

  private final Map<String, String> queryParams;

  QueryParamFormatter(Map<String, String> queryParams) {
    this.queryParams = queryParams;
  }

  public String format() {
    StringJoiner joiner = new StringJoiner("&", "?", "");
    this.queryParams.entrySet().forEach(es -> joiner.add(es.getKey() + "=" + es.getValue()));
    return joiner.toString();
  }
}
