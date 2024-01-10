//methods return values exercise
//Hendrix Gryspeerdt
//jan 9th, 2019

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class MethodsinJava_returnvalues
{
 public static void main (String []args)
 {
   Ex1a_randomNumber();
 }
 
 public static void Ex1a_randomNumber()
 {
   int roll = ThreadLocalRandom.current().nextInt(1, 7); //simulate a dice roll
      System.out.println("\n\n\nA method that will a random number between 1 and 6.");
      System.out.println("Number generated: " + roll);
      System.out.println("\n\n\n");
 }
}