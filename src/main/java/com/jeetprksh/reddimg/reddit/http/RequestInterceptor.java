package com.jeetprksh.reddimg.reddit.http;

import com.jeetprksh.reddimg.config.ReddimgConfig;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.protocol.HttpContext;

import java.util.logging.Logger;

public class RequestInterceptor implements HttpRequestInterceptor {

  private final Logger logger = Logger.getLogger(RequestInterceptor.class.getName());

  @Override
  public void process(HttpRequest request,
          EntityDetails entity, HttpContext context) {
    ReddimgConfig config = ReddimgConfig.getConfig();
    String platform = System.getProperty("os.name");
    String appIdVersion = config.getAppId() + ":" + config.getVersion();
    logger.info("User Agent: " + platform + ":" + appIdVersion + " (by /u/" + config.getUserName() + ")");
    request.setHeader("User-Agent", platform + ":" + appIdVersion + " (by /u/" + config.getUserName() + ")");
  }

}
