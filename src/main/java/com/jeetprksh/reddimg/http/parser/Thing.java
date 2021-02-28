package com.jeetprksh.reddimg.http.parser;

public class Thing {

  protected final Kind kind;
  protected final String identifier;
  protected final String fullName;

  public Thing(String fullName) {
    this.fullName = fullName;
    this.kind = Kind.isValid(fullName.split("_")[0]);
    this.identifier = fullName.split("_")[1];
  }

  public Kind getKind() {
    return kind;
  }

  public String getIdentifier() {
    return identifier;
  }

  public String getFullName() {
    return fullName;
  }

}
