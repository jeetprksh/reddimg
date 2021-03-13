package com.jeetprksh.reddimg.http;

import com.jeetprksh.reddimg.reddit.RedditService;
import com.jeetprksh.reddimg.reddit.parser.Link;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedditServiceTest {

  private RedditService redditService;

  @BeforeEach
  public void setup() {
    redditService = RedditService.create("pics");
  }

  @Test
  public void getAllSubredditThingsTest() {
    try {
      List<Link> links = redditService.getAllSubredditLinks();
      System.out.println("Overall links found: " + links.size());
    } catch (Exception ex) {
      ex.printStackTrace();
      fail();
    }
  }

}