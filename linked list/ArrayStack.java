
class ArrayStack implements Stack
{
   final int SIZE = 5;
   String[] stack;
   int count;
   
   public ArrayStack()
   {
      stack = new String[SIZE];
      count = 0;
   }
   
   public boolean isEmpty()
   {
      if (count == 0)
         return true;
      else
         return false;
   }
   
   public void push(String s)
   {
      if (count == SIZE)
      {
         System.out.println("Error: no more space");
      }
      else
      {
         stack[count] = s;
         count++;
      }
   }
   
   public String pop()
   {
      String elem = null;
      if (!isEmpty())
      {
         elem = stack[count-1];
         count--;
      }
      return elem;
   }
   
   public String peek()
   {
      if (!isEmpty())
         return stack[count-1];
      else
         return null;
   }
   
}
