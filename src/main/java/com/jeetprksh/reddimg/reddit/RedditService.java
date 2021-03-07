package com.jeetprksh.reddimg.reddit;

import com.google.common.collect.Maps;
import com.jeetprksh.reddimg.reddit.http.DownloadImageRequest;
import com.jeetprksh.reddimg.reddit.http.GetSubredditLinksRequest;
import com.jeetprksh.reddimg.reddit.parser.Link;
import com.jeetprksh.reddimg.reddit.parser.RedditListParser;
import com.jeetprksh.reddimg.reddit.parser.Thing;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class RedditService {

  private final String subredditName;

  private RedditService(String subredditName) {
    this.subredditName = subredditName;
  }

  public List<Link> getAllSubredditLinks() throws IOException, ParseException {
    GetSubredditLinksRequest request = new GetSubredditLinksRequest(this.subredditName, Maps.newHashMap());
    String response = request.execute();
    RedditListParser parser = new RedditListParser();
    List<Thing> things = parser.parse((JSONObject) new JSONParser().parse(response));
    return things.stream().map(t -> (Link) t).collect(Collectors.toList());
  }

  public InputStream downloadImage(String imgUrl) throws IOException {
    DownloadImageRequest request = new DownloadImageRequest(imgUrl);
    return request.execute();
  }

  public static RedditService create(String subredditName) {
    return new RedditService(subredditName);
  }
}
