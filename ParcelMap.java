import java.util.HashMap;
import java.util.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParcelMap {
    private Map<String, Parcel> parcelMap;

    public ParcelMap() {
        parcelMap = new HashMap<>();
    }

    // Add a parcel to the map
    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelID(), parcel);
        System.out.println("Parcel " + parcel.getParcelID() + " added to the parcel map.");
    }

    // Find a parcel by its ID
    public Parcel findParcel(String parcelID) {
        return parcelMap.get(parcelID);
    }

    // Get all parcels in the depot
    public Collection<Parcel> getAllParcels() {
        return parcelMap.values();
    }

    // Display all parcels (for testing purposes)
    public void displayAllParcels() {
        System.out.println("All Parcels in the Depot:");
        for (Parcel parcel : parcelMap.values()) {
            parcel.displayParcelInfo();
        }
    }
}

