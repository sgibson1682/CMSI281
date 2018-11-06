import java.util.*;
/*
*This Program simulates the Simon game using Strings
*
*@Author Sam Gibson
*@Author Veda Ashok
*@Date 7 November 2018
*
*/
public class Simon{
  private String[] colors = new String[4];
  private String sequence;

  public Simon(){
    colors[0] = "R";
    colors[1] = "G";
    colors[2] = "Y";
    colors[3] = "B";
    sequence = "";
  }

  /*
  *newColor method randomly generates a color represented by a character and adds the color to the sequence
  *
  *@Author Sam Gibson
  *@Author Veda Ashok
  *@Date 7 November 2018
  *
  */
  public void newColor(){
    int colorIndex = (int)(Math.random()* 4);
    System.out.println(colors[colorIndex]);
    sequence += colors[colorIndex];
  }


  /*
  *
  *isMatch method takes in a parameter for the sequence that user entered, and returns true if it matches the generated sequence
  *
  *@param String userString
  @return boolean true if userString and sequence are the same
  *@Author Sam Gibson
  *@Author Veda Ashok
  *@Date 7 November 2018
  *
  */
  public boolean isAMatch(String userString){
    return userString.equals(sequence);
  }


  /*
  *
  *play method runs the game in the console
  *@Author Sam Gibson
  *@Author Veda Ashok
  *@Date 7 November 2018
  *
  */
  public void play(){
    Scanner input = new Scanner(System.in);
    this.newColor();
    System.out.println("enter the sequence of colors: ");
    String userString = input.nextLine().toUpperCase();
    System.out.println(userString);
    if (!userString.equals("R") && !userString.equals("G") && !userString.equals("B") && !userString.equals("Y")){
      System.out.println("That's not a color. Please input a real color ");
      userString = input.nextLine().toUpperCase();
    }
    while(this.isAMatch(userString)){
      this.newColor();
      System.out.println("enter the sequence of colors: ");
      userString = input.nextLine().toUpperCase();
      System.out.println(userString);
      if (!userString.equals("R") && !userString.equals("G") && !userString.equals("B") && !userString.equals("Y")){
        System.out.println("That's not a color. Please input a real color ");
        userString = input.nextLine().toUpperCase();
      }
    }
  }

  public static void main( String[] args ){
    String playAgain = "Y";
    while(playAgain.equals("Y")){
      Simon s = new Simon();
      s.play();
      System.out.println("you lost, would you like to play again? Y/N ");
      Scanner replay = new Scanner(System.in);
      playAgain = replay.nextLine().toUpperCase();
    }
  }
}
