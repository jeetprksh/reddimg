package com.jeetprksh.reddimg.reddit;

import com.jeetprksh.reddimg.reddit.parser.Link;
import com.jeetprksh.reddimg.reddit.parser.RedditListParser;
import com.jeetprksh.reddimg.reddit.parser.Thing;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class RedditService {

  private final String BASE_PATH = "https://www.reddit.com/";

  private final HttpClient client;
  private final HttpClientResponseHandler<String> responseHandler;

  private final String subredditName;

  private RedditService(String subredditName) {
    this.subredditName = subredditName;
    this.client = HttpClients.custom().addRequestInterceptorFirst(new RequestInterceptor()).build();
    this.responseHandler = new RedditServiceResponseHandler();
  }

  public List<Link> getAllSubredditLinks() throws IOException, ParseException {
    String url = BASE_PATH + "r/" + subredditName + ".json";
    HttpGet get = new HttpGet(url);
    String response = client.execute(get, this.responseHandler);
    RedditListParser parser = new RedditListParser();
    List<Thing> things = parser.parse((JSONObject) new JSONParser().parse(response));
    return things.stream().map(t -> (Link) t).collect(Collectors.toList());
  }

  public InputStream downloadImage(String imgUrl) throws IOException {
    HttpGet get = new HttpGet(imgUrl);
    CloseableHttpResponse response = (CloseableHttpResponse) client.execute(get);
    return response.getEntity().getContent();
  }

  public static RedditService create(String subredditName) {
    return new RedditService(subredditName);
  }
}
