//A class to test the HighArray class
class HighArrayApp {
  public static void main(String[] args){
    int maxSize = 100;
    HighArray arr;
    HighArray arr2;
    arr = new HighArray(maxSize);
    arr2 = new HighArray(maxSize);
    arr.insert(77);
    arr.insert(99);
    arr.insert(44);
    arr.insert(55);
    arr.insert(22);
    arr.insert(88);
    arr.insert(11);
    arr.insert(00);
    arr.insert(66);
    arr.insert(33);
    arr.display();
    int searchKey = 35;
    if( arr.find(searchKey) ){
  System.out.println("Found" + searchKey);
  }
  else {
   System.out.println("Can’t find " + searchKey);
  }
  arr.delete(00);
  arr.delete(55);
  arr.delete(99);
  System.out.println(arr.getMax() == 88);
  arr.delete(88);
  System.out.println(arr.getMax() == 77);
  arr.insert(101);
  System.out.println(arr.getMax() == 101);
  arr.insert(2);
  System.out.println(arr.getMax() == 101);
  arr.insert(999);
  System.out.println(arr.getMax() == 999);
  arr.noDups();
  arr.display();
  System.out.println(arr2.getMax() == -1);
  arr2.insert(4);
  arr2.noDups();
  arr2.display();
  arr2.insert(4);
  arr2.insert(4);
  arr2.insert(4);
  arr2.insert(4);
  arr2.noDups();
  arr2.display();
  arr2.insert(4);
  arr2.insert(4);
  arr2.insert(4);
  arr2.insert(5);
  arr2.insert(7);
  arr2.insert(5);
  arr2.insert(8);
  arr2.noDups();
  arr2.display();
  }

}
