package uap;
public class Apartment extends Property {
    private int noOfBedRoom;
    private int noOfWashRoom;
    private boolean hasGenerator;
    public Apartment(int id, String description, String location, String category, double floorspace, double rent, int noOfBedRoom, int noOfWashRoom, boolean hasGenerator) {
        super(id, description, location, category, floorspace, rent);
        this.noOfBedRoom = noOfBedRoom;
        this.noOfWashRoom = noOfWashRoom;
        this.hasGenerator = hasGenerator;
    }

    @Override
    public double getSecurityDeposit() {
        return getRent() * 3; // Rent of 3 months as security deposit for apartment
    }
}
