package com.jeetprksh.reddimg.files;

import com.jeetprksh.reddimg.logging.ReddimgLogger;
import com.jeetprksh.reddimg.reddit.http.model.ImageFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class FileStore {

  private final Logger logger = ReddimgLogger.getLogger(FileStore.class);

  private final File downloadDirectory;

  private FileStore(File downloadDirectory) {
    this.downloadDirectory = downloadDirectory;
  }

  public void createFile(ImageFile imageFile) throws IOException {
    File imgFile = new File(downloadDirectory.toPath() + "/"
            + sanitizeFileName(imageFile.getFileName()) + "." + imageFile.getExtension());

    InputStream inputStream = imageFile.getFileContent();
    try(FileOutputStream outputStream = new FileOutputStream(imgFile)) {
      int read;
      byte[] bytes = new byte[1024];
      while ((read = inputStream.read(bytes)) != -1) {
        outputStream.write(bytes, 0, read);
      }
    }
    logger.info("Image file saved at " + imgFile.getAbsolutePath());
  }

  private String sanitizeFileName(String fileName) {
    return fileName.replaceAll("[\\/:*?<>|\"]", "_");
  }

  public static FileStore create(String subredditName) {
    File subredditDownloadDir = new File(System.getProperty("user.home") + "/Reddimg/" + subredditName);
    subredditDownloadDir.mkdirs();
    return new FileStore(subredditDownloadDir);
  }
}
