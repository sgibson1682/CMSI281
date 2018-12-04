/*
*
*class that creates a hash tale for strings
*@Author Sam Gibson
*@Author Veda Ashok
*@Date 28 November 2018
*
*/
import java.util.*;
public class StringHashTable{
  private DataItem[] brown; //get it? HashBrown :)
  private int size;
  private DataItem nonItem;

  public StringHashTable(int arraySize){
    size = 0;
    nonItem = new DataItem("-1");
    brown = new DataItem[arraySize];
  }

  class DataItem{
    private String data;

    public DataItem(String val){
      data = val;
    }

    public String getKey(){
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
  *@param String key
  *@return int index for key
  *@Date 28 November 2018
  *
  */
  public int hashFunc(String key){
    System.out.println(key + ":");
    long hashVal = 0;
    long pow27 = 1;
    for(int i = key.length() - 1; i >= 0; i--){
      long letter = key.charAt(i) - 96;
      hashVal += pow27 * letter;
      pow27 *= 27;
    }
    hashVal %= (long)brown.length;
    return (int)hashVal;
  }

  /*
  *
  * Method to insert into the hash table
  *
  *@param String key
  *@Date 28 November 2018
  *
  */
  public void insert(String key){
    DataItem item = new DataItem(key);
    size++;
    int hashVal = hashFunc(key);
    while( (brown[hashVal] != null) && (!brown[hashVal].getKey().equals("-1") ) ){
      hashVal++;
      hashVal %= brown.length;
    }
    brown[hashVal] = item;
  }

  /*
  *
  * Method to delete a key from the table
  *
  *@param String key
  *@return DataItem of the deleted key
  *@Date 28 November 2018
  *
  */
  public DataItem delete(String key){
    int hashVal = hashFunc(key);
    while(brown[hashVal] != null){
      if(brown[hashVal].getKey().equals(key)){
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
  *@param String key
  *@return DataItem with the respective key
  *@Date 28 November 2018
  *
  */
  public DataItem find(String key){
    int hashVal = hashFunc(key);
    while(brown[hashVal] != null){
      if(brown[hashVal].getKey().equals(key)){
        return brown[hashVal];
      }
      hashVal++;
      hashVal %= brown.length;
    }
    return null;
  }

  public static void main(String[] args){
    StringHashTable ht = new StringHashTable(20);
    ht.insert("poachedeggs");
    ht.insert("toast");
    ht.insert("pancakes");
    ht.insert("tatertots");
    ht.insert("coffee");
    ht.insert("waffles");
    ht.insert("syrup");
    ht.insert("overeasy");
    ht.insert("sunnysideup");
    ht.displayTable();
    System.out.println();
    System.out.println(ht.find("toast").getKey());
    System.out.println(ht.find("coffee").getKey());
    System.out.println(ht.find("waffles").getKey());
    System.out.println(ht.find("syrup").getKey());
    System.out.println("removed: " + ht.delete("sunnysideup").getKey());
    System.out.println("removed: " + ht.delete("tatertots").getKey());
    System.out.println("removed: " + ht.delete("poachedeggs").getKey());
    ht.displayTable();
    System.out.println("removed: " + ht.delete("toast").getKey());
    System.out.println("removed: " + ht.delete("pancakes").getKey());
    System.out.println("removed: " + ht.delete("coffee").getKey());
    System.out.println("removed: " + ht.delete("waffles").getKey());
    System.out.println("removed: " + ht.delete("syrup").getKey());
    System.out.println("removed: " + ht.delete("overeasy").getKey());
  }


}
