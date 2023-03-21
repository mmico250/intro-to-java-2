import java.util.*;

class DoublyLinkedListIterator implements Iterator<String>
{
   DoubleNode current;
   
   DoublyLinkedListIterator(DoubleNode node)
   {
      current = node;
   }
   
   public String next() // in Iterator interface
   {
      String res = null;
      if (current != null)
      {
         res = current.getStr();
         current = current.getNext();
      }
      return res;
   }
   
   public boolean hasNext() // in Iterator interface
   {
      if (current != null)
         return true;
      else
         return false;
   }

   public String prev() 
   {
      String res = null;
      if (current != null && current.getPrev() != null)
      {
         current = current.getPrev();
         res = current.getStr();
      }
      return res;
   }
   
   public boolean hasPrev() 
   {
      if (current != null && current.getPrev() != null)
         return true;
      else
         return false;
   }
   
   public String peek()
   {
      if (current != null)
         return current.getStr();
      else
         return null;
   }
}
