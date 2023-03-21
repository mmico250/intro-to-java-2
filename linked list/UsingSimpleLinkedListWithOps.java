
class UsingSimpleLinkedList
{
   public static void main(String[] args)
   {
      SimpleNode n1 = new SimpleNode("Node1");
      SimpleNode n2 = new SimpleNode("Node2");
      SimpleNode n3 = new SimpleNode("Node3");
      n1.setNext(n2);
      n2.setNext(n3);
      SimpleLinkedList list = new SimpleLinkedList(n1); 
      
      // iterating
      System.out.print("The list:");
      SimpleNode cur = list.getHead();
      while (cur != null)
      {
         System.out.print(" " + cur.getStr());
         cur = cur.getNext();
      } 
      System.out.println();
      
      // getting element at index 1
      SimpleNode elem = list.getElement(1);
      System.out.println("Element at index 1 is " + elem.getStr());
      
      // searching Node3
      elem = list.search("Node3");
      if (elem != null)
         System.out.println("Found Node3");
      else
         System.out.println("Did not find Node3");
         
      // add element at beginning
      list.addElement("Node4");
      list.printList();
      
      // insert element at index 2
      elem = new SimpleNode("TestInsert");
      list.insert(elem, 2);
      list.printList();

      // insert element at beginning
      elem = new SimpleNode("TestInsertB");
      list.insert(elem, 0);
      list.printList();

      // remove head
      elem = list.getHead();
      list.remove(elem);
      list.printList();
      
      // remove tail
      list.remove(n3);
      list.printList();
      
      // remove middle
      elem = list.search("TestInsert");
      list.remove(elem);
      list.printList();
   }
}
