package com.jeetprksh.reddimg.files;

import com.jeetprksh.reddimg.logging.ReddimgLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

public class FileStore {

  private final Logger logger = ReddimgLogger.getLogger(FileStore.class);

  private final File appDirectory;

  private FileStore(File appDirectory) {
    this.appDirectory = appDirectory;
  }

  public InputStream readConfigFile() throws Exception {
    return new FileInputStream(new File(appDirectory.getAbsolutePath() + "/config.json"));
  }

  public static FileStore create() {
    File appDirectory = new File(System.getProperty("user.home") + "/Reddimg/");
    appDirectory.mkdirs();
    return new FileStore(appDirectory);
  }
}
