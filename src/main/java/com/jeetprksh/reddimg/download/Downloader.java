package com.jeetprksh.reddimg.download;

import com.jeetprksh.file.download.BatchFileDownloader;
import com.jeetprksh.file.download.config.AllDownloads;
import com.jeetprksh.file.download.config.DownloadSet;
import com.jeetprksh.file.download.config.File;
import com.jeetprksh.reddimg.logging.ReddimgLogger;
import com.jeetprksh.reddimg.reddit.RedditService;
import com.jeetprksh.reddimg.reddit.parser.Link;
import com.jeetprksh.reddimg.reddit.parser.PostHint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Downloader {

  private final Logger logger = ReddimgLogger.getLogger(Downloader.class);

  private final RedditService redditService;

  private Downloader(RedditService redditService) {
    this.redditService = redditService;
  }

  public void download() throws Exception {
    logger.info("Starting Download");
    List<Link> links = redditService.getAllSubredditLinks().stream()
            .filter(link -> PostHint.IMAGE.value().equals(link.getPostHint()))
            .collect(Collectors.toList());

    List<File> files = new ArrayList<>();
    for (Link link : links) {
      String imgUrl = link.getUrl();
      files.add(new File(link.getTitle(), imgUrl));
    }

    List<DownloadSet> downloadSets = Collections.singletonList(new DownloadSet(files, redditService.getSubredditName()));
    AllDownloads allDownloads = new AllDownloads(true, "Reddimg", downloadSets);
    BatchFileDownloader downloader = new BatchFileDownloader(allDownloads);
    downloader.start();
  }

  public static Downloader createFor(String subredditName) {
    RedditService redditService = RedditService.create(subredditName);
    return new Downloader(redditService);
  }
}
