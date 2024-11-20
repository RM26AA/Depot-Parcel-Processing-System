public class Customer {
    private String customerID;
    private String name;
    private String parcelID;

    public Customer(String customerID, String name, String parcelID)
    {
        this.customerID = customerID;
        this.name = name;
        this.parcelID = parcelID;
    }

    //getter methods
    public String getCustomerID()
    {
        return customerID;
    }
    public String getName()
    {
        return name;
    }
    public String getParcelID()
    {
        return parcelID;
    }

    //display customer details
    public void displayCustomerInfo()
    {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + name);
        System.out.println("Parcel ID to Collect: " + parcelID);
        System.out.println();
    }
}

