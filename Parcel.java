public class Parcel {
    private String parcelID;
    private String dimensions; // e.g., '14 x 10 x 26'
    private float weight;
    private int daysInDepot;
    private String status; //collected or Waiting

    public Parcel(String parcelID, String dimensions, float weight, int daysInDepot, String status)
    {
        this.parcelID = parcelID;
        this.dimensions = dimensions;
        this.weight = weight;
        this.daysInDepot = daysInDepot;
        this.status = status;
    }

    //getter methods
    public String getParcelID()
    {
        return parcelID;
    }
    public String getDimensions()
    {
        return dimensions;
    }
    public float getWeight()
    {
        return weight;
    }
    public int getDaysInDepot()
    {
        return daysInDepot;
    }
    public String getStatus()
    {
        return status;
    }

    //setter for status (for when parcel is collected)
    public void setStatus(String status)
    {
        this.status = status;
    }

    //display parcel details
    public void displayParcelInfo()
    {
        System.out.println("Parcel ID: " + parcelID);
        System.out.println("Dimensions: " + dimensions);
        System.out.println("Weight: " + weight + "kg");
        System.out.println("Days in Depot: " + daysInDepot);
        System.out.println("Status: " + status);
        System.out.println();
    }
}

