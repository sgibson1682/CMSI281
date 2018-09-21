//A class to test the IntLinkedList class
public class IntLinkedListTester {

      public static void main( String[] args ) {
         IntLinkedList myList = new IntLinkedList();
         myList.prepend( 10 );
         myList.prepend( 9 );
         myList.prepend( 8 );
         myList.prepend( 7 );
         myList.prepend( 6 );
         myList.prepend(  4 );
         myList.prepend(  3 );
         myList.prepend(  2 );
         myList.prepend( 1 );
         IntLinkedList.Iterator myIt = myList.getIteratorAt( 0 );
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 2
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 3
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 5
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
         myIt = myList.getIteratorAt( 3 );
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 11
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 13
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 17
         myList.insertAt(0, 0);
         //myList.insertAt(11, 12);
         myList.insertAt(10, 11);
         myList.insertAt(5, 5);
         myIt = myList.getIteratorAt( 0 );
         System.out.println( myIt.getCurrentInt() == 0 );
         myIt = myList.getIteratorAt( 11 );
         System.out.println( myIt.getCurrentInt() == 11);
         myIt = myList.getIteratorAt( 5 );
         System.out.println( myIt.getCurrentInt() == 5);
         myList.removeAt(0);
         //myList.removeAt(11);
         myList.removeAt(10);
         System.out.println(myList.removeAt(5) == 6);
         myIt = myList.getIteratorAt( 0 );
         System.out.println( myIt.getCurrentInt() == 1);
         myIt = myList.getIteratorAt( 1 );
         System.out.println( myIt.getCurrentInt() != 1);
         myIt = myList.getIteratorAt( 5 );
         System.out.println( myIt.getCurrentInt() == 7);
         myIt = myList.getIteratorAt( 6 );
         System.out.println( myIt.getCurrentInt() != 7);
         myIt = myList.getIteratorAt( 8 );
         System.out.println( myIt.getCurrentInt() == 10);
      }
   }
