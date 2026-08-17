import java.util.ArrayList;

class Song {

    String title;
    String artist;
    double duration;

    Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("-------------------------");
    }
}

public class Session16Q1 {

    public static void main(String[] args) {

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Kesariya", "Arijit Singh", 4.28));
        songs.add(new Song("Tum Hi Ho", "Arijit Singh", 4.22));
        songs.add(new Song("Apna Bana Le", "Arijit Singh", 4.21));
        songs.add(new Song("Chaleya", "Arijit Singh", 3.20));
        songs.add(new Song("Heeriye", "Jasleen Royal", 3.14));

        for (Song s : songs) {
            s.display();
        }
    }
}