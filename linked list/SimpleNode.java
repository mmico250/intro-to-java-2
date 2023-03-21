
class SimpleNode
{
   String str;
   SimpleNode next;
   
   SimpleNode(String str)
   {
      this.str = str;
      next = null;
   }
   
   String getStr()
   {
      return str;
   }
   
   SimpleNode getNext()
   {
      return next;
   }
   
   void setNext(SimpleNode next)
   {
      this.next = next;
   }
   
}
