package data;

import java.io.Serializable;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public class Sequence implements Serializable {

  private int binusian;

  private int lecturer;

  private int student;

  public Sequence() {
    this.binusian = 1;
    this.lecturer = 1;
    this.student = 1;
  }

  public int getBinusian() {
    return binusian++;
  }

  public void setBinusian(int binusian) {
    this.binusian = binusian;
  }

  public int getLecturer() {
    return lecturer++;
  }

  public void setLecturer(int lecturer) {
    this.lecturer = lecturer;
  }

  public int getStudent() {
    return student++;
  }

  public void setStudent(int student) {
    this.student = student;
  }

}
