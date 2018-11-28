/*
*
*class that creates priority queue by implementing a heap
*@Author Sam Gibson
*@Author Veda Ashok
*@Date 28 November 2018
*
*/
public class PriorityQ{
  private BinaryHeap bh;

  public PriorityQ(){
    bh = new BinaryHeap();
  }

  /*
  *
  * Method to insert items into the Q
  *
  *@param int item
  *@Date 28 November 2018
  *
  */
  public void insert(int item){
    bh.insert(item);
  }

  /*
  *
  * Method to remove the largest item from the Q
  *
  *@return int key of removed value
  *@Date 28 November 2018
  *
  */
  public int remove(){
    return bh.remove().getKey();
  }

  /*
  *
  * Method to check if the Q is empty
  *
  *@return boolean true if the Q is empty
  *@Date 28 November 2018
  *
  */
  public boolean isEmpty(){
    return bh.getSize() == 0;
  }

  /*
  *
  * Method to see the smallest value in the Q
  *
  *@return int smallest key
  *@Date 28 November 2018
  *
  */
  public int peekMin(){
    return bh.minNode().getKey();
  }

  /*
  *
  * Method to print the Q
  *
  *@Date 28 November 2018
  *
  */
  public void printQ(){
    bh.printHeap();
  }

  public static void main (String[] args){
    PriorityQ q = new PriorityQ();
    q.insert(5);
    q.insert(6);
    q.insert(7);
    q.insert(8);
    q.insert(9);
    q.insert(2);
    q.insert(1);
    q.insert(13);
    q.insert(55);
    q.insert(555);
    q.printQ();
    System.out.println("Minimum is: " + q.peekMin());
    System.out.println( "removed " + q.remove());
    q.printQ();
    System.out.println( "removed " + q.remove());
    System.out.println( "removed " + q.remove());
    System.out.println( "removed " + q.remove());
    System.out.println( "removed " + q.remove());
    q.printQ();
    System.out.println( "removed " + q.remove());
    System.out.println( "removed " + q.remove());
    System.out.println( "removed " + q.remove());
    System.out.println( "removed " + q.remove());
    System.out.println( "removed " + q.remove());
    q.printQ();

  }
}
