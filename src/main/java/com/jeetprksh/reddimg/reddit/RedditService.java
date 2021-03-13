package com.jeetprksh.reddimg.reddit;

import com.google.common.collect.Maps;
import com.jeetprksh.reddimg.reddit.http.DownloadImageRequest;
import com.jeetprksh.reddimg.reddit.http.GetSubredditLinksRequest;
import com.jeetprksh.reddimg.reddit.http.model.ImageFile;
import com.jeetprksh.reddimg.reddit.parser.Link;
import com.jeetprksh.reddimg.reddit.parser.RedditListParser;
import com.jeetprksh.reddimg.reddit.parser.Thing;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RedditService {

  private final Logger logger = Logger.getLogger(RedditService.class.getName());

  private final String DEFAULT_CHUNK_SIZE = "20";
  private final String subredditName;

  private RedditService(String subredditName) {
    this.subredditName = subredditName;
  }

  public List<Link> getAllSubredditLinks() throws IOException, ParseException {
    logger.info("Getting all subreddit links on " + this.subredditName);
    GetSubredditLinksRequest request = new GetSubredditLinksRequest(this.subredditName, Maps.newHashMap());
    String response = request.execute();
    List<Link> firstLinks = parseToLinks(response);

    List<Link> allLinks = new ArrayList<>(firstLinks);

    String after = firstLinks.get(firstLinks.size() - 1).getFullName();
    List<Link> loopLinks;
    do {
      loopLinks = getAllSubredditLinks(after);
      allLinks.addAll(loopLinks);
      logger.info("Found " + loopLinks.size() + " links after " + after);
      if (loopLinks.isEmpty())  break;
      after = loopLinks.get(loopLinks.size() - 1).getFullName();
    } while (!(loopLinks.size() < Integer.parseInt(DEFAULT_CHUNK_SIZE)));

    return allLinks;
  }

  public List<Link> getAllSubredditLinks(String after) throws IOException, ParseException {
    logger.info("Getting " + DEFAULT_CHUNK_SIZE + " links after " + after);
    Map<String, String> queryParams = Stream.of(new String[][] {{"after", after}, {"limit", DEFAULT_CHUNK_SIZE}})
            .collect(Collectors.toMap(data -> data[0], data -> data[1]));
    GetSubredditLinksRequest request = new GetSubredditLinksRequest(this.subredditName, queryParams);
    String response = request.execute();
    return parseToLinks(response);
  }

  public ImageFile downloadImage(String imgUrl) throws Exception {
    DownloadImageRequest request = new DownloadImageRequest(imgUrl);
    return request.execute();
  }

  private List<Link> parseToLinks(String response) throws ParseException {
    RedditListParser parser = new RedditListParser();
    List<Thing> things = parser.parse((JSONObject) new JSONParser().parse(response));
    return things.stream().map(t -> (Link) t).collect(Collectors.toList());
  }

  public static RedditService create(String subredditName) {
    return new RedditService(subredditName);
  }
}
