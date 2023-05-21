import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadDataFromTextFile
{
    static int rows;
    private static Scanner file;

    public List<List<String>> getData() 
    {
        //2d  array list for reading from file
        List<List<String>> data = new ArrayList<>();

        String currentDirectory = System.getProperty("user.dir");
        String parentDirectory = new File(currentDirectory).getParent();

        try 
        {
            file = new Scanner(new File(parentDirectory + "//assets//data.txt"));
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println(e);
        }

        while (file.hasNextLine())
        {
            ArrayList<String> line = new ArrayList<>();
            final String nextLine = file.nextLine();
            final String[] items = nextLine.split(",");

            for (int i = 0; i < items.length; i++) 
            {
                line.add(items[i]);
            }
            data.add(line);
            rows++;
            Arrays.fill(items, null); // to clear out the 'items' array
        }
        return data;
    }
}
