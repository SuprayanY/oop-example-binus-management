package util;

import java.util.Calendar;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public class IdFormatter {

  public static String toBinusianId (int sequence) {
    return String.format("BN%04d", sequence); // %04d means left pad with 0, size 4
  }

  public static String toLecturerId (int sequence) {
    return String.format("D%04d", sequence);  // %04d means left pad with 0, size 4
  }

  public static String toStudentId (int sequence) {
    int year = Calendar.getInstance().get(Calendar.YEAR); // i.e 2021
    String yearString = String.valueOf(year); // convert to string "2021"
    yearString = yearString.substring(2); // get from idx 2, result: "21"
    yearString = String.format("%-3s", yearString); // pad with space, size: 3, result: "21 "
    yearString = yearString.replace(" ", "0"); // replace space with 0, result: "210"
    return String.format("%s%04d", yearString, sequence);
  }

}
