
class SortDoublyLinkedList
{
   public static void main(String[] args)
   {
      DoublyLinkedList list = new DoublyLinkedList();
      
      list.addFirst("Plum");
      list.addFirst("Grape");
      list.addFirst("Banana");
      list.addFirst("Pear");
      list.addFirst("Apple");
      list.addFirst("Kiwi");
      
      list.sort();
     
      list.printList();
      list.printReverse();
   }
}
