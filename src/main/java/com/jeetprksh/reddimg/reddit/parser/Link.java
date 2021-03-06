package com.jeetprksh.reddimg.reddit.parser;

import org.json.simple.JSONObject;

import static com.jeetprksh.reddimg.reddit.parser.JsonConvertor.*;


public class Link extends Thing {

  private String url;
  private String permalink;
  private String author;
  private String title;
  private String subreddit;
  private String subredditId;
  private String thumbnail;
  private String selftext;
  private String selftextHTML;
  private String domain;
  private String bannedBy;
  private String approvedBy;
  private String authorFlairCSSClass;
  private String linkFlairCSSClass;
  private String authorFlairText;
  private String linkFlairText;
  private String distinguished;
  private String from;
  private String fromId;
  private String removalReason;
  private String fromKind;
  private String postHint;

  private Long gilded;
  private Long commentCount;
  private Long reportCount;
  private Long score;
  private Long upVotes;
  private Long downVotes;

  private Double created;
  private Double createdUTC;
  private Double upvoteRatio;

  private Boolean visited;
  private Boolean self;
  private Boolean saved;
  private Boolean edited;
  private Boolean stickied;
  private Boolean nsfw;
  private Boolean hidden;
  private Boolean clicked;
  private Boolean likes;

  public Link(JSONObject obj) {
    super(safeJsonToString(obj.get("name")));

    setUrl(safeJsonToString(obj.get("url")));
    setPermalink(safeJsonToString(obj.get("permalink")));
    setAuthor(safeJsonToString(obj.get("author")));
    setTitle(safeJsonToString(obj.get("title")));
    setSubreddit(safeJsonToString(obj.get("subreddit")));
    setSubredditId(safeJsonToString(obj.get("subreddit_id")));
    setThumbnail(safeJsonToString(obj.get("thumbnail")));
    setSelftext(safeJsonToString(obj.get("selftext")));
    setSelftextHTML(safeJsonToString(obj.get("selftext_html")));
    setDomain(safeJsonToString(obj.get("domain")));
    setBannedBy(safeJsonToString(obj.get("banned_by")));
    setApprovedBy(safeJsonToString(obj.get("approved_by")));
    setAuthorFlairCSSClass(safeJsonToString(obj.get("author_flair_css_class")));
    setLinkFlairCSSClass(safeJsonToString(obj.get("link_flair_css_class")));
    setDistinguished(safeJsonToString(obj.get("distinguished")));
    setAuthorFlairText(safeJsonToString(obj.get("author_flair_text")));
    setLinkFlairText(safeJsonToString(obj.get("link_flair_text")));
    // setFrom(safeJsonToString(obj.get("from")));
    // setFromId(safeJsonToString(obj.get("from_id")));
    setRemovalReason(safeJsonToString(obj.get("removal_reason")));
    // setFromKind(safeJsonToString(obj.get("from_kind")));
    setPostHint(safeJsonToString(obj.get("post_hint")));

    setGilded(safeJsonToLong(obj.get("gilded")));
    setCommentCount(safeJsonToLong(obj.get("num_comments")));
    setReportCount(safeJsonToLong(obj.get("num_reports")));
    setScore(safeJsonToLong(obj.get("score")));
    setUpVotes(safeJsonToLong(obj.get("ups")));
    setDownVotes(safeJsonToLong(obj.get("downs")));

    setCreated(safeJsonToDouble(obj.get("created")));
    setCreatedUTC(safeJsonToDouble(obj.get("created_utc")));
    setUpvoteRatio(safeJsonToDouble(obj.get("upvote_ratio")));

    setVisited(safeJsonToBoolean(obj.get("visited")));
    setSelf(safeJsonToBoolean(obj.get("is_self")));
    setSaved(safeJsonToBoolean(obj.get("saved")));
    setEdited(safeJsonToBoolean(obj.get("edited")));
    setStickied(safeJsonToBoolean(obj.get("stickied")));
    setNsfw(safeJsonToBoolean(obj.get("over_18")));
    setHidden(safeJsonToBoolean(obj.get("hidden")));
    setClicked(safeJsonToBoolean(obj.get("clicked")));
    setLikes(safeJsonToBoolean(obj.get("likes")));
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPermalink() {
    return permalink;
  }

  public void setPermalink(String permalink) {
    this.permalink = permalink;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubreddit() {
    return subreddit;
  }

  public void setSubreddit(String subreddit) {
    this.subreddit = subreddit;
  }

  public String getSubredditId() {
    return subredditId;
  }

  public void setSubredditId(String subredditId) {
    this.subredditId = subredditId;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getSelftext() {
    return selftext;
  }

  public void setSelftext(String selftext) {
    this.selftext = selftext;
  }

  public String getSelftextHTML() {
    return selftextHTML;
  }

  public void setSelftextHTML(String selftextHTML) {
    this.selftextHTML = selftextHTML;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getBannedBy() {
    return bannedBy;
  }

  public void setBannedBy(String bannedBy) {
    this.bannedBy = bannedBy;
  }

  public String getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(String approvedBy) {
    this.approvedBy = approvedBy;
  }

  public String getAuthorFlairCSSClass() {
    return authorFlairCSSClass;
  }

  public void setAuthorFlairCSSClass(String authorFlairCSSClass) {
    this.authorFlairCSSClass = authorFlairCSSClass;
  }

  public String getLinkFlairCSSClass() {
    return linkFlairCSSClass;
  }

  public void setLinkFlairCSSClass(String linkFlairCSSClass) {
    this.linkFlairCSSClass = linkFlairCSSClass;
  }

  public String getAuthorFlairText() {
    return authorFlairText;
  }

  public void setAuthorFlairText(String authorFlairText) {
    this.authorFlairText = authorFlairText;
  }

  public String getLinkFlairText() {
    return linkFlairText;
  }

  public void setLinkFlairText(String linkFlairText) {
    this.linkFlairText = linkFlairText;
  }

  public String getDistinguished() {
    return distinguished;
  }

  public void setDistinguished(String distinguished) {
    this.distinguished = distinguished;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getFromId() {
    return fromId;
  }

  public void setFromId(String fromId) {
    this.fromId = fromId;
  }

  public String getRemovalReason() {
    return removalReason;
  }

  public void setRemovalReason(String removalReason) {
    this.removalReason = removalReason;
  }

  public String getFromKind() {
    return fromKind;
  }

  public String getPostHint() {
    return postHint;
  }

  public void setPostHint(String postHint) {
    this.postHint = postHint;
  }

  public void setFromKind(String fromKind) {
    this.fromKind = fromKind;
  }

  public Long getGilded() {
    return gilded;
  }

  public void setGilded(Long gilded) {
    this.gilded = gilded;
  }

  public Long getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Long commentCount) {
    this.commentCount = commentCount;
  }

  public Long getReportCount() {
    return reportCount;
  }

  public void setReportCount(Long reportCount) {
    this.reportCount = reportCount;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  public Long getUpVotes() {
    return upVotes;
  }

  public void setUpVotes(Long upVotes) {
    this.upVotes = upVotes;
  }

  public Long getDownVotes() {
    return downVotes;
  }

  public void setDownVotes(Long downVotes) {
    this.downVotes = downVotes;
  }

  public Double getCreated() {
    return created;
  }

  public void setCreated(Double created) {
    this.created = created;
  }

  public Double getCreatedUTC() {
    return createdUTC;
  }

  public void setCreatedUTC(Double createdUTC) {
    this.createdUTC = createdUTC;
  }

  public Double getUpvoteRatio() {
    return upvoteRatio;
  }

  public void setUpvoteRatio(Double upvoteRatio) {
    this.upvoteRatio = upvoteRatio;
  }

  public Boolean getVisited() {
    return visited;
  }

  public void setVisited(Boolean visited) {
    this.visited = visited;
  }

  public Boolean getSelf() {
    return self;
  }

  public void setSelf(Boolean self) {
    this.self = self;
  }

  public Boolean getSaved() {
    return saved;
  }

  public void setSaved(Boolean saved) {
    this.saved = saved;
  }

  public Boolean getEdited() {
    return edited;
  }

  public void setEdited(Boolean edited) {
    this.edited = edited;
  }

  public Boolean getStickied() {
    return stickied;
  }

  public void setStickied(Boolean stickied) {
    this.stickied = stickied;
  }

  public Boolean getNsfw() {
    return nsfw;
  }

  public void setNsfw(Boolean nsfw) {
    this.nsfw = nsfw;
  }

  public Boolean getHidden() {
    return hidden;
  }

  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }

  public Boolean getClicked() {
    return clicked;
  }

  public void setClicked(Boolean clicked) {
    this.clicked = clicked;
  }

  public Boolean getLikes() {
    return likes;
  }

  public void setLikes(Boolean likes) {
    this.likes = likes;
  }
}
