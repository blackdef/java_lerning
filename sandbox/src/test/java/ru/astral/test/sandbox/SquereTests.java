package ru.astral.test.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * Created by Fedor on 11.10.2016.
 */
public class SquereTests {

  @Test
  public void testArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(),25.0);

  }
}
