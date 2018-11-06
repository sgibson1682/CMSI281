/*
*
*class that contains methods used to sort an array on integers
*@Author Sam Gibson
*@Author Veda Ashok
*@Date 7 November 2018
*
*/
public class IntSorter{

  /*
  *
  * Method to swap the indices of two values in an array
  *
  *@param int index1
  *@param int index2
  *@param int[] a
  *@Author Sam Gibson
  *@Author Veda Ashok
  *@Date 7 November 2018
  *
  */
  public static void swapIntsAt( int index1, int index2, int[] a ) {
      int temp = a[index1];
      a[index1] = a[index2];
      a[index2] = temp;
   }

   /*
   *Method to check if an array is sorted
   *
   *@param int[] a
   *@return boolean true if sorted
   *@Author Sam Gibson
   *@Author Veda Ashok
   *@Date 7 November 2018
   *
   */
   public static boolean isSorted(int[] a){
     for(int i = 0; i < a.length - 1; i++){
       if(a[i] > a[i + 1]){
         return false;
       }
     }
     return true;
   }

   /*
   *Method to sort an array of integers using the odd-even algorithm
   *
   *@param int[] a
   *@Author Sam Gibson
   *@Author Veda Ashok
   *@Date 7 November 2018
   *
   */
  public static void oddEvenSort(int[] a){
    while(!isSorted(a)){
      for(int i = 1; i < a.length - 1; i += 2){
        if(a[i] > a[i + 1]){
          swapIntsAt(i, i + 1, a);
        }
      }
      for(int i = 0; i < a.length - 1; i += 2){
        if(a[i] > a[i + 1]){
          swapIntsAt(i, i + 1, a);
        }
      }
    }
  }
  public static void main( String[] args ) {
    System.out.println();
    System.out.println();
    System.out.println("--------------------- Test 1 ----------------------");
    System.out.println();
    System.out.println();
    int[] arrayToSort = {5,3,23,7,4,2,3,554,32,3,453,2};
    oddEvenSort(arrayToSort);
    for(int i = 0; i < arrayToSort.length; i ++){
      System.out.print(arrayToSort[i] + ", ");
    }
    System.out.println();
    System.out.println();
    System.out.println("--------------------- Test 2 ----------------------");
    System.out.println();
    System.out.println();
    int[] arrayToSort1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    oddEvenSort(arrayToSort1);
    for(int i = 0; i < arrayToSort1.length; i ++){
      System.out.print(arrayToSort1[i] + ", ");
    }
    System.out.println();
    System.out.println();
    System.out.println("--------------------- Test 3 ----------------------");
    System.out.println();
    System.out.println();
    int[] arrayToSort2 = {700, 50000, 30, 2, 80, 9, 5};
    oddEvenSort(arrayToSort2);
    for(int i = 0; i < arrayToSort2.length; i ++){
      System.out.print(arrayToSort2[i] + ", ");
    }
  }

}
