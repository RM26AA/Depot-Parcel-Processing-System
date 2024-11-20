import java.util.HashMap;
import java.util.Map;

public class ParcelMap {
    private Map<String, Parcel> parcelMap;

    public ParcelMap()
    {
        parcelMap = new HashMap<>();
    }

    //add a parcel to the map
    public void addParcel(Parcel parcel)
    {
        parcelMap.put(parcel.getParcelID(), parcel);
        System.out.println("Parcel " + parcel.getParcelID() + " added to the parcel map.");
    }

    //find a parcel by its ID
    public Parcel findParcel(String parcelID)
    {
        return parcelMap.get(parcelID);
    }

    //display all parcels
    public void displayAllParcels()
    {
        System.out.println("All Parcels in the Depot:");
        for (Parcel parcel : parcelMap.values())
        {
            parcel.displayParcelInfo();
        }
    }
}
