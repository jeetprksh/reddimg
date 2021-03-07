package com.jeetprksh.reddimg.reddit.http;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

public abstract class RedditRequest {

  protected final String BASE_PATH = "https://www.reddit.com/";

  protected final HttpClient client;
  protected final HttpClientResponseHandler<String> responseHandler;

  public RedditRequest() {
    this.client = HttpClients.custom().addRequestInterceptorFirst(new RequestInterceptor()).build();
    this.responseHandler = new RedditServiceResponseHandler();
  }

}
