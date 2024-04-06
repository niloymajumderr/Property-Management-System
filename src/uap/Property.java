package uap;

public abstract class Property {
    private int id;
    private String description;
    private String location;
    private String category;
    private double floorspace;
    private double rent;
    private boolean isAvailable;
    private String rentedBy;

    public Property(int id, String description, String location, String category,double floorspace, double rent) {
        this.id = id;
        this.description = description;
        this.location = location;
        this.category = category;
        this.floorspace = floorspace;
        this.rent = rent;
        this.isAvailable = true;
        this.rentedBy = null;
    }
    
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public double getFloorspace() {
        return floorspace;
    }

    public double getRent() {
        return rent;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setRentedBy(String rentedBy) {
        this.rentedBy = rentedBy;
    }

    // Getter and setter methods

    public abstract double getSecurityDeposit();
    public void rentProperty(double rent, String rentedBy) {
        setAvailable(false);
        setRent(rent);
        setRentedBy(rentedBy);
    }

    public double giveMonthlyPayment() {
        return getRent();
    }

    public void leaseOver() {
        setAvailable(true);
        setRentedBy(null);
    }
    /*@Override
    public String toString(){
		String info = String.format ("Id= %s, Location = %s, Floor Space = %s, Rent = %f\n", id, location, floorspace);
		return info;
	} */
    
    
    // toString method
   public String toString() {
        return "Property{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                ", floorspace=" + floorspace +
                ", rent=" + rent +
                ", isAvailable=" + isAvailable +
                ", rentedBy='" + rentedBy + '\'' +
                '}';
    }
 
}