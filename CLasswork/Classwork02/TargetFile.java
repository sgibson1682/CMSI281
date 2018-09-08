//Class that can turn strings into files
package copiersupport;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TargetFile {
  private String fileName = "";
  private String fileContents = "";

  public TargetFile(String fileName, String fileContents) throws IOException{
    this.fileName = fileName + ".copy";
    this.fileContents = fileContents;
  }

  public void fileCopy() throws IOException{
    FileWriter out = new FileWriter(this.fileName);
    int c = 0;
    while (c < fileContents.length()) {
      out.write(fileContents.charAt(c));
      c = c + 1;
    }
    out.close();
  }

}
