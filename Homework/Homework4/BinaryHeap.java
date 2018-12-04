import java.util.*;
public class BinaryHeap {

      private ArrayList<HeapNode> uriah;
      private int size;

      BinaryHeap() {
         uriah = new ArrayList<HeapNode>();
         size = 0;
      }

  /*
  * First, a HeapNode class, which is basically just a
  *  wrapper around an "int", but as a node we can use in
  *  a heap structure
  */
  class HeapNode {
    private int data;
      // constructor
        public HeapNode( int key ) {
              data = key;
        }

        // get the data value   
        public int getKey() {
            return data;
        }

        // set the data value
        public void setKey( int value ) {
            data = value;
        }
  }

     // First some low-hanging fruit; let's do the traversal helpers
     //  that do the indexing operations we'll need to use to find
     //  stuff in the heap
      public HeapNode getParent( int index ) {
         return uriah.get( (index - 1) / 2 );
      }

      public HeapNode getChild( int index, char child ) {
         int result = (index * 2) + 1;
         if( Character.toUpperCase( child ) == 'R') {   // make sure we're case insensitive!
            result++;
         }
         return uriah.get( result );
      }

     // this just prints the array values; it's left to the observer to figure out
     //  which HeapNode is which, in terms of parent and child
      public void print() {
         for( int i = 0; i < size; i++ ) {
            System.out.print( "[" + uriah.get( i ).getKey() + "]" );
         }
      }

     // Now we can handle insertions.  ArrayList has a nice "add" method
     //  that makes things easy.  We *DO* have to deal with the primitive
     //  to Object situation, but that's trivial...
      public void insert( int value ) {
         uriah.add( new HeapNode( value ) );
         bubbleUp( size );                 // WOW that was easy!
         size++;
      }

      public HeapNode remove(){
        HeapNode root = uriah.get(0);
        uriah.set(0, uriah.get(size - 1));
        size--;
        trickleDown(0);
        return root;
      }

      public void trickleDown(int index){
          int largerChild;
          HeapNode top = uriah.get(index);
          int leftChild = 2*index + 1;
          int rightChild = leftChild + 1;
          if( leftChild > size - 1 || rightChild > size - 1 ){
            return;
          }
          if(uriah.get(leftChild).getKey() > uriah.get(rightChild).getKey()){
            largerChild = leftChild;
          } else {
            largerChild = rightChild;
          }
          if(uriah.get(largerChild).getKey() > top.getKey()){
            HeapNode temp = new HeapNode(top.getKey());
            uriah.set(index, uriah.get(largerChild));
            uriah.set(largerChild, temp);
            trickleDown(largerChild);
        }
      }

     // Here's the bubble method that does the swappy thang....
     //  Whaddya mean?!  OF COURSE it's recursive!  Fuggeddaboutit...
      public void bubbleUp( int index ) {
         if( index == 0 ) {   // base case:
            return;           //  we're already at the root, so we're done
         }

         HeapNode parent = getParent( index );
         int parentIndex = (index -1) / 2;
         if( uriah.get( parentIndex ).getKey() < uriah.get( index ).getKey() ) {
            HeapNode temp = uriah.get( index );
            uriah.set( index,  uriah.get( parentIndex ) );
            uriah.set( parentIndex, temp );
            bubbleUp( parentIndex );
         }
      }

      public HeapNode minNode(){
        HeapNode minNode = uriah.get(size/2);
        for(int i = size/2 + 1; i < size; i++){
          if(uriah.get(i).getKey() < minNode.getKey()){
            minNode = uriah.get(i);
          }
        }
        return minNode;
      }

      public int getSize(){
        return size;
      }

      public void printHeap(){
        for(int i = 0; i < size; i++){
          System.out.println(uriah.get(i).getKey());
        }
      }

      public static void main( String[] args ) {

         // YOUR TEST CODE GOES HERE

      }
   }
