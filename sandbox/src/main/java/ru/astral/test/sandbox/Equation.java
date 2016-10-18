package ru.astral.test.sandbox;

/**
 * Created by Fedor on 18.10.2016.
 */
public class Equation {
  private Double a;
  private Double b;
  private Double c;
  private Integer n;


  public Equation(Double a, Double b, Double c) {

    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;
    if (d > 0) {
      n = 2;
    } else if(d == 0) {
      n = 1;
    } else {
      n = 0;
    }
  }
  public int rootNumber() {
    return n;
  }

}
