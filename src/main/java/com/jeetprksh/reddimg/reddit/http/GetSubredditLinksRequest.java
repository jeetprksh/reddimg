package com.jeetprksh.reddimg.reddit.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;

import java.io.IOException;
import java.util.Map;

public class GetSubredditLinksRequest extends RedditRequest {

  private final String subredditName;
  private final QueryParamFormatter formatter;

  public GetSubredditLinksRequest(String subredditName, Map<String, String> queryParams) {
    this.subredditName = subredditName;
    this.formatter = new QueryParamFormatter(queryParams);
  }

  public String execute() throws IOException {
    String url = BASE_PATH + "r/" + subredditName + ".json" + formatter.format();
    HttpGet get = new HttpGet(url);
    return client.execute(get, this.responseHandler);
  }

}
