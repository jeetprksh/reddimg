package com.jeetprksh.reddimg.reddit.parser;

import java.util.logging.Logger;

public class JsonConvertor {

  private static final Logger logger = Logger.getLogger(JsonConvertor.class.getName());

  public static String safeJsonToString(Object obj) {
    return obj == null ? null : obj.toString();
  }

  public static Integer safeJsonToInteger(Object obj) {
    try {
      String str = safeJsonToString(obj);
      return str != null ? Integer.parseInt(str) : null;
    } catch (NumberFormatException e) {
      logger.warning("Conversion failed");
      return null;
    }
  }

  public static Double safeJsonToDouble(Object obj) {
    try {
      String str = safeJsonToString(obj);
      return str != null ? Double.parseDouble(str) : null;
    } catch (NumberFormatException e) {
      logger.warning("Conversion failed");
      return null;
    }
  }

  public static Boolean safeJsonToBoolean(Object obj) {
    String str = safeJsonToString(obj);
    return str != null ? Boolean.parseBoolean(str) : null;
  }

  public static Long safeJsonToLong(Object obj) {
    try {
      String str = safeJsonToString(obj);
      return str != null ? Long.parseLong(str) : null;
    } catch (NumberFormatException e) {
      logger.warning("Conversion failed");
      return null;
    }
  }

}
