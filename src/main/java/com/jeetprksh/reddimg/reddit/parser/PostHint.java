package com.jeetprksh.reddimg.reddit.parser;

public enum PostHint {

  SELF("self"), IMAGE("image"), RICH_VIDEO("rich:video"), LINK("link");

  private String postHint;

  PostHint(String postHint) {
    this.postHint = postHint;
  }

  public String value() {
    return this.postHint;
  }
}
