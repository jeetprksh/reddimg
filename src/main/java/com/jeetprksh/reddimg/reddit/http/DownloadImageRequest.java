package com.jeetprksh.reddimg.reddit.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;

import java.io.IOException;
import java.io.InputStream;

public class DownloadImageRequest extends RedditRequest {

  private final String imageUrl;

  public DownloadImageRequest(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public InputStream execute() throws IOException {
    HttpGet get = new HttpGet(this.imageUrl);
    CloseableHttpResponse response = (CloseableHttpResponse) client.execute(get);
    return response.getEntity().getContent();
  }
}
