package com.jeetprksh.reddimg.download;

import com.jeetprksh.reddimg.files.FileStore;
import com.jeetprksh.reddimg.reddit.RedditService;
import com.jeetprksh.reddimg.reddit.http.model.ImageFile;
import com.jeetprksh.reddimg.reddit.parser.Link;
import com.jeetprksh.reddimg.reddit.parser.PostHint;

import java.util.List;
import java.util.stream.Collectors;

public class Downloader {

  private final RedditService redditService;
  private final FileStore fileStore;

  private Downloader(RedditService redditService, FileStore fileStore) {
    this.redditService = redditService;
    this.fileStore = fileStore;
  }

  public void download() throws Exception {
    List<Link> links = redditService.getAllSubredditLinks().stream()
            .filter(link -> PostHint.IMAGE.value().equals(link.getPostHint()))
            .collect(Collectors.toList());

    for (Link link : links) {
      String imgUrl = link.getUrl();
      ImageFile imageFile = redditService.downloadImage(imgUrl);
      imageFile.setFileName(link.getTitle());
      fileStore.createFile(imageFile);
    }
  }

  public static Downloader createFor(String subredditName) {
    RedditService redditService = RedditService.create(subredditName);
    FileStore fileStore = FileStore.create(subredditName);
    return new Downloader(redditService, fileStore);
  }
}
