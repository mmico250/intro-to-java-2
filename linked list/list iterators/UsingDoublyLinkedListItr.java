import java.util.*;

class UsingDoublyLinkedListItr
{
   public static void main(String[] args)
   {
      DoublyLinkedList list = new DoublyLinkedList();
      
      list.addFirst("Node1");
      list.addLast("Node2");
      list.addLast("Node3");
      
      // iterating forward
      System.out.print("The list:");
      DoublyLinkedListIterator iter = 
                     (DoublyLinkedListIterator) list.iterator();
      while (iter.hasNext())
      {
         System.out.print(" " + iter.next());
      } 
      System.out.println();
      
      // iterating reverse
      System.out.print("The reversed list:");
      iter = (DoublyLinkedListIterator) list.tailIterator();
      System.out.print(" " + iter.peek());
      while (iter.hasPrev())
      {
         System.out.print(" " + iter.prev());
      } 
      System.out.println();
      
      // getting element at index 1
      String elem = list.getElement(1);
      System.out.println("Element at index 1 is " + elem);
      
      // searching Node3
      Iterator<String> pos = list.search("Node3");
      if (pos != null)
         System.out.println("Found Node3");
      else
         System.out.println("Did not find Node3");
         
      // add element at beginning
      list.addFirst("Node4");
      list.printList();
      list.printReverse();
      
      // insert element at index 2
      list.insert("TestInsert", 2);
      list.printList();
      list.printReverse();

      // insert element at beginning
      list.insert("TestInsertB", 0);
      list.printList();
      list.printReverse();

      // insert element at end
      list.insert("TestInsertE", 6);
      list.printList();
      list.printReverse();

      // remove head
      iter = (DoublyLinkedListIterator) list.iterator();
      list.remove(iter.peek());
      list.printList();
      list.printReverse();
      
      // remove tail
      iter = (DoublyLinkedListIterator) list.tailIterator();
      list.remove(iter.peek());
      list.printList();
      list.printReverse();
      
      // remove middle
      list.remove("TestInsert");
      list.printList();
      list.printReverse();

      System.out.println("for each...");
      for (String s : list)
         System.out.print(" " + s);
      System.out.println();
   
      System.out.println("Pairs..");
      Iterator<String> iter1 = list.iterator();
      Iterator<String> iter2;
      String s1, s2;
      while (iter1.hasNext())
      {
         s1 = iter1.next();
         iter2 = list.iterator();
         while (iter2.hasNext())
         {
            s2 = iter2.next();
            System.out.println("Pair " + s1 + " & " + s2);
         }
      }
   }
}
