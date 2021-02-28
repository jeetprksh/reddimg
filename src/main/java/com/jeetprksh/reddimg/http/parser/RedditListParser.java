package com.jeetprksh.reddimg.http.parser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RedditListParser {

  public List<Thing> parse(JSONObject responseObject) {
    List<Thing> things = new ArrayList<>();
    JSONArray thingJsonObjects = responseObject.getJSONObject("data").getJSONArray("children");

    for (Object thingObject : thingJsonObjects) {
      JSONObject thingJsonObject = (JSONObject) thingObject;

      String thingKind = thingJsonObject.getString("kind");
      JSONObject thingData = thingJsonObject.getJSONObject("data");

      Kind kind = Kind.isValid(thingKind);
      Thing thing = getThing(kind, thingData);
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
