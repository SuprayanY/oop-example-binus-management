package util;

import data.binusian.Binusian;
import data.binusian.Lecturer;
import data.binusian.Student;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public class Menu {

  private static Scanner scanner = new Scanner(System.in);
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

  public static int promptMainMenu() {
    System.out.println("BINUS Management");
    System.out.println("================");
    System.out.println("1. View Binusian");
    System.out.println("2. Add Binusian");
    System.out.println("3. Edit Binusian");
    System.out.println("4. Remove Binusian");
    System.out.println("0. Save and Exit");
    return promptChoice(0, 4);
  }

  public static int promptType(boolean all) {
    System.out.println("Type");
    System.out.println("=====");
    if (all) {
      System.out.println("0. All");
    }
    System.out.println("1. Lecturer");
    System.out.println("2. Student");
    return promptChoice(all ? 0 : 1, 2);
  }

  public static void showLecturerDetail(Lecturer lecturer) {
    String coursesString = "";
    System.out.println("Lecturer Detail");
    System.out.println("===============");
    System.out.printf("Binusian ID   : %s\n", lecturer.getBinusianId());
    System.out.printf("Lecturer ID   : %s\n", lecturer.getLecturerId());
    System.out.printf("Name          : %s\n", lecturer.getName());
    System.out.printf("Date of Birth : %s\n", dateFormat.format(lecturer.getBirthDate()));
    System.out.printf("Address       : %s\n", lecturer.getAddress());
    for(String course: lecturer.getCourses()) {
      if (coursesString.length() != 0) {
        coursesString = coursesString.concat(", ");
      }
      coursesString = coursesString.concat(course);
    }
    System.out.printf("Courses       : %s\n", coursesString);
  }

  public static void showStudentDetail(Student student) {
    System.out.println("Student Detail");
    System.out.println("==============");
    System.out.printf("Binusian ID   : %s\n", student.getBinusianId());
    System.out.printf("Student ID    : %s\n", student.getStudentId());
    System.out.printf("Name          : %s\n", student.getName());
    System.out.printf("Date of Birth : %s\n", dateFormat.format(student.getBirthDate()));
    System.out.printf("Address       : %s\n", student.getAddress());
    System.out.printf("Major         : %s\n", student.getMajor());
  }

  public static void showBinusianList(List<Binusian> binusians) {
    System.out.println(String.format("%064d", 0).replace("0", "-"));
    System.out.printf("| %-3s | %-11s | %-15s | %-8s | %-11s |\n", "#", "Binusian ID", "Name", "Type", "BoD");
    System.out.println(String.format("%064d", 0).replace("0", "-"));
    if (binusians.size() != 0) {
      int count = 1;
      for (Binusian binusian : binusians) {
        System.out.printf("| %-3d | %-11s | %-15s | %-8s | %-11s |\n", count++, binusian.getBinusianId(),
            binusian.getName(), binusian.getType(), dateFormat.format(binusian.getBirthDate()));
        System.out.println(String.format("%064d", 0).replace("0", "-"));
      }
    } else {
      System.out.printf("| %-60s |\n", "No Data");
      System.out.println(String.format("%064d", 0).replace("0", "-"));
    }
  }

  public static void showLecturerList(List<Lecturer> lecturers) {
    System.out.println(String.format("%067d", 0).replace("0", "-"));
    System.out.printf("| %-3s | %-11s | %-11s | %-15s | %-11s |\n", "#", "Binusian ID", "Lecturer ID", "Name", "BoD");
    System.out.println(String.format("%067d", 0).replace("0", "-"));
    if (lecturers.size() != 0) {
      int count = 1;
      for (Lecturer lecturer: lecturers) {
        System.out.printf("| %-3d | %-11s | %-11s | %-15s | %-11s |\n", count++, lecturer.getBinusianId(),
            lecturer.getLecturerId(), lecturer.getName(), dateFormat.format(lecturer.getBirthDate()));
        System.out.println(String.format("%067d", 0).replace("0", "-"));
      }
    } else {
      System.out.printf("| %-63s |\n", "No Data");
      System.out.println(String.format("%067d", 0).replace("0", "-"));
    }
  }

  public static void showStudentList(List<Student> students) {
    System.out.println(String.format("%066d", 0).replace("0", "-"));
    System.out.printf("| %-3s | %-11s | %-10s | %-15s | %-11s |\n", "#", "Binusian ID", "Student ID", "Name", "BoD");
    System.out.println(String.format("%066d", 0).replace("0", "-"));
    if (students.size() != 0) {
      int count = 1;
      for (Student student: students) {
        System.out.printf("| %-3d | %-11s | %-10s | %-15s | %-11s |\n", count++, student.getBinusianId(),
            student.getStudentId(), student.getName(), dateFormat.format(student.getBirthDate()));
        System.out.println(String.format("%066d", 0).replace("0", "-"));
      }
    } else {
      System.out.printf("| %-62s |\n", "No Data");
      System.out.println(String.format("%066d", 0).replace("0", "-"));
    }
  }

  public static void pause(String message) {
    System.out.print(message);
    scanner.nextLine();
  }

  public static void pause() {
    pause("Press ENTER to continue...");
  }

  public static int promptChoice(int min, int max) {
    int choice;
    do {
      System.out.print("Choice: ");
      choice = scanner.nextInt();
      // if you read a non-string data, make sure to add nextLine() because \n is still left in input stream
      scanner.nextLine();
    } while (choice < min || choice > max);
    return choice;
  }

  public static void clearConsole () {
    for (int i = 0; i < 25; i++) {
      System.out.println();
    }
  }

}
