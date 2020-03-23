package data.binusian;

import util.IdFormatter;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public class Student extends Binusian {

  private String studentId;

  private String major;

  public Student(int binusianSequence, int studentSequence) {
    super(binusianSequence);
    this.studentId = IdFormatter.toStudentId(studentSequence);
  }

  /**
   * Copy constructor
   * @param student instance of student to be copied
   */
  public Student(Student student) {
    super(student);
    this.studentId = student.studentId;
    this.major = student.major;
  }

  public String getStudentId() {
    return studentId;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

}
