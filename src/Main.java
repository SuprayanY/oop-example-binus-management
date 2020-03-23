import data.Binus;
import data.Sequence;
import data.binusian.Binusian;
import data.binusian.Lecturer;
import data.binusian.Student;
import util.FileUtils;
import util.Inquiry;
import util.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suprayan Yapura
 * @since March 23, 2020
 */
public class Main {
  private final static String BINUSIANS_FILE = "binusians.obj";
  private final static String SEQUENCE_FILE = "sequence.obj";

  private Binus binus;
  private Sequence sequence;
  private Inquiry inquiry;

  private Main() {
    loadData();
    while (true) {
      Menu.clearConsole();
      switch (Menu.promptMainMenu()) {
        case 1: viewBinusian(); break;
        case 2: addBinusian(); break;
        case 3: editBinusian(); break;
        case 4: removeBinusian(); break;
        case 0: saveAndExit();
      }
    }
  }

  private void viewBinusian() {
    Menu.clearConsole();
    int type = Menu.promptType(true);
    Menu.clearConsole();
    List<Binusian> binusians = showBinusianByType(type);
    if (binusians.size() != 0) {
      int choice = Menu.promptChoice(1, binusians.size());
      Binusian chosenBinusian = binusians.get(choice - 1);
      if (chosenBinusian instanceof Lecturer) {
        Menu.clearConsole();
        Menu.showLecturerDetail((Lecturer) chosenBinusian);
        Menu.pause();
      } else if (chosenBinusian instanceof Student) {
        Menu.clearConsole();
        Menu.showStudentDetail((Student) chosenBinusian);
        Menu.pause();
      }
    } else {
      Menu.pause();
    }
  }

  private void addBinusian() {
    Menu.clearConsole();
    int type = Menu.promptType(false);
    if (type == 1) {
      Binusian newBinusian = inquiry.createLecturer();
      binus.addBinusian(newBinusian);
      Menu.pause("Binusian has been added!");
    } else if (type == 2) {
      Binusian newBinusian = inquiry.createStudent();
      binus.addBinusian(newBinusian);
      Menu.pause("Binusian has been added!");
    }
  }

  private void editBinusian() {
    Menu.clearConsole();
    int type = Menu.promptType(true);
    Menu.clearConsole();
    List<Binusian> binusians = showBinusianByType(type);
    if (binusians.size() != 0) {
      int choice = Menu.promptChoice(1, binusians.size());
      Binusian chosenBinusian = binusians.get(choice - 1);
      if (chosenBinusian instanceof Lecturer) {
        Binusian editedBinusian = inquiry.editLecturer((Lecturer) chosenBinusian);
        binus.editBinusian(editedBinusian);
        Menu.pause("Binusian has been successfully edit");
      } else if (chosenBinusian instanceof Student) {
        Binusian editedBinusian = inquiry.editStudent((Student) chosenBinusian);
        binus.editBinusian(editedBinusian);
        Menu.pause("Binusian has been successfully edit");
      }
    } else {
      Menu.pause();
    }
  }

  private void removeBinusian() {
    Menu.clearConsole();
    int type = Menu.promptType(true);
    Menu.clearConsole();
    List<Binusian> binusians = showBinusianByType(type);
    if (binusians.size() != 0) {
      int choice = Menu.promptChoice(1, binusians.size());
      Binusian chosenBinusian = binusians.get(choice - 1);
      binus.removeBinusian(chosenBinusian.getBinusianId());
      Menu.pause("Binusian has been deleted");
    } else {
      Menu.pause();
    }
  }

  private List<Binusian> showBinusianByType(int type) {
    List<Binusian> binusians;
    switch (type) {
      case 0:
        binusians = binus.getBinusians();
        Menu.showBinusianList(binusians);
        break;
      case 1:
        binusians = binus.getBinusians(Lecturer.class);
        Menu.showLecturerList((List) binusians);
        break;
      case 2:
        binusians = binus.getBinusians(Student.class);
        Menu.showStudentList((List) binusians);
        break;
      default:
        binusians = new ArrayList<>();
    }
    return binusians;
  }

  private void loadData () {
    try {
      System.out.println("Loading data...");
      Object binusiansData = FileUtils.readFromFile(BINUSIANS_FILE);
      Object sequenceData = FileUtils.readFromFile(SEQUENCE_FILE);
      binus = binusiansData == null ? new Binus() : new Binus((List<Binusian>) binusiansData);
      sequence = sequenceData == null ? new Sequence() : (Sequence) sequenceData;
      inquiry = new Inquiry(sequence);
    } catch (Exception e) {
      Menu.pause("Failed to load data...");
      System.out.println(e.getMessage());
      System.exit(-1);
    }
  }

  private void saveAndExit() {
    try {
      System.out.println("Saving...");
      FileUtils.writeToFile(BINUSIANS_FILE, binus.getBinusians());
      FileUtils.writeToFile(SEQUENCE_FILE, sequence);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      Menu.pause("Failed to save data...");
    }
    System.out.println("File saved! Exiting...");
    System.exit(0);
  }

  public static void main(String[] args) {
    new Main();
  }

}
