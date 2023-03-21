
class LinkedQueue implements Queue
{
   private SimpleNode head, tail;
   
   public LinkedQueue()
   {
      head = null;
      tail = null;
   }
   
   public boolean isEmpty()
   {
      if (head == null)
         return true;
      else
         return false;
   }
   
   public void enqueue(String s)
   {
      SimpleNode n = new SimpleNode(s);
      if (isEmpty())
      {
         head = n;
         tail = n;
      }
      else
      {
         tail.setNext(n);
         tail = n;
      }
   }
   
   public String dequeue()
   {
      String elem = null;
      if (!isEmpty())
      {
         elem = head.getStr();
         head = head.getNext();
         if (head == null)
            tail = null;
      }
      return elem;
   }
}
