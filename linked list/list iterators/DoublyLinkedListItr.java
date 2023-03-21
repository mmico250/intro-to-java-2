import java.util.*;

class DoublyLinkedList implements Iterable<String>
{
   private DoubleNode head, tail;
   
   public DoublyLinkedList()
   {
      head = null;
      tail = null;
   }
   
   public Iterator<String> iterator() // in Iterable interface
   {
      return new DoublyLinkedListIterator(head);
   }
   
   public Iterator<String> tailIterator()
   {
      return new DoublyLinkedListIterator(tail);
   }
   
   // Iterating to get to an index or find and element
   // is needed on many occasions, with access to the Node
   // (in order to change the pointers). However, we do not want
   // to have the Node in the public interface. So we put such
   // methods as private and reuse them when needed.
   
   // getToElement is the old getElement in DoublyLinkedList
   private DoubleNode getToElement(int index)
   {
      int i = 0;
      DoubleNode cur = head;
      while (cur != null && i<index)
      {
         cur = cur.getNext();
         i++;
      }
      return cur;
   }
   
   // internalSearch is the old search in DoublyLinkedList
   private DoubleNode internalSearch(String s)
   {
      DoubleNode cur = head;
      while (cur != null && !s.equals(cur.getStr()))
      {
         cur = cur.getNext();
      }
      return cur;
   }
   
   public String getElement(int index)
   {
      DoubleNode cur = getToElement(index);
      if (cur != null)
         return cur.getStr();
      else
         return null;
   }
   
   public Iterator<String> search(String s)
   {
      DoubleNode cur = internalSearch(s);
      if (cur != null)
         return new DoublyLinkedListIterator(cur);
      else
         return null;
   }
   // Note on search: for more complex objects, it would make
   // sense to return the object found rather than the "pointer"
   // to it in the list, but here we would simply return the
   // same object as what is passed in parameter, which is
   // not really useful.
   
   void addFirst(String s)
   {
      DoubleNode n = new DoubleNode(s);
      if (head == null)  // case that the list is empty
      {
         head = n;
         tail = n;
      }      
      else
      {
         n.setNext(head);
         head.setPrev(n);
         head = n;
      }
   }
   
   void addLast(String s)
   {
      DoubleNode n = new DoubleNode(s);
      if (head == null)  // case that the list is empty
      {
         head = n;
         tail = n;
      }      
      else
      {
         n.setPrev(tail);
         tail.setNext(n);
         tail = n;
      }
   }
   
   public void insert(String s, int index)
   {
      DoubleNode elem = new DoubleNode(s);
      if (index == 0)
      {
         if (tail == null)
            tail = elem;
         elem.setNext(head);
         if (head != null)
            head.setPrev(elem);
         head = elem;
      }
      else
      {
         DoubleNode prev = getToElement(index-1);
         DoubleNode next = prev.getNext();
         elem.setNext(next);
         elem.setPrev(prev);
         prev.setNext(elem);
         if (next != null)
            next.setPrev(elem);
         else
            tail = elem;
      }
   }
   
   public void remove(String s)
   {
      DoubleNode elem = internalSearch(s);
      if (elem == null)
         return;
         
      DoubleNode prev = elem.getPrev();
      DoubleNode next = elem.getNext();
      if (head == tail) // removing single element
      {
         if (head == elem)
         {
            head = null;
            tail = null;
         }
      }
      else if (prev == null) // removing head
      {
         head = next;
         head.setPrev(null);
      }
      else if (next == null) // removing tail
      {
         tail = prev;
         tail.setNext(null);
      }
      else
      {
         prev.setNext(next);
         next.setPrev(prev);
      }
   }
   
   public void printList()
   {
      System.out.print("The list:");
      DoubleNode cur = head;
      while (cur != null)
      {
         System.out.print(" " + cur.getStr());
         cur = cur.getNext();
      } 
      System.out.println();
   }
   
   public void printReverse()
   {
      System.out.print("The reversed list:");
      DoubleNode cur = tail;
      while (cur != null)
      {
         System.out.print(" " + cur.getStr());
         cur = cur.getPrev();
      } 
      System.out.println();
   }
}
