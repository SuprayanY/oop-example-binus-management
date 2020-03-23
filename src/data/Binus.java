package data;

import data.binusian.Binusian;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public class Binus {

  private List<Binusian> binusians;

  public Binus() {
    this(new ArrayList<>());
  }

  public Binus(List<Binusian> binusians) {
    this.binusians = binusians;
  }

  public List<Binusian> getBinusians() {
    return binusians;
  }

  public List<Binusian> getBinusians(Class type) {
    List<Binusian> binusians = new ArrayList<>(); // we will keep in here
    for (Binusian binusian: this.binusians) { // look 1-by-1
      if (type.isInstance(binusian)) { // check if the same type as parameter
        binusians.add(binusian); // add to the list
      }
    }
    return binusians;
  }

  public void addBinusian(Binusian binusian) {
    this.binusians.add(binusian);
  }

  public void editBinusian(Binusian binusian) {
    int total = binusians.size();
    for (int i = 0; i < total; i++) { // look 1-by-1
      Binusian currentBinusian = binusians.get(i); // binusian at index i
      if (currentBinusian.getBinusianId().equals(binusian.getBinusianId())) { // check if it's the same binusian
        binusians.set(i, binusian); // replace index i with new data
        break; // no need further loop
      }
    }
  }

  public void removeBinusian(String binusianId) {
    int total = binusians.size();
    for (int i = 0; i < total; i++) { // look 1-by-1
      Binusian currentBinusian = binusians.get(i); // binusian at index i
      if (currentBinusian.getBinusianId().equals(binusianId)) { // check if it's the same binusian
        binusians.remove(i); // delete index i
        break; // no need further loop
      }
    }
  }

}
