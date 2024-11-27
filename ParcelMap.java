import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ParcelMap {
    private Map<String, Parcel> parcelMap;

    public ParcelMap() {
        parcelMap = new HashMap<>();
    }

    // Add a parcel to the map
    /*public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelID(), parcel);
        System.out.println("Parcel " + parcel.getParcelID() + " added to the parcel map.");
    }*/
    // Add a parcel to the map    -  NEW VERSION
    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelID(), parcel);
    }

    // Method to read parcels from a CSV file
    public void readParcelsFromCSV(String filePath) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Assumes CSV file is comma-separated
                if (values.length >= 5) {
                    String parcelID = values[0];
                    String dimensions = values[1];
                    float weight = Float.parseFloat(values[2]);
                    int daysInDepot = Integer.parseInt(values[3]);
                    String status = values[4];
                    Parcel parcel = new Parcel(parcelID, dimensions, weight, daysInDepot, status);
                    addParcel(parcel);
                }
            }
            System.out.println("Parcels loaded from CSV file.");
        } catch (IOException e) {
            System.err.println("Error reading parcels CSV file: " + e.getMessage());
        }
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

