package javaBeans;
import java.io.Serializable;

public class Event implements Serializable {
	
    private int id;
    private String username;
    private String title;
    private String eventDate;
    private String description;

    // Default constructor
    public Event() {
    }
    // Parameterized constructor
    public Event(int id, String username, String title,
                 String eventDate, String description) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
