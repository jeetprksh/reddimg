package com.jeetprksh.reddimg.reddit.http.model;

import java.io.InputStream;

public class ImageFile {

  private String fileName;
  private final String extension;
  private final InputStream fileContent;

  public ImageFile(String extension, InputStream fileContent) {
    this.extension = extension;
    this.fileContent = fileContent;
  }

  public String getExtension() {
    return extension;
  }

  public InputStream getFileContent() {
    return fileContent;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
}
