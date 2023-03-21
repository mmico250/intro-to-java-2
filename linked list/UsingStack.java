
class UsingStack
{
   public static void main(String[] args)
   {
      Stack st = new ArrayStack();
      
      st.push("Node1");
      st.push("Node2");
      st.push("Node3");
      System.out.println(st.pop());
      st.push("Node4");
      st.push("Node5");
      System.out.println(st.pop());
      st.push("Node6");
      st.push("Node7");
      st.push("Node8");
      while (!st.isEmpty())
         System.out.println(st.pop());

   }
}
