package hu.cintia.projekt;

import jakarta.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String name;
    private String color;
    private String season;
    private String type;

    public Flight() {}

    public Flight(Long id, String brand, String name, String color, String season, String type) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.season = season;
        this.type = type;
    }

    // Getterek és Setterek
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}