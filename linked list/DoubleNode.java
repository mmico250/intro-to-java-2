
class DoubleNode
{
   String str;
   DoubleNode prev, next;
   
   DoubleNode(String str)
   {
      this.str = str;
      prev = null;
      next = null;
   }
   
   String getStr()
   {
      return str;
   }
   
   DoubleNode getNext()
   {
      return next;
   }
   
   void setNext(DoubleNode next)
   {
      this.next = next;
   }
   
   DoubleNode getPrev()
   {
      return prev;
   }
   
   void setPrev(DoubleNode prev)
   {
      this.prev = prev;
   }
   
}
