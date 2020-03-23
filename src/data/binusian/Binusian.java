package data.binusian;

import util.IdFormatter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public abstract class Binusian implements Serializable { // Serializable is needed to save to file

  private String binusianId;

  private String name;

  private Date birthDate;

  private String address;

  public Binusian (int binusianSequence) {
    this.binusianId = IdFormatter.toBinusianId(binusianSequence);
  }

  /**
   * Copy constructor
   * @param binusian instance of binusian to be copied
   */
  public Binusian (Binusian binusian) {
    this.binusianId = binusian.binusianId;
    this.name = binusian.name;
    this.birthDate = binusian.birthDate;
    this.address = binusian.address;
  }

  public String getBinusianId() {
    return binusianId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getType () {
    return this.getClass().getSimpleName();
  }

}
