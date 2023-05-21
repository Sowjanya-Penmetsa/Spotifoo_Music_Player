import java.util.ArrayList;
import java.util.List;

public class GetItemsFromData 
{
    //Create object to read data from data.txt
    ReadDataFromTextFile textData = new ReadDataFromTextFile();

    //This method returns list of all the songs
    public List<String> getSongs() 
    {
        List<List<String>> data = textData.getData();
        List<String> songsList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) 
        {
            String str = (data.get(i).get(0));
            if (!songsList.contains(str)) songsList.add(str);
        }
        return songsList;
    }

    // This method returns songs based on type (artists, albums and genres) and the value of the type.
    public List<String> getSongs(String type, String value) 
    {
        List<List<String>> data = textData.getData();
        List<String> songsList = new ArrayList<>();
        if (type.equalsIgnoreCase("artist"))
        {
            for (int i = 0; i < data.size(); i++) 
            {
                String artist;
                String song;
                artist = data.get(i).get(1);
                song = data.get(i).get(0);
                if ((artist.equalsIgnoreCase(value)) && (!songsList.contains(song))) 
                {
                    songsList.add(song);
                }
            }
            return songsList;
        } 
        else if (type.equalsIgnoreCase("albums")) 
        {
            for (int i = 0; i < data.size(); i++) 
            {
                String album;
                String song;
                album = data.get(i).get(2);
                song = data.get(i).get(0);
                if ((album.equalsIgnoreCase(value)) && (!songsList.contains(song))) 
                {
                    songsList.add(song);
                }
            }
            return songsList;
        } 
        else if (type.equalsIgnoreCase("genres")) 
        {
            for (int i = 0; i < data.size(); i++) 
            {
                String strGenres;
                String song;
                strGenres = data.get(i).get(3);
                song = data.get(i).get(0);
                if ((strGenres.equalsIgnoreCase(value)) && (!songsList.contains(song))) 
                {
                    songsList.add(song);
                }
            }
            return songsList;
        }
        return songsList;
    }


    //This method returns list of all the artists
    public List<String> getArtist() 
    {
        List<List<String>> data = textData.getData();
        List<String> artistList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++)
        {
            String str;
            str = (data.get(i).get(1));
            if (!artistList.contains(str)) artistList.add(str);
        }
        return artistList;
    }


    //This method returns list of all the albums
    public List<String> getAlbums() 
    {
        List<List<String>> data = textData.getData();
        List<String> albumList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) 
        {
            String str;
            str = (data.get(i).get(2));
            if (!albumList.contains(str)) albumList.add(str);
        }
        return albumList;

    }

    //This method returns list of all the genres
    public List<String> getGenres()
    {
        List<List<String>> data = textData.getData();
        List<String> genresList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) 
        {
            String str;
            str = (data.get(i).get(3));
            if (!genresList.contains(str)) genresList.add(str);
        }
        return genresList;
    }

    //This method returns mp3 file name and png file name of a particular song
    public List<String> getFilesForSong(String song)
    {
        List<List<String>> data = textData.getData();
        List<String> fileList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++)
        {
            String songString = data.get(i).get(0);
            String mp3 = data.get(i).get(4);
            String png = data.get(i).get(5);
            if (songString.equalsIgnoreCase(song))
            {
                if (!fileList.contains(mp3))
                {
                    fileList.add(mp3);
                }
                if (!fileList.contains(png)) 
                {
                    fileList.add(png);
                }
            }
        }
        return fileList;
    }

    //This method search song based on string input
    public List<String> searchSongs() {

        Display display = new Display();
        display.clearScreen();

        UserInput input = new UserInput();

        // All Songs list
        List<String> allSongList;
        GetItemsFromData allSongs = new GetItemsFromData();
        allSongList = allSongs.getSongs();

        // Searched son list based on search text
        List<String> searchedSongList = new ArrayList<>();

        while (searchedSongList.isEmpty()) 
        {
            String searchText = input.readText("Enter song name you want to search:");

            for (String element : allSongList) 
            {
                if (element.toLowerCase().contains(searchText.toLowerCase())) 
                {
                    searchedSongList.add(element);
                }
            }

            if (searchedSongList.isEmpty()) 
            {
                System.out.println(" No matching songs found, please try again");
            }
        }
        return searchedSongList;
    }
}