package com.jeetprksh.reddimg;

import com.jeetprksh.reddimg.config.ReddimgConfig;
import com.jeetprksh.reddimg.download.Downloader;
import com.jeetprksh.reddimg.files.FileStore;
import com.jeetprksh.reddimg.logging.ReddimgLogger;

import java.util.logging.Logger;

public class Reddimg {

  private static final Logger logger = ReddimgLogger.getLogger(Reddimg.class);

  public static void main(String[] args) throws Exception {
    FileStore fileStore = FileStore.create();
    ReddimgConfig.init(fileStore);
    ReddimgConfig config = ReddimgConfig.getConfig();

    logger.info("Starting app with config " + config);

    Downloader downloader = Downloader.createFor(config.getSubreddit());
    downloader.download();
  }
}
