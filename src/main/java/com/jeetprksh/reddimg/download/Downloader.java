package com.jeetprksh.reddimg.download;

import com.jeetprksh.reddimg.files.FileStore;
import com.jeetprksh.reddimg.reddit.RedditService;
import com.jeetprksh.reddimg.reddit.parser.Link;
import com.jeetprksh.reddimg.reddit.parser.PostHint;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class Downloader {

  private final int DEFAULT_CHUNK_SIZE = 20;

  private final String subredditName;
  private final RedditService redditService;
  private final FileStore fileStore;

  private Downloader(String subredditName, RedditService redditService, FileStore fileStore) {
    this.subredditName = subredditName;
    this.redditService = redditService;
    this.fileStore = fileStore;
  }

  public void download() throws Exception {
    List<Link> links = redditService.getAllSubredditLinks().stream()
            .filter(link -> PostHint.IMAGE.value().equals(link.getPostHint()))
            .collect(Collectors.toList());

    for (Link link : links) {
      String imgUrl = link.getUrl();
      InputStream inputStream = redditService.downloadImage(imgUrl);
      fileStore.createFile(link.getTitle(), inputStream);
    }
  }

  public static Downloader createFor(String subredditName) {
    RedditService redditService = RedditService.create(subredditName);
    FileStore fileStore = FileStore.create(subredditName);
    return new Downloader(subredditName, redditService, fileStore);
  }
}
