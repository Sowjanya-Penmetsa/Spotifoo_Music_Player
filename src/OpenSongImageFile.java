import java.awt.*;
import java.io.File;


public class OpenSongImageFile {

    // This methods plays song and also displays the image
    public boolean openMP3PNG(String mp3, String png) {

        boolean playsuccess = false;
        final String ERROR_MSG = "Not Supported";
        final String CURRENT_DIR = System.getProperty("user.dir");;
        final String PARENT_DIR = new File(CURRENT_DIR).getParent();
        //Generate file paths
        String pathToMp3 = PARENT_DIR + "/assets/songs/" + mp3;
        String pathToPng = PARENT_DIR + "/assets/albums/" + png;

        //Default image file path
        String pathToDefaultimage = PARENT_DIR + "/assets/no-picture.png";

        try {
            //constructor of file class having file as argument
            File song = new File(pathToMp3);

            //To get the file extention (.mp3)
            String fileExt = getFileExtension(song);

            File image = new File(pathToPng);
            File defaultImage = new File(pathToDefaultimage);

            if (song.exists() && fileExt.equalsIgnoreCase(".mp3")) {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(song);
                System.out.println(" playing song..");
                playsuccess = true;
                Thread.sleep(1000);
                if (image.exists()) {
                    desktop.open(image);
                } else
                    desktop.open(defaultImage);
            }
        } catch (Exception e) {
        }
        return playsuccess;
    }

    private String getFileExtension(File file)
    {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}