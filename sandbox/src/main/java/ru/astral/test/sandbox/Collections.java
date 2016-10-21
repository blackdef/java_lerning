package ru.astral.test.sandbox;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fedor on 21.10.2016.
 */
public class Collections {
  public static void main(String[] args){
    String[] langs = {"Java", "C#", "Python", "PHP"};
    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");


    for (String l : languages){
      System.out.println("Я хочу выучить язык "+ l);
    }

  }

}
