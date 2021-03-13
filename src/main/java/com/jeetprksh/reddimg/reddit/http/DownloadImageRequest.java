package com.jeetprksh.reddimg.reddit.http;

import com.jeetprksh.reddimg.reddit.http.model.ImageFile;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;

public class DownloadImageRequest extends RedditRequest {

  private final String imageUrl;

  public DownloadImageRequest(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public ImageFile execute() throws Exception {
    HttpGet get = new HttpGet(this.imageUrl);
    CloseableHttpResponse response = (CloseableHttpResponse) client.execute(get);
    String contentType = response.getHeader("content-type").getValue();
    String fileExtension = contentType.split("/")[1];
    return new ImageFile(fileExtension, response.getEntity().getContent());
  }
}
