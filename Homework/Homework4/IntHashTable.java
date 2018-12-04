/*
*
*class that creates a hash tale for ints
*@Author Sam Gibson
*@Author Veda Ashok
*@Date 28 November 2018
*
*/
import java.util.*;
public class IntHashTable{
  private DataItem[] brown; //get it? HashBrown :)
  private int size;
  private DataItem nonItem;

  public  IntHashTable(int arraySize){
    size = 0;
    nonItem = new DataItem(-1);
    brown = new DataItem[arraySize];
  }

  class DataItem{
    private int data;

    public DataItem(int  val){
      data = val;
    }

    public int  getKey(){
      return data;
    }
  }

  /*
  *
  * Method to display the hash table
  *
  *@Date 28 November 2018
  *
  */
  public void displayTable(){
    System.out.print("Table: ");
    for(int j = 0; j < brown.length; j++) {
      if(brown[j] != null){
      System.out.print(brown[j].getKey() + " ");
      } else {
      System.out.print("** ");
      }
    }
      System.out.println("");
  }

  /*
  *
  * Method to hash the key into an index to insert/find it
  *
  *@param int key
  *@return int index for key
  *@Date 28 November 2018
  *
  */
  public int hashFunc(int key){
    int groupSize = (int)Math.log10(brown.length);
    String temp = Integer.toString(key);
    int hashVal = 0;
    int tempLength = temp.length();
    while(temp.length() > 0){
      String s = "";
      for(int j = 0; j < groupSize; j++){
        s += temp.charAt(j);
        temp = temp.substring(1);
      }
      hashVal += Integer.parseInt(s);
      if( (temp.length() <= groupSize) && (temp.length() > 0) ){
        hashVal += Integer.parseInt(temp);
        return hashVal % brown.length;
      }
    }
    return hashVal % brown.length;
  }

  /*
  *
  * Method to insert into the hash table
  *
  *@param int key
  *@Date 28 November 2018
  *
  */
  public void insert(int  key){
    DataItem item = new DataItem(key);
    size++;
    int hashVal = hashFunc(key);
    while( (brown[hashVal] != null) && (brown[hashVal].getKey() != -1 ) ){
      hashVal++;
      hashVal %= brown.length;
    }
    brown[hashVal] = item;
  }

  /*
  *
  * Method to delete a key from the table
  *
  *@param int key
  *@return DataItem of the deleted key
  *@Date 28 November 2018
  *
  */
  public DataItem delete(int  key){
    int hashVal = hashFunc(key);
    while(brown[hashVal] != null){
      if(brown[hashVal].getKey() == key){
        DataItem temp = brown[hashVal];
        brown[hashVal] = nonItem;
        size--;
        return temp;
      }
      hashVal++;
      hashVal %= brown.length;
    }
    return null;
  }

  /*
  *
  * Method to find a key in the table
  *
  *@param int key
  *@return DataItem with the respective key
  *@Date 28 November 2018
  *
  */
  public DataItem find(int  key){
    int hashVal = hashFunc(key);
    while(brown[hashVal] != null){
      if(brown[hashVal].getKey() == key){
        return brown[hashVal];
      }
      hashVal++;
      hashVal %= brown.length;
    }
    return null;
  }

  public static void main(String [] args){
    IntHashTable ht = new IntHashTable(20);
    ht.insert(4);
    ht.insert(22);
    ht.insert(468);
    ht.insert(7);
    ht.insert(99);
    ht.insert(345);
    ht.insert(12);
    ht.insert(634);
    ht.insert(857);
    ht.insert(71);
    ht.insert(32456);
    ht.displayTable();
    System.out.println();
    System.out.println(ht.find(4).getKey());
    System.out.println(ht.find(345).getKey());
    System.out.println(ht.find(12).getKey());
    System.out.println(ht.find(32456).getKey());
    System.out.println("removed: " + ht.delete(99).getKey());
    System.out.println("removed: " + ht.delete(345).getKey());
    System.out.println("removed: " + ht.delete(22).getKey());
    ht.displayTable();
    System.out.println(ht.find(345) == null);
    System.out.println("removed: " + ht.delete(7).getKey());
    System.out.println("removed: " + ht.delete(634).getKey());
    System.out.println("removed: " + ht.delete(71).getKey());
    System.out.println("removed: " + ht.delete(4).getKey());
    System.out.println("removed: " + ht.delete(12).getKey());
    System.out.println("removed: " + ht.delete(32456).getKey());
  }


}
