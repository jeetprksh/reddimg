package com.jeetprksh.reddimg.logging;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReddimgLogger {

  private final static Logger logger = Logger.getLogger(ReddimgLogger.class.getName());
  private static Handler fileHandler;

  static {
    try {
      fileHandler = new FileHandler("%h/.reddimg/log/reddimg-%u-%g.log", 1_048_576, 10, true);
      fileHandler.setFormatter(new LogFormatter());
    } catch (Exception ex) {
      ex.printStackTrace();
      logger.severe("Error creating file handler for logger");
    }
  }

  public static Logger getLogger(Class<?> klass) {
    Logger appLogger = Logger.getLogger(klass.getName());
    appLogger.setLevel(Level.FINE);
    appLogger.addHandler(fileHandler);
    return appLogger;
  }
}
