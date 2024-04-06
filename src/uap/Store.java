package uap;

public class Store extends Property {
    private boolean hasFireExit;

    public Store(int id, String description, String location, String category, double floorspace, double rent, boolean hasFireExit) {
        super(id, description, location, category, floorspace, rent);
        this.hasFireExit = hasFireExit;
    }

    @Override
    public double getSecurityDeposit() {
        return getRent() * 6; 
    }
}

