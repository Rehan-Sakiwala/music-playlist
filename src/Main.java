import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        Album album1=new Album("Tadipaar","Mc Stan");
        album1.addSongToAlbum("Astagfirullah",4.05);
        album1.addSongToAlbum("Amin",3.54);
        album1.addSongToAlbum("Insaan",2.33);

        Album album2=new Album("Arijit Era","Arijit Singh");
        album2.addSongToAlbum("Kesariyan",4.12);
        album2.addSongToAlbum("Jeeena Jeena",3.52);
        album2.addSongToAlbum("Gerua",6);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album2.findSong("Gerua"));

        LinkedList<Song> myPlaylist=new LinkedList<>();
        album1.addToPlaylistFromAlbum("Amin",myPlaylist);
        album1.addToPlaylistFromAlbum("Astagfirullah",myPlaylist);
        album1.addToPlaylistFromAlbum("Insaan",myPlaylist);
        album2.addToPlaylistFromAlbum(2,myPlaylist);

        play(myPlaylist);

    }

    public static void play(LinkedList<Song> playList){
        Scanner sc=new Scanner(System.in);
        boolean isforward=false;
        ListIterator<Song> itr=playList.listIterator();
        if(playList.size()>0){
            System.out.println("Currently Playing : "+itr.next());
            isforward=true;

        }
        else{
            System.out.println("Playlistb is empty");
            return;
        }

        System.out.println("Select your choice :- ");
        printMenu();
        boolean quit=false;
        while(quit!=true){
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    if(isforward==false){
                        itr.next();
                        isforward=true;
                    }
                    if(itr.hasNext())
                        System.out.println(itr.next());
                    else{
                        System.out.println("You have listened all songs:-)");
                        isforward=false;
                    }
                    break;
                case 2:
                    if(isforward==true){
                        itr.previous();
                        isforward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("You are at the first song:-(");
                        isforward=true;
                    }
                    break;
                case 3:
                    if(isforward==true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                        }
                        else{
                            System.out.println("Song doesn't exist:-(");
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isforward=true;
                        }
                        else{
                            System.out.println("Song is not present:-(");
                        }
                    }
                    break;
                case 4:
                    break;
                case 5:
                    printSongs(playList);
                    break;
                case 6:
                    quit=true;
                    break;
            }
        }

    }

    public static void printSongs(LinkedList<Song> playList){
        for(Song song : playList){
            System.out.println(song);
        }
        return;
    }

    public static void printMenu(){
        //System.out.println("Please Select Your Choice :- ");
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Repeat the current song");
        System.out.println("4. Delete the current song");
        System.out.println("5. Show all available songs");
        System.out.println("6. EXIT");
    }
}