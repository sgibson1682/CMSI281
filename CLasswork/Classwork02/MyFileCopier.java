import copiersupport.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyFileCopier {
  public static void main(String[] args) throws IOException {
    Scanner myInput = new Scanner(System.in);
    System.out.println("What file do you want to copy?");
    String fileName = myInput.nextLine();
    SourceFile sf = new SourceFile(fileName);
    String fileContents = sf.fileBuffer();
    TargetFile tf = new TargetFile(fileName, fileContents);
    tf.fileCopy();

  }
}
