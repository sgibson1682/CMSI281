//A class that makes a singly-linked list of integers
//data can be prepended in, inserted at any given index, or removed from any given index
public class IntLinkedList {

      private Node head;
      private int  size;

     // the constructor
      IntLinkedList() {
         head = null;
         size = 0;
      }

      public int getSize() {
         return size;
      }

      public void prepend( int dataToAdd ) {
         Node currentHead = head;
         head = new Node( dataToAdd );
         head.next = currentHead;
         size++;
      }

      public void insertAt(int index, int val){
        if( (index > size) || (index < 0) ) {
           throw new IllegalArgumentException();
        }
        if(index == 0){
          this.prepend(val);
          return;
        }
        Node newData = new Node(val);
        Iterator it = new Iterator();
        for(int i = 0; i < index - 1; i++){
          it.next();
        }
        newData.next = it.currentNode.next;
        it.currentNode.next = newData;
        size++;
      }

      public void removeAt(int index){
        if( (index >= size) || (index < 0) ) {
           throw new IllegalArgumentException();
        }
        if(index == 0){
          this.head = head.next;
          size--;
          return;
        }
        Iterator it = new Iterator();
        for(int i = 0; i < index - 1; i++){
          it.next();
        }
        it.currentNode.next = it.currentNode.next.next;
        size--;
      }

      private class Node {

         int data;            // remember this is an IntLinkedList
         Node next;           // here's the self-referential part

         // constructor
         Node( int d ) {
            data = d;
            next = null;
         }
      }

      public Iterator getIteratorAt( int index ) {
         if( (index > size) || (index < 0) ) {
            throw new IllegalArgumentException();
         }
         Iterator it = new Iterator();
         while( index > 0 ) {
            it.next();
            index--;
         }
         return it;
      }

      public class Iterator {
         private Node currentNode;

         Iterator() {
            currentNode = head;
         }

         public void next() {
            if( currentNode == null ) {
               return;
            } else {
               currentNode = currentNode.next;
            }
         }

         public boolean hasNext() {
            return ((currentNode != null) && (currentNode.next != null));
         }

         public int getCurrentInt() {
            return currentNode.data;
         }

      }
   }
