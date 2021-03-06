import java.util.*;
import java.io.*;

public class Calculator{
  private static String[] operators = {"*", "/", "+", "-", "%"};

    public static double eval(String s){
      String[] ops = s.split (" ");
      //System.out.println ("Expression: " + toString (ops));
      MyDeque <Double> ans = new MyDeque <> (ops.length);
      for (int i = 0; i < ops.length; i ++) {
        if (Arrays.asList (operators).contains (ops[i])) { //if it is an operator
          Double second = ans.removeLast ();
          Double first = ans.removeLast ();
          if (ops[i].equals ("%")){
            ans.addLast (first % second);
            //System.out.println ("Mod: " + first + " % " + second);
          }
          if (ops[i].equals ("+")){
            ans.addLast (first + second);
            //System.out.println ("Adding: " + first + " + " + second);
          }
          if (ops[i].equals ("-")){
            ans.addLast (first - second);
            //System.out.println ("Subtracting: " + first + " - " + second);
          }
          if (ops[i].equals ("/")){
            ans.addLast (first / second);
            //System.out.println ("Dividing: " + first + " / " + second);
          }
          if (ops[i].equals ("*")){
            ans.addLast (first * second);
            //System.out.println ("Multiplying: " + first + " * " + second);
          }
        }
        else {
          ans.addLast (Double.parseDouble (ops[i]));
        }
      }
      return ans.getLast ();
    }

    private static String toString (String [] a) {
      String ans = "[";
      for (int x = 0 ; x < a.length; x ++) {
        ans += a[x] + " ";
      }
      ans += "]";
      return ans;
    }


    /*
    private static void evalDebug(String s){
      String[] ops = s.split (" ");
      System.out.println ("Expression: " + toString (ops));
      MyDeque <Double> ans = new MyDeque <> (ops.length);
      for (int i = 0; i < ops.length; i ++) {
        if (Arrays.asList (operators).contains (ops[i])) { //if it is an operator
          Double second = ans.removeLast ();
          Double first = ans.removeLast ();
          if (ops[i].equals ("%")){
            ans.addLast (first % second);
            System.out.println ("Mod: " + first + " % " + second);
          }
          if (ops[i].equals ("+")){
            Double temp = first + second;
            ans.addLast (temp);
            System.out.println ("Adding: " + first + " + " + second);
          }
          if (ops[i].equals ("-")){
            ans.addLast (first - second);
            System.out.println ("Subtracting: " + first + " - " + second);
          }
          if (ops[i].equals ("/")){
            ans.addLast (first / second);
            System.out.println ("Dividing: " + first + " / " + second);
          }
          if (ops[i].equals ("*")){
            ans.addLast (first * second);
            System.out.println ("Multiplying: " + first + " * " + second);
          }
        }
        else {
          ans.addLast (Double.parseDouble (ops[i]));
        }
        System.out.println (ans.toString ());
      }
      System.out.println ("Answer: " + ans.getLast ());
    }
    */


    /*
    public static void main (String[] args) {

      System.out.println ("1 18 + 2 5.5 6 - * * = " + ( (1+18) * (5.5 - 6) * 2 ));
      evalDebug ("1 18 + 2 5.5 6 - * *");

      System.out.println ("2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 * / * / * / * / * / * / * / * / * / *");
      evalDebug ("2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 * / * / * / * / * / * / * / * / * / *");
      //System.out.println (eval("4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 + + + + + + + + + + + + + + + + + + + + + + + + + +"));
    }
    */
}

/*
String[] nums = s.split (" ");
MyDeque <Double> a = new MyDeque <Double> (nums.length);
for (int i = 0; i < nums.length; i ++) {
  if (Arrays.asList (operators).contains (nums[i])) {
    Double second = a.removeLast ();
    Double first = a.removeLast ();
    if (nums[i].equals ("*")) {
      a.addLast (first * second);
    }
    if (nums[i].equals ("/")) {
      a.addLast (first / second);
    }
    if (nums[i].equals ("+")) {
      a.addLast (first + second);
    }
    if (nums[i].equals ("-")) {
      a.addLast (first - second);
    }
    if (nums[i].equals ("%")) {
      a.addLast (first % second);
    }
    System.out.println ("Get first: " + a.getFirst ());
    //pop last 2 numbers in the Deque
    //do the operation
    //then add to the deque
  }
  else {
    a.addLast (Double.parseDouble (nums[i]));
  }
  System.out.println (a);
}
return a.getFirst ();
*/
