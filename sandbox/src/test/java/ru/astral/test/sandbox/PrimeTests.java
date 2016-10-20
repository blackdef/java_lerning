package ru.astral.test.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Fedor on 20.10.2016.
 */
public class PrimeTests {
  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
}
