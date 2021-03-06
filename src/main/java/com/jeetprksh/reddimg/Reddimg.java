package com.jeetprksh.reddimg;

import com.jeetprksh.reddimg.download.Downloader;

/**
 * Hello world!
 */
public class Reddimg {
  public static void main( String[] args ) throws Exception {
    Downloader downloader = Downloader.createFor("pics");
    downloader.download();
  }
}
