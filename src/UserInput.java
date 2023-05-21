import java.util.Scanner;

public class UserInput 
{
    private Scanner in;
    UserInput()
    {
      in = new Scanner(System.in);
    }

    // This method forces user to input only valid integer within required range
    public int readInteger(String promptMsg, String errorMsg, int low, int high)
    {
        int num = 0;
        String strInput;
        boolean valid = false;

        // Loop until user enters valid value
        while (!valid)
        {
            //prompt user for input
            System.out.print(promptMsg);
            //User input from keyboard
            strInput = in.nextLine();
            //try block to convert string to int
            try
            {
                num = Integer.parseInt(strInput);
                //check if the input is in valid range
                if(num>=low && num <= high)
                  valid=true;
                else
                    System.out.println(errorMsg);
            }
            catch(NumberFormatException e)
            {
                System.out.println(errorMsg);
            }
        }
        return num;
    }

    // This method returns text input for search
    public String readText(String promptMsg)
    {
        String strInput = null;
        //prompt user for input
        System.out.print(promptMsg);
        //User input from keyboard
        strInput = in.nextLine();
        while ((strInput.equals(" "))) {
            System.out.print("Invalid Entry, Please enter valid search value :");
            strInput = in.nextLine();
        }
        return strInput;
    }
}