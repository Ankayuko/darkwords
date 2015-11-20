package hello;

import java.util.List;
import java.util.ArrayList;

public class Animale {
  private String name;
  private int id;

  public Animale() {}

  public Animale(int id, String name) {
      this.name = name;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
}