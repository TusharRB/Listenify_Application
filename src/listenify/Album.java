package listenify;
import java.util.*;

public class Album {

    public String albumName;
    public String artistName;

    public List<Song> songList;

    //constructor work -> Initialize the song attribute or list
    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;

        this.songList = new ArrayList<>();
    }

    public boolean findSongToAlbum(String title){
        // Iterate over the songList
        //each song with title

        for(Song song:songList){

            if((song.title).compareTo(title) == 0){

                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title , double duration){

        // check song is present then we will not add it
        // otherwise we will create new song object and add it to the playlist

        if(findSongToAlbum(title) == true){

            return "Song is Already Present";

        }
        else{
            // I need to create song object first then i will added

            Song newSong = new Song(title,duration);

            songList.add(newSong);

            return "New Song Added Successfully";
        }
    }

    public String addSongToPlayList(int trackNo, LinkedList<Song> playList){

        // Track no is a no in a songList

        // Track No : 1,2,3,4....
        // Indices  : 0,1,2,3....

        int index = trackNo - 1;


        // checking for Validation of index

        if(index > 0  && index < songList.size()){

            Song song = this.songList.get(index);

            playList.add(song);

            return "Song Added Successfully";

        }
        return "Invalid Track No";
    }

    // Method OverLoading

    public String addSongToPlayList(String title,LinkedList<Song> playList){

        // I need to find out that song with that title
        // and put it to the playList

        for(Song song:songList){

            if(song.title == title){

                playList.add(song);

                return "Song has been Added Successfully";
            }
        }
        return "Song does not found";
    }
}
