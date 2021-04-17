package com.jeetprksh.reddimg.config;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeetprksh.reddimg.files.FileStore;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;

public class ReddimgConfig {

  private static ReddimgConfig CONFIG = null;

  @SerializedName("appId")
  @Expose
  private final String appId;

  @SerializedName("version")
  @Expose
  private final String version;

  @SerializedName("userName")
  @Expose
  private final String userName;

  @SerializedName("subreddit")
  @Expose
  private final String subreddit;

  private ReddimgConfig(String appId, String version, String userName, String subreddit) {
    this.appId = appId;
    this.version = version;
    this.userName = userName;
    this.subreddit = subreddit;
  }

  public String getAppId() {
    return appId;
  }

  public String getVersion() {
    return version;
  }

  public String getUserName() {
    return userName;
  }

  public String getSubreddit() {
    return subreddit;
  }

  @Override
  public String toString() {
    return "ReddimgConfig{" +
            "appId='" + appId + '\'' +
            ", version='" + version + '\'' +
            ", userName='" + userName + '\'' +
            ", subreddit='" + subreddit + '\'' +
            '}';
  }

  public static void init(FileStore fileStore) throws Exception {
    CONFIG = new Gson().fromJson(
            IOUtils.toString(fileStore.readConfigFile(), StandardCharsets.UTF_8), ReddimgConfig.class);
  }

  public static ReddimgConfig getConfig() {
    return CONFIG;
  }

}
