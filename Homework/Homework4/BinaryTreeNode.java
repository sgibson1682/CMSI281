/*
*
*class that creates a binary tree node
*@Author Sam Gibson
*@Author Veda Ashok
*@Date 28 November 2018
*
*/
public class BinaryTreeNode {

   private int data;
   private BinaryTreeNode left;
   private BinaryTreeNode right;

   public BinaryTreeNode( int d ) {
       data = d;
       left = null;
       right = null;
   }

   /*
   *
   * Method to add a child to a node
   *
   *@param int s
   *@param String child
   *@Date 28 November 2018
   *
   */
   public void add( int s, String child ) {
      child = child.toUpperCase();
      if( child.equals( "L" ) ) {
         left = new BinaryTreeNode( s );
      } else if( child.equals( "R" ) ) {
         right = new BinaryTreeNode( s );
      } else {
         throw new IllegalArgumentException();
      }
   }

   /*
   *
   * Method to return the left or right child of a binary tree node
   *
   *@param String child
   *@return BinaryTreeNode of child
   *@Date 28 November 2018
   *
   */
   public BinaryTreeNode getChild( String child ) {
      child = child.toUpperCase();
      if( child.equals("L") || child.equals("R") ) {
         return (child.equals("L") ? left : right);
      } else {}
         throw new IllegalArgumentException();
  }

   /*
   *
   * Method to get the data of the node
   *
   *@return int data
   *@Date 28 November 2018
   *
   */
   public int getString() {
       return data;
   }

   /*
   *
   * Method to traverse the tree in order and print out the data of each node
   *
   *@Date 28 November 2018
   *
   */
   public void inOrderTraversal(){
     if(left != null){
       left.inOrderTraversal();
     }
     System.out.println(this.data);
     if(right != null){
       right.inOrderTraversal();
     }
   }

    public static void main( String[] args ) {
         BinaryTreeNode root = new BinaryTreeNode( 374 );
         root.add( 7, "L" );
         root.add( 14, "R" );
         BinaryTreeNode one = root.getChild( "L" );
         BinaryTreeNode two = root.getChild( "R" );
         one.add( 75, "L" );
         one.add( 32, "R" );
         two.add( 2, "L" );
         two.add( 29, "R" );
         BinaryTreeNode six = two.getChild( "R" );
         six.add( 54, "L" );
         six.add( 8, "R" );
         root.inOrderTraversal();
    }
}
