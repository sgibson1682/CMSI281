// A class that makes a list that can have items added to an index in the list and increase the size of the list as needed
public class IntList implements IntListInterface {
      private int[] theList;
      private int   size;

      private static final int STARTING_SIZE = 19;    // defines starting size; don't worry, we'll deal

      public IntList() {                        // doesn't HAVE to be declared public, but doesn't hurt
         theList = new int[STARTING_SIZE];
         size = 0;
      }

      public int getValueAtIndex( int index ) throws ArrayIndexOutOfBoundsException {
         if( size == 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The list is empty!" );   // maybe not the best...
         } else if( !checkIndex(index) ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is not valid" );
         } else {
            return theList[index];
         }
      }

      public boolean append( int valueToAdd ) {
         if( size < theList.length ) {
            theList[size] = valueToAdd;
            size++;
            return true;
         } else {
            expandTheList();
            theList[size] = valueToAdd;
            size++;
            return true;
         }
      }

      // we've gotta have this to actually get things to compile
      public boolean insertValueAtIndex( int value, int index ) {
        if( size >= theList.length ) {
           expandTheList();
        } else if( index > size ) {
           size = index;
        } else if( index < 0 ) {
           throw new ArrayIndexOutOfBoundsException( "The index value is too small");
        } else {
          size++;
          for(int i = size - 1; i > index; i--){
            theList[i] = theList[i-1];
          }
          theList[index] = value;
        }
        return true;
      }

      public int removeValueAtIndex( int index ) throws ArrayIndexOutOfBoundsException {
         int value = theList[index];
         if( size == 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The list is empty!" );   // maybe not the best...
         } else if( !checkIndex(index) ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is not valid" );
         } else {
            holeFiller( index );
         }
         return value;
      }

      public boolean prepend(int value){
        insertValueAtIndex(value, 0);
        return true;
      }

      private void expandTheList(){
        int[] theNewList = new int[size + STARTING_SIZE];
        for(int i = 0; i < theList.length; i++){
          theNewList[i] = theList[i];
        }
        theList = theNewList;
      }

      private void holeFiller( int index ) {
         for( int i = index; i < size - 1; i++ ) {
            theList[i] = theList[i+1];
         }
         size--;
      }

      private boolean checkIndex(int index) {
        if(index >= size){
          return false;
        }
        else if(index < 0){
          return false;
        } else {
          return true;
        }
      }

      public static void main( String[] args ) {
         IntList list = new IntList();
         list.append( 2 );
         list.append( 3 );
         list.append( 5 );
         list.append( 7 );
         System.out.println( list.getValueAtIndex( 3 ) );   // should return the value 7
         list.append( 11 );
         list.append( 13 );
         list.append( 17 );
         list.append( 19 );
         System.out.println( list.getValueAtIndex( 7 ) );      // should return the value 19
         System.out.println( list.removeValueAtIndex( 3 ) );   // should return the value 7
         System.out.println( list.getValueAtIndex( 3 ) );      // should return the value 11
         //System.out.println( list.getValueAtIndex( 18 ) );     // just to see what happens
         list.insertValueAtIndex(9, 4);
         System.out.println( list.getValueAtIndex( 4 ) );
         System.out.println( list.getValueAtIndex( 6 ) );
         list.prepend(1);
         System.out.println( list.getValueAtIndex( 0 ) );
         System.out.println( list.getValueAtIndex( 7 ) );


      }
   }
