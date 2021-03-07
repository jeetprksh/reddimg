package com.jeetprksh.reddimg.reddit.parser;

public enum PostHint {

  SELF("self"),
  IMAGE("image"),
  RICH_VIDEO("rich:video"),
  LINK("link"),
  HOSTED_VIDEO("hosted:video");

  private String postHint;

  PostHint(String postHint) {
    this.postHint = postHint;
  }

  public String value() {
    return this.postHint;
  }
}
