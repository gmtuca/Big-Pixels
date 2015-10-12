import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.io.BufferedReader;
import java.io.FileReader;

public class MessageGUI extends JFrame
{
  public JPanel[][] grid;
  public JLabel[][] imageLabels;

  int sizeX, sizeY;
  
  public MessageGUI() throws Exception
  {
    sizeX = 8;
    sizeY = 9;

    grid = new JPanel[sizeY][sizeX];
    setTitle("Message");
    Container contents = getContentPane();
    contents.setLayout(new GridLayout(sizeY , sizeX));
    contents.setPreferredSize(new Dimension(sizeX * 100 , sizeY * 100));

    for(int y = 0; y < sizeY; y++)
      for(int x = 0; x < sizeX; x++)
      {
        grid[y][x] = new JPanel(new BorderLayout());
        grid[y][x].setSize(30,30);
        setWhite(x,y);
        contents.add(grid[y][x]);
      }//for

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }//constructor
    
  public void setBlack(int x, int y) throws Exception
  {
    if(isInside(x,y))
      grid[y][x].setBackground(Color.BLACK);
    else
      throw new Exception("HOMERUN: out of the field");
  }//setBlack

  public void setWhite(int x, int y) throws Exception
  {
    if(isInside(x,y))
      grid[y][x].setBackground(Color.WHITE);
    else
      throw new Exception("HOMERUN: out of the field");
  }//setWhite

  public void resetColors()
  {

  }//resetColors
  
  public boolean isInside(int x, int y)
  {
   return x < sizeX && y < sizeY && x >= 0 && y >= 0;
  }//isInside

  public void display(BufferedReader input) throws Exception
  {
    String line;
    int lineNumber = 1;
    while((line = input.readLine()) != null)
    {
      lineNumber++;
      char[] charArray = line.toCharArray();

      for(int y = 0; y < charArray.length; y++)
      {
        if(charArray[y] == '#')
          setBlack(y + 1,lineNumber);
        else
          setWhite(y + 1,lineNumber);
      }//for
    }//while
    
    input.close();
  }//display

}//class
