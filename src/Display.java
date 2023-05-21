import java.util.List;
import java.io.IOException;

public class Display 
{
    public void printMenu(List<String> options, String menuType) 
    {

        // Method to clear the screen before displaying the menu everytime
        clearScreen();

        // Welcome message
        System.out.println("Welcome to the Spotifoo music player!");
        System.out.println();

        int i = 1;
        // If the menu is main menu it will only display the options
        if (menuType.equalsIgnoreCase("mainMenu"))
        {
            System.out.println("Main menu options:");
            for (String option : options) 
            {
                System.out.println("[" + i + "]" + " " + option);
                i++;
            }
        } 
        // If the menu is submenu along with options it will also give us the option to go back to main menu.
        else 
        {
            System.out.println(menuType);
            for (String option : options) 
            {
                System.out.println("[" + i + "]" + " " + option);
                i++;
            }
            System.out.println("[0] Go back to main menu");
        }
    }

    public void clearScreen() 
    {
        try 
        {
            if (System.getProperty("os.name").contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
            else 
            {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } 
        catch (IOException | InterruptedException e)
        {
            // Handle any exceptions that may occur
            e.printStackTrace();
        }
    }
}