package Bean;


public class Playlist {

    private String name = "My Playlist";
    private String description = "My favourite songs";

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Playlist{name='" + name + 
               "', description='" + description + "'}";
    }
}