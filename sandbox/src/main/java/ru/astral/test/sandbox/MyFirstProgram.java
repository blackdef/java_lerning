package ru.astral.test.sandbox;

public class MyFirstProgram {

  public static void hello(String word) {
    System.out.println("Hello, " + word +"!");
  }
  public static double area (double len){
    return len * len;
  }

  public static double area(double a, double b) {
    return a * b;
  }

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Fedor");
    double l = 5.0;
    double b = 4.0;
    double a = 5.0;


    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a,b));
  }
}