import java.util.List;

public class Player 
{
    static final String CHOOSESONG = "Choose a song to play or select 0 to go back:";
    static final String CANNOTPLAYSONG = " Cannot play this song, choose another song";
    static final String CHOOSEVALIDSONG = " Choose a valid song or enter 0 to go back";
    Boolean Exit = false;
    Display display = new Display();

    public boolean startPlay(List<String> songList) 
    {
        GetItemsFromData item = new GetItemsFromData();

        //Print menu
        display.printMenu(songList, "Available Songs:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger(CHOOSESONG, CHOOSEVALIDSONG, 0, songList.size());

        if (choice != 0) {

            List<String> mp3png = item.getFilesForSong(songList.get(choice - 1));

            OpenSongImageFile open = new OpenSongImageFile();
            boolean playSuccess = open.openMP3PNG(mp3png.get(0), mp3png.get(1));

            Exit = true;
            while (!playSuccess) 
            {
                System.out.println(CANNOTPLAYSONG);
                choice = input.readInteger(CHOOSESONG, CHOOSEVALIDSONG, 0, songList.size());
                if (choice != 0) {
                    mp3png = item.getFilesForSong(songList.get(choice - 1));
                    playSuccess = open.openMP3PNG(mp3png.get(0), mp3png.get(1));
                } else {
                    Exit = false;
                    break;
                }
            }
        }
        return Exit;
    }
}