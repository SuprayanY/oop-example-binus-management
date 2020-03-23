package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Suprayan Yapura
 * @since March 24, 2020
 */
public class FileUtils {

  private final static String DATA_DIR = "resources";

  public static void writeToFile (String fileName, Object data) throws IOException {
    File file = new File(DATA_DIR, fileName);
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(data);
    oos.close();
    fos.close();
  }

  public static Object readFromFile (String fileName) throws Exception {
    File file = new File(DATA_DIR, fileName);
    if (file.exists()) {
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);
      Object data = ois.readObject();
      ois.close();
      fis.close();
      return data;
    } else {
      return null;
    }
  }

}
