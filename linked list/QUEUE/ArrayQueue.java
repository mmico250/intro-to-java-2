
class ArrayQueue implements Queue
{
   private String[] myQueue = new String[5];
   private int head, tail; // enqueue at tail, dequeue at head
   
   public ArrayQueue()
   {
      head = 0;
      tail = 0;
   }
   
   public boolean isEmpty()
   {
      if (head == tail)
         return true;
      else
         return false;
   }
   
   private boolean isFull()
   {
      if (head == 0 && tail == myQueue.length-1)
         return true;
      else if (tail == head-1)
         return true;
      else
         return false;
   }
   
   public void enqueue(String s)
   {
      if (isFull())
      {
         System.out.println("Can't enqueue...queue is full");
         return;
      }
      myQueue[tail] = s;
      tail++;
      if (tail == myQueue.length)
         tail = 0;
      printArray();
   }
   
   public String dequeue()
   {
      String elem = null;
      if (!isEmpty())
      {
         elem = myQueue[head];
         head++;
         if (head == myQueue.length)
            head = 0;
      }
      printArray();
      return elem;
   }
   
   public void printArray()
   {
      System.out.println("Queue:");
      for (int i=0; i<myQueue.length; i++)
      {
         if (myQueue[i] == null)
            System.out.print("\"\"");
         else
            System.out.print(myQueue[i]);
         if (i == head)
            System.out.print(" ---head");
         if (i == tail)
            System.out.print(" ---tail");
         System.out.println();
      }
   }
}
