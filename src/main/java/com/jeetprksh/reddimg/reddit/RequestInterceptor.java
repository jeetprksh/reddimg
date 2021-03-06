package com.jeetprksh.reddimg.reddit;

import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.protocol.HttpContext;

import java.io.IOException;

public class RequestInterceptor implements HttpRequestInterceptor {

  @Override
  public void process(HttpRequest request,
          EntityDetails entity, HttpContext context) throws HttpException, IOException {
    String platform = System.getProperty("os.name");
    String appIdVersion = "com.jeetprksh.reddimg:v0.0.1";
    request.setHeader("User-Agent", platform + ":" + appIdVersion + " (by /u/jeetprksh)");
  }

}
