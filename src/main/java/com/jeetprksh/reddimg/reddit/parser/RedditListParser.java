package com.jeetprksh.reddimg.reddit.parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RedditListParser {

  public List<Thing> parse(JSONObject responseObject) {
    List<Thing> things = new ArrayList<>();
    JSONArray thingJsonObjects = (JSONArray) ((JSONObject) responseObject.get("data")).get("children");

    for (Object thingObject : thingJsonObjects) {
      JSONObject thingJsonObject = (JSONObject) thingObject;

      String thingKind = JsonConvertor.safeJsonToString(thingJsonObject.get("kind"));
      Object thingData = thingJsonObject.get("data");

      Kind kind = Kind.isValid(thingKind);
      Thing thing = getThing(kind, (JSONObject) thingData);
      things.add(thing);
    }

    return things;
  }

  private Thing getThing(Kind kind, JSONObject data) {
    if (kind == Kind.COMMENT) {
      return null;
    } else if (kind == Kind.LINK) {
      return new Link(data);
    } else if (kind == Kind.SUBREDDIT) {
      return null;
    } else if (kind == Kind.MORE) {
      return null;
    } else {
      return null;
    }
  }
}
