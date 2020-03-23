# BINUS Management

## What is this?
This is a console-based app as an example for OOP concepts.

## How to run?
```shell script
java -jar ./distribution/BINUS.jar
```

## OOP Principles
### 1. Encapsulation
It's talking about keeping the data as private. If anyone needs to access/modify the data, it can only be done through the public accessors or setters (check classes in [src/data/binusian](src/data/binusian)).

```Java
public class Binusian {
  private String binusianId;
  
  public void setBinusianId(String binusianId) {
    this.binusianId = binusianId;
  }
  
  public String getBinusianId() {
    return binusianId;
  }
}
```

Keywords:
- Private Data
- Public Setter/Getter

### 2. Inheritance
Creating a class based on another class, it's what inheritance/derivation is.
As for this example, both [Lecturer](src/data/binusian/Lecturer.java) and [Student](src/data/binusian/Student.java) is derived from [Binusian](src/data/binusian/Binusian.java).

### 3. Polymorphism
Polymorphism is the ability for an object to take many forms.
In code, it's usually applied as a parent class reference refers to its child class object.
```Java
Binusian binusian = new Lecturer();
binusian = new Student();
```
