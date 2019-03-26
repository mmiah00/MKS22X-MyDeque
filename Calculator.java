import java.util.*;
import java.io.*;

public class Calculator{
  private static String[] operators = {"*", "/", "+", "-", "%"};
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] nums = s.split (" ");
      MyDeque <Double> a = new MyDeque <> (nums.length);
      for (int x = 2; x < nums.length; x ++) {
        if (Arrays.asList(operators).contains(nums[x])) {
          double first = Double.parseDouble (nums[x - 2]);
          double second = Double.parseDouble (nums[x - 1]);
          if (nums[x].equals ("*")) {
            a.addLast (first * second);
          }
          if (nums[x].equals ("/")) {
            a.addLast (first / second);
          }
          if (nums[x].equals ("+")) {
            a.addLast (first + second);
          }
          if (nums[x].equals ("-")) {
            a.addLast (first - second);
          }
          if (nums[x].equals ("%")) {
            a.addLast (first % second + 0.0);
          }
        }
      }
      return a.getFirst ();
    }

    public static void main (String[] args) {
      System.out.println (eval ("1 18 + 2 5.5 6 - * *"));
    }
}
