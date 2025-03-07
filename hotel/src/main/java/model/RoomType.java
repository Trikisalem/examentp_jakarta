package model;

/**
 * Classe représentant un type de chambre (RoomType).
 */

public class RoomType {

    private int id;
    private String label;
    private int capacity;
    private double price;  // Utiliser un type double pour le prix
    private int hotelId;

    // Constructeur avec tous les paramètres
    public RoomType() {
        this.id = id;
        this.label = label;
        this.capacity = capacity;
        this.price = price;
        this.hotelId = hotelId;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return (int) price;
    }

    public void setPrice(double price) {  // Le type est double pour le prix
        this.price = price;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    // Méthode toString pour afficher les informations de RoomType
    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", hotelId=" + hotelId +
                '}';
    }

	public void setRoomType(RoomType roomType) {
		this.setRoomType(roomType);
		
	}
}
