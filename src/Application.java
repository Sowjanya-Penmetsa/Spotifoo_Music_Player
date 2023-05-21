import java.util.ArrayList;
import java.util.List;

public class Application
{
    Display display = new Display();
    Player player = new Player();
    GetItemsFromData item = new GetItemsFromData();
    Boolean Exit = false;

    //main menu
    public void mainMenu() 
    {
        // Options for main menu
        List<String> mainMenuOptions = new ArrayList<>();
        mainMenuOptions.add("Songs");
        mainMenuOptions.add("Artists");
        mainMenuOptions.add("Albums");
        mainMenuOptions.add("Genres");
        mainMenuOptions.add("Search");

        while (!Exit) 
        {
            // Method to display the main menu
            display.printMenu(mainMenuOptions, "mainMenu");

            // UserInput class for the validation of user input
            UserInput input = new UserInput();

            //Assign user input to choice variable using the readInteger function
            int choice = input.readInteger("Choose an option and press enter: ", " Not a valid option", 1, 5);

            // Based on the value entered by the user respective menu will be displayed
            if (choice == 1) {
                songsMenu();
            } 
            else if (choice == 2) {
                artistsMenu();
            } 
            else if (choice == 3) {
                albumsMenu();
            } 
            else if (choice == 4) {
                genresMenu();
            } 
            else if (choice == 5) {
                searchMenu();
            }
        }
    }

    public void songsMenu() 
    {
        List<String> songList = item.getSongs();
        Exit = player.startPlay(songList);
    }

    public void artistsMenu() 
    {
        List<String> artistList = item.getArtist();
        //Display artist menu
        display.printMenu(artistList, "Available Artists:");

        // UserInput class for the validation of user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an artist :", "Choose a valid artist or enter 0 to go back", 0, artistList.size());

        if (choice != 0) 
        {
            List<String> songList = item.getSongs("artist", artistList.get(choice - 1));
            Exit = player.startPlay(songList);
        }
    }

    public void albumsMenu() 
    {
        List<String> albumsList = item.getAlbums();

        //Display album menu
        display.printMenu(albumsList, "Available Albums:");

        // UserInput class for the validation of user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an album :", "Choose a valid album or enter 0 to go back", 0, albumsList.size());

        if (choice != 0) 
        {
            List<String> songList = item.getSongs("albums", albumsList.get(choice - 1));
            Exit = player.startPlay(songList);
        }
    }

    public void genresMenu() 
    {
        List<String> genresList = item.getGenres();

        //Display menu
        display.printMenu(genresList, "Available Genres:");

        // UserInput class for the validation of user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an genres :", "Choose a valid genres or enter 0 to go back", 0, genresList.size());

        if (choice != 0) 
        {
            List<String> songList = item.getSongs("genres", genresList.get(choice - 1));
            Exit = player.startPlay(songList);
        }
    }

    public void searchMenu() 
    {
        List<String> songList = item.searchSongs();
        display.printMenu(songList, "Search for a song:");
        Exit = player.startPlay(songList);
    }
}    
