package uap;

	public class OfficeSpace extends Property {
	    private int minLeaseTime;

	    public OfficeSpace(int id, String description, String location, String category, double floorspace, double rent, int minLeaseTime) {
	        super(id, description, location, category, floorspace, rent);
	        this.minLeaseTime = minLeaseTime;
	    }

	    @Override
	    public double getSecurityDeposit() {
	        return getRent() * 6; 
	    }
	}


