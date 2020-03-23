package util;

import data.Sequence;
import data.binusian.Lecturer;
import data.binusian.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public class Inquiry {

  private static Scanner scanner = new Scanner(System.in);
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

  private Sequence sequence;

  public Inquiry (Sequence sequence) {
    this.sequence = sequence;
  }

  public Lecturer createLecturer() {
    Lecturer lecturer = new Lecturer(sequence.getBinusian(), sequence.getLecturer());
    System.out.println("Add Lecturer");
    System.out.println("============");
    lecturer.setName(inquireName());
    lecturer.setBirthDate(inquireBirthDate());
    lecturer.setAddress(inquireAddress());
    lecturer.setCourses(inquireCourses());
    return lecturer;
  }

  public Lecturer editLecturer (Lecturer lecturer) {
    Lecturer editedLecturer = new Lecturer(lecturer);
    System.out.println("Edit Lecturer");
    System.out.println("=============");
    editedLecturer.setName(inquireName());
    editedLecturer.setBirthDate(inquireBirthDate());
    editedLecturer.setAddress(inquireAddress());
    editedLecturer.setCourses(inquireCourses());
    return editedLecturer;
  }

  public Student createStudent() {
    Student student = new Student(sequence.getBinusian(), sequence.getStudent());
    System.out.println("Add Student");
    System.out.println("===========");
    student.setName(inquireName());
    student.setBirthDate(inquireBirthDate());
    student.setAddress(inquireAddress());
    student.setMajor(inquireMajor());
    return student;
  }

  public Student editStudent (Student student) {
    Student editedStudent = new Student(student);
    System.out.println("Edit Student");
    System.out.println("============");
    editedStudent.setName(inquireName());
    editedStudent.setBirthDate(inquireBirthDate());
    editedStudent.setAddress(inquireAddress());
    editedStudent.setMajor(inquireMajor());
    return editedStudent;
  }

  private String inquireName () {
    String name;
    do {
      System.out.print("Input name [Length: 3-15]: ");
      name = scanner.nextLine();
      System.out.println(name);
    } while(name.length() < 3 || name.length() > 15);
    return name;
  }

  private Date inquireBirthDate () {
    Date date = null;
    String dateInput;
    do {
      try {
        System.out.print("Input birth of date [DD MMMM YYYY]: ");
        dateInput = scanner.nextLine();
        date = dateFormat.parse(dateInput); // convert/parse string to date
      } catch (ParseException ignored) {}
    } while(date == null);
    return date;
  }

  private String inquireAddress() {
    String address;
    do {
      System.out.print("Input address [Length: 5-25]: ");
      address = scanner.nextLine();
    } while(address.length() < 5 || address.length() > 25);
    return address;
  }

  private List<String> inquireCourses() {
    String course;
    List<String> courses = new ArrayList<>();
    do {
      System.out.printf("Input course %d [Length: 5-25, or blank if done]: ", courses.size() + 1);
      course = scanner.nextLine();
      if(course.length() >= 5 && course.length() <= 25) {
        courses.add(course);
      }
    } while(course.length() != 0);
    return courses;
  }

  private String inquireMajor() {
    String major;
    do {
      System.out.print("Input major [Length: 5-25]: ");
      major = scanner.nextLine();
    } while(major.length() < 5 || major.length() > 25);
    return major;
  }

}
