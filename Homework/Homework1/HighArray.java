// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
class HighArray {
private long[] a;
private int nElems;

public HighArray(int max) {
  a = new long[max];
  nElems = 0;
}

public boolean find(long searchKey){
  int j;
  for(j=0; j<nElems; j++) {
    if(a[j] == searchKey){
      break;
    }
  }
  if(j == nElems){
    return false;
  } else {
      return true;
  }
}

public void insert(long value) {
  a[nElems] = value;
  nElems++;
}


public boolean delete(long value) {
  int j;
  for(j=0; j<nElems; j++){
    if( value == a[j] ) {
      break;
    }
  }
  if(j==nElems){
    return false;
  }
  else {
    for(int k=j; k<nElems; k++) a[k] = a[k+1];
      nElems--; return true;
    }
}

public void display(){
  for(int j=0; j<nElems; j++) {
    System.out.print(a[j] + " ");
  }
  System.out.println("");
}

public long getMax(){
  if(nElems == 0){
    return -1;
  }
  long max = a[0];
  for(int i = 1; i < nElems; i++){
    if(a[i] > max){
      max = a[i];
    }
  }
  return max;
}

public void noDups(){
  int nullCounter = 0;
  for(int i = 0; i < nElems; i++){
    if(a[i] != -1){
      for(int j = i + 1; j < nElems; j++){
        if(a[i] == a[j]){
          a[j] = -1;
          nullCounter++;
        }
      }
    }
  }
  long[] dupeless = new long[a.length];
  int dupelessIndex = 0;
  for(int i = 0; i < nElems; i++){
    if(a[i] != -1){
      dupeless[dupelessIndex] = a[i];
      dupelessIndex++;
    }
  }
  a = dupeless;
  nElems -= nullCounter;
}

}
