
class UsingQueue
{
   public static void main(String[] args)
   {
      //Queue q = new LinkedQueue();
      Queue q = new ArrayQueue();
      
      q.enqueue("Node1");
      q.enqueue("Node2");
      q.enqueue("Node3");
      System.out.println("Dequeued: " + q.dequeue());
      q.enqueue("Node4");
      q.enqueue("Node5");
      System.out.println("Dequeued: " + q.dequeue());
      q.enqueue("Node6");
      q.enqueue("Node7");
      q.enqueue("Node8");
      while (!q.isEmpty())
         System.out.println("Dequeued: " + q.dequeue());

   }
}
