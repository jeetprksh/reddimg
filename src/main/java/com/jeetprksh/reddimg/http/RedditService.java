package com.jeetprksh.reddimg.http;

import com.jeetprksh.reddimg.http.parser.RedditListParser;
import com.jeetprksh.reddimg.http.parser.Thing;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class RedditService {

  private final String BASE_PATH = "https://www.reddit.com/";

  private final HttpClient client;
  private final HttpClientResponseHandler<String> responseHandler;

  public RedditService() {
    this.client = HttpClients.createDefault();
    this.responseHandler = new RedditServiceResponseHandler();
  }

  public List<Thing> getAllSubredditThings(String subreddit) throws IOException {
    String url = BASE_PATH + "r/" + subreddit + ".json";
    HttpGet get = new HttpGet(url);
    String response = client.execute(get, this.responseHandler);
    RedditListParser parser = new RedditListParser();
    return parser.parse(new JSONObject(response));
  }

}
