package uap;

import java.util.ArrayList;

public class PropertyManager {
    private String name;
    private ArrayList<Property> properties;

    public PropertyManager(String name) {
        this.name = name;
        this.properties = new ArrayList<>();
    }

    // Method to add an Apartment property
    public void addProperty(String id, String location, double floorSpace, double rent, int noOfBedRooms, int noOfWashRooms, boolean hasGenerator) {
        properties.add(new Apartment(id, "", location, "", new ArrayList<>(), floorSpace, rent, noOfBedRooms, noOfWashRooms, hasGenerator));
    }

    // Method to add a Store property
    public void addProperty(String id, String location, double floorSpace, double rent, boolean hasFireExit) {
        properties.add(new Store(id, "", location, "", new ArrayList<>(), floorSpace, rent, hasFireExit));
    }

    // Method to add an OfficeSpace property
    public void addProperty(String id, String location, double floorSpace, double rent, int minLeaseTime) {
        properties.add(new OfficeSpace(id, "", location, "", new ArrayList<>(), floorSpace, rent, minLeaseTime));
    }

    // Method to find apartments based on location, number of bedrooms, and number of washrooms
    public ArrayList<Apartment> findApartments(String location, int noOfBedRooms, int noOfWashRooms) {
        ArrayList<Apartment> foundApartments = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof Apartment) {
                Apartment apartment = (Apartment) property;
                if (apartment.getLocation().equalsIgnoreCase(location) &&
                        apartment.getNoOfBedRoom() == noOfBedRooms &&
                        apartment.getNoOfWashRoom() == noOfWashRooms) {
                    foundApartments.add(apartment);
                }
            }
        }
        return foundApartments;
    }

    // Method to find apartments based on location, number of bedrooms, number of washrooms, minimum rent, and maximum rent
    public ArrayList<Apartment> findApartments(String location, int noOfBedRooms, int noOfWashRooms, int minRate, int maxRate) {
        ArrayList<Apartment> foundApartments = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof Apartment) {
                Apartment apartment = (Apartment) property;
                if (apartment.getLocation().equalsIgnoreCase(location) &&
                        apartment.getNoOfBedRoom() == noOfBedRooms &&
                        apartment.getNoOfWashRoom() == noOfWashRooms &&
                        apartment.getRent() >= minRate &&
                        apartment.getRent() <= maxRate) {
                    foundApartments.add(apartment);
                }
            }
        }
        return foundApartments;
    }

    // Method to find stores based on location, floor space, minimum rent, and maximum rent
    public ArrayList<Store> findStores(String location, double minFloorSpace, double maxFloorSpace, int minRate, int maxRate) {
        ArrayList<Store> foundStores = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof Store) {
                Store store = (Store) property;
                if (store.getLocation().equalsIgnoreCase(location) &&
                        store.getFloorspace() >= minFloorSpace &&
                        store.getFloorspace() <= maxFloorSpace &&
                        store.getRent() >= minRate &&
                        store.getRent() <= maxRate) {
                    foundStores.add(store);
                }
            }
        }
        return foundStores;
    }

    // Method to find office spaces based on location, floor space, minimum rent, and maximum rent
    public ArrayList<OfficeSpace> findOfficeSpaces(String location, double minFloorSpace, double maxFloorSpace) {
        ArrayList<OfficeSpace> foundOfficeSpaces = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof OfficeSpace) {
                OfficeSpace officeSpace = (OfficeSpace) property;
                if (officeSpace.getLocation().equalsIgnoreCase(location) &&
                        officeSpace.getFloorspace() >= minFloorSpace &&
                        officeSpace.getFloorspace() <= maxFloorSpace) {
                    foundOfficeSpaces.add(officeSpace);
                }
            }
        }
        return foundOfficeSpaces;
    }

    // Method to find a property by its id
    public Property findProperty(String id) {
        for (Property property : properties) {
            if (property.getId().equals(id)) {
                return property;
            }
        }
        return null;
    }

    // Method to rent a property
    public void rentProperty(String id, double rent, String rentedBy) {
        Property property = findProperty(id);
        if (property != null && property.isAvailable()) {
            property.rentProperty(rent, rentedBy);
            System.out.println("Property rented successfully!");
        } else {
            System.out.println("Property not available for rent.");
        }
    }

    // Method to mark lease over for a property
    public void leaseOver(String id) {
        Property property = findProperty(id);
        if (property != null && !property.isAvailable()) {
            property.leaseOver();
            System.out.println("Lease over successfully!");
        } else {
            System.out.println("No property found or property is already available for rent.");
        }
    }

    // Getter method for properties attribute
    public ArrayList<Property> getProperties() {
        return properties;
    }

    // Method to view all properties
    public void viewAll() {
        for (Property property : properties) {
            System.out.println(property);
        }
    }

    // Method to view details of a property by its id
    public void viewDetails(String id) {
        Property property = findProperty(id);
        if (property != null) {
            System.out.println(property);
        } else {
            System.out.println("Property not found.");
        }
    }
}
