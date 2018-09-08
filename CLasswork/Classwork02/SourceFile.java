/* Class that takes a file name as a string as input, and buffers the file into a string*/
package copiersupport;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class SourceFile {
   private String fileName = "";
   private String fileContents = "";

  public SourceFile(String fileName)  throws IOException{

    this.fileName = fileName;
    FileReader in = new FileReader(this.fileName);
    int c;
    while ((c = in.read()) != -1) {
      fileContents += (char)c;
    }
    in.close();
  }


  public String fileBuffer(){
    return fileContents;
  }



}
