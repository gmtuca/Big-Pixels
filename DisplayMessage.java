import java.io.BufferedReader;
import java.io.FileReader;

public class DisplayMessage
{
  public static void main(String[] args) throws Exception
  {
    MessageGUI msgGUI = new MessageGUI();
    msgGUI.display(convertCharToBR(args[0].charAt(0)));
  }//main

  public static BufferedReader convertCharToBR(char c) throws Exception
  {
    return new BufferedReader(new FileReader("Database/" + c));
  }//convert
}//class
