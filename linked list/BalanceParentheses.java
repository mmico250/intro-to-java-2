import java.util.*;

class BalanceParentheses
{
   public static void main(String[] args)
   {
      LinkedList<Character> stack = new LinkedList<Character>();
      String str = "5+((3-2)*[(4/2+1)*3])";
      char c, cc;
      int i = 0;
      boolean problem = false;
      
      while (!problem && i < str.length())
      {
         c = str.charAt(i);
         if (c == '(' || c == '[')
         {
            stack.push(c);
         }
         else if (c == ')')
         {
            cc = stack.pop();
            if (cc != '(')
               problem = true;
         }
         else if (c == ']')
         {
            cc = stack.pop();
            if (cc != '[')
               problem = true;
         }
         i++;
      }
      if (problem || !stack.isEmpty())
      {
         System.out.println("Balance problem : " + str.substring(0, i));
      }
      else
      {
         System.out.println("All balanced!");
      }
   }
}
