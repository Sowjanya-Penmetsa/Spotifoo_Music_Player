"Spotifoo_Music_Player" 

# Git clone (download the soruce code)
$ git clone https://github.com/Sowjanya-Penmetsa/Spotifoo_Music_Player.git
cd Spotifoo_Music_Player
cd src

# To compile the code
javac Main.java

# To run the code
java Main

# Steps to create jar file
cd Spotifoo_Music_Player
javac -d bin src/*.java

cd src

create manifest.txt file

# Command to create jar file
jar cvfm musicplayer.jar manifest.txt -C bin .

# Command to run a jar file
java -jar musicplayer.jar





