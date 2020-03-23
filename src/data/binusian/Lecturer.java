package data.binusian;

import util.IdFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public class Lecturer extends Binusian {

  private String lecturerId;

  private List<String> courses;

  public Lecturer(int binusianSequence, int lecturerSequence) {
    super(binusianSequence);
    this.lecturerId = IdFormatter.toLecturerId(lecturerSequence);
    this.courses = new ArrayList<>();
  }

  /**
   * Copy constructor
   * @param lecturer instance of lecturer to be copied
   */
  public Lecturer(Lecturer lecturer) {
    super(lecturer);
    this.lecturerId = lecturer.lecturerId;
    this.courses = lecturer.courses;
  }

  public String getLecturerId() {
    return lecturerId;
  }

  public List<String> getCourses() {
    return courses;
  }

  public void setCourses(List<String> courses) {
    this.courses = courses;
  }

}
