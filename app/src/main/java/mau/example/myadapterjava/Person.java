package mau.example.myadapterjava;

public class Person {

    // atts
    private String name;
    private String description;
    private int image;

    // construct vacio

    // methods
    public Person(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
