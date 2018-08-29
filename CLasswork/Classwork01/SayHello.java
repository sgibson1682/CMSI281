import java.util.Scanner;
public class SayHello {
  public static void main(String[] args) {
    Scanner myInput = new Scanner(System.in);
    System.out.println("What is your name?");
    String inputName = myInput.nextLine();
    System.out.println("Hello, " + inputName);
  }
}
