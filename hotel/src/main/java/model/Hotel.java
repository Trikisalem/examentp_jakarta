package model;

public class Hotel {
    private int id;
    private String name;
    private String city;
    private int stars;
    private String description;
    private String image;
    private int agentId;

    public Hotel(int id, String name, String city, int stars, String description, String image, int agentId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.stars = stars;
        this.description = description;
        this.image = image;
        this.agentId = agentId;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}
