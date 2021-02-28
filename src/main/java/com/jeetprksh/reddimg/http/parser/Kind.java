package com.jeetprksh.reddimg.http.parser;

public enum Kind {

  COMMENT("t1"),
  ACCOUNT("t2"),
  LINK("t3"),
  MESSAGE("t4"),
  SUBREDDIT("t5"),
  AWARD("t6"),
  PROMO_CAMPAIGN("t8"),
  MORE("more"),
  LISTING("listing");

  private String kind;

  Kind(String kind) {
    this.kind = kind;
  }

  String getKind() {
    return this.kind;
  }

  public static Kind isValid(String k) {
    for (Kind kind : Kind.values()) {
      if (kind.getKind().equals(k)) {
        return kind;
      }
    }
    return null;
  }

}
