package ru.astral.test.sandbox;

public class MyFirstProgram {

  public static void hello(String word) {
    System.out.println("Hello, " + word +"!");
  }

  public static double area(Rectangle r) {
    return r.a * r.b;
  }

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Fedor");

    Square s  = new Square(5);
    Rectangle r = new Rectangle(4,6);


    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point n = new Point(1,1);
    Point m = new Point(4,5);

    System.out.println("Растояние между двумя токами = " + distance(n,m));

  }
  public static double distance(Point sp, Point ep){
    double x = ep.x - sp.x;
    double y = ep.y - sp.y;
    return Math.sqrt( x * x + y * y);
  }
}