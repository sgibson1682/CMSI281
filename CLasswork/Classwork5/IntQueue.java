//A class that makes a Queue which is capable of inserting items to the front of a linked list,
//and removing items from the end of the linked list. It can also look at the last item of the linked list
public class IntQueue {

      IntLinkedList myQueue;

      IntQueue() {
         myQueue = new IntLinkedList();         // constructor
      }

      public void enQueue( int itemToenQueue ) {
         myQueue.prepend( itemToenQueue );
      }

      public int peek() {
         return myQueue.getIteratorAt( myQueue.getSize() - 1 ).getCurrentInt();     // we use the iterator
      }

      public int deQueue() {
         return myQueue.removeAt( myQueue.getSize() - 1 );
      }

      public static void main( String[] args ) {
         IntQueue testQueue = new IntQueue();
         testQueue.enQueue( 19 );
         testQueue.enQueue( 23 );
         testQueue.enQueue( 29 );
         testQueue.enQueue( 31 );
         testQueue.enQueue( 37 );
         testQueue.enQueue( 41 );
         testQueue.enQueue( 43 );
         testQueue.enQueue( 47 );
         testQueue.enQueue( 51 );
         testQueue.enQueue( 57 );
         System.out.println( "The end of the Queue: " + testQueue.peek() );      // 19
         System.out.println( "Removing last thing: " + testQueue.deQueue() );         // 19 removed
         System.out.println( "The end of the Queue: " + testQueue.peek() );      // 23
         System.out.println( "Removing end thing: " + testQueue.deQueue() );         // 23 removed
         System.out.println( "The end of the Queue: " + testQueue.peek() );      // 29
         System.out.println( "Removing end thing: " + testQueue.deQueue() );         // 29 removed
         System.out.println( "The end of the Queue: " + testQueue.peek() );      // 31
         testQueue.enQueue( testQueue.deQueue() + testQueue.deQueue() );
         System.out.println( "The end of the Queue: " + testQueue.peek() );      // 41
      }

   }
