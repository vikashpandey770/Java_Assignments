package javaBeans;

public class productdata {

    private int id;
    private String name;
    private double price;

    // Constructor
    public productdata(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}