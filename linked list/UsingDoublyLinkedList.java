
class UsingDoublyLinkedList
{
   public static void main(String[] args)
   {
      DoublyLinkedList list = new DoublyLinkedList();
      
      list.addFirst("Node1");
      list.addLast("Node2");
      list.addLast("Node3");
      
      // iterating forward
      System.out.print("The list:");
      DoubleNode cur = list.getHead();
      while (cur != null)
      {
         System.out.print(" " + cur.getStr());
         cur = cur.getNext();
      } 
      System.out.println();
      
      // iterating reverse
      System.out.print("The reversed list:");
      cur = list.getTail();
      while (cur != null)
      {
         System.out.print(" " + cur.getStr());
         cur = cur.getPrev();
      } 
      System.out.println();
      
      // getting element at index 1
      DoubleNode elem = list.getElement(1);
      System.out.println("Element at index 1 is " + elem.getStr());
      
      // searching Node3
      elem = list.search("Node3");
      if (elem != null)
         System.out.println("Found Node3");
      else
         System.out.println("Did not find Node3");
         
      // add element at beginning
      list.addFirst("Node4");
      list.printList();
      list.printReverse();
      
      // insert element at index 2
      elem = new DoubleNode("TestInsert");
      list.insert(elem, 2);
      list.printList();
      list.printReverse();

      // insert element at beginning
      elem = new DoubleNode("TestInsertB");
      list.insert(elem, 0);
      list.printList();
      list.printReverse();

      // insert element at end
      elem = new DoubleNode("TestInsertE");
      list.insert(elem, 6);
      list.printList();
      list.printReverse();

      // remove head
      elem = list.getHead();
      list.remove(elem);
      list.printList();
      list.printReverse();
      
      // remove tail
      elem = list.getTail();
      list.remove(elem);
      list.printList();
      list.printReverse();
      
      // remove middle
      elem = list.search("TestInsert");
      list.remove(elem);
      list.printList();
      list.printReverse();
   }
}
