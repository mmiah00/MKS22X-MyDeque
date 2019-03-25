public class Calculator{
  private static String[] operators = {"*", "/", "+", "-", "%"};
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] nums = s.split (" ");
      MyDeque <String> a = new MyDeque <> (nums.length);
      for (int x = 0; x < nums.length; x ++) {
        a.addLast (nums[x]);
      }

      return 1.01;
    }
}
