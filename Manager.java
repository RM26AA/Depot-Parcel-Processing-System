public class Manager {
    public static void main(String[] args) {

        /* Testing parcel, queue, customer class

        //initialize data structures
        QueueOfCustomers queue = new QueueOfCustomers();
        ParcelMap parcelMap = new ParcelMap();

        //add sample parcels
        Parcel parcel1 = new Parcel("P001", "4 x 2 x 1", 10.5f, 3, "Waiting");
        Parcel parcel2 = new Parcel("P002", "5 x 3 x 2", 15.0f, 1, "Waiting");
        parcelMap.addParcel(parcel1);
        parcelMap.addParcel(parcel2);

        //add sample customers
        Customer customer1 = new Customer("C001", "Alice", "P001");
        Customer customer2 = new Customer("C002", "Bob", "P002");

        //enqueue customers
        queue.enqueue(customer1);
        queue.enqueue(customer2);

        //display information
        System.out.println("\nDisplaying all parcels:");
        parcelMap.displayAllParcels();

        System.out.println("\nDisplaying customer queue:");
        queue.displayQueue();
        */


        // Testing of worker and log class
        // Initialize data structures
        QueueOfCustomers queue = new QueueOfCustomers();
        ParcelMap parcelMap = new ParcelMap();
        Log log = Log.getInstance();
        Worker worker = new Worker(queue, parcelMap, log);

        // Add sample parcels
        Parcel parcel1 = new Parcel("P001", "4 x 2 x 1", 10.5f, 3, "Waiting");
        Parcel parcel2 = new Parcel("P002", "5 x 3 x 2", 15.0f, 1, "Waiting");
        parcelMap.addParcel(parcel1);
        parcelMap.addParcel(parcel2);

        // Add sample customers
        Customer customer1 = new Customer("C001", "Alice", "P001");
        Customer customer2 = new Customer("C002", "Bob", "P002");

        // Enqueue customers
        queue.enqueue(customer1);
        queue.enqueue(customer2);

        // Process customers
        worker.processNextCustomer(); // Process Alice
        worker.processNextCustomer(); // Process Bob

        // Write log to file
        log.writeLogToFile("depot_log.txt");




    }
}

