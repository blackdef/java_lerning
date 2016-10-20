package ru.astral.test.sandbox;

/**
 * Created by Fedor on 20.10.2016.
 */
public class Primes {
  public static boolean isPrime (int n){
    for (int i = 2; i < n; i++){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
