
class SimpleLinkedList
{
   SimpleNode head;
   
   SimpleLinkedList(SimpleNode head)
   {
      this.head = head;
   }
   
   SimpleNode getHead()
   {
      return head;
   }
   
   SimpleNode getElement(int index)
   {
      int i = 0;
      SimpleNode cur = head;
      while (cur != null && i<index)
      {
         cur = cur.getNext();
         i++;
      }
      return cur;
   }
   
   SimpleNode search(String s)
   {
      SimpleNode cur = head;
      while (cur != null && !s.equals(cur.getStr()))
      {
         cur = cur.getNext();
      }
      return cur;
   }
   
   void addElement(String s)
   {
      SimpleNode n = new SimpleNode(s);
      n.setNext(head);
      head = n;
   }
   
   void insert(SimpleNode elem, int index)
   {
      if (index == 0)
      {
         elem.setNext(head);
         head = elem;
      }
      else
      {
         SimpleNode prev = getElement(index-1);
         elem.setNext(prev.getNext());
         prev.setNext(elem);
      }
   }
   
   void remove(SimpleNode elem)
   {
      if (elem == head)
      {
         head = elem.getNext();
      }
      else
      {
         SimpleNode prev = head;
         while (prev != null && prev.getNext() != elem)
         {
            prev = prev.getNext();
         }
         // prev is now the previous element, if elem was in the list
         if (prev != null)
         {
            prev.setNext(elem.getNext());
         }
      }
   }
   
   void printList()
   {
      System.out.print("The list:");
      SimpleNode cur = head;
      while (cur != null)
      {
         System.out.print(" " + cur.getStr());
         cur = cur.getNext();
      } 
      System.out.println();
   }
}
