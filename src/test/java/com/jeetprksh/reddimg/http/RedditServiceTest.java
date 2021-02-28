package com.jeetprksh.reddimg.http;

import com.jeetprksh.reddimg.http.parser.Thing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedditServiceTest {

  private RedditService redditService;

  @BeforeEach
  public void setup() {
    redditService = new RedditService();
  }

  @Test
  public void getAllSubredditThingsTest() {
    try {
      List<Thing> things = redditService.getAllSubredditThings("asoiaf");
      things.forEach(thing -> System.out.println(thing.getFullName()));
    } catch (Exception ex) {
      ex.printStackTrace();
      fail();
    }
  }

}