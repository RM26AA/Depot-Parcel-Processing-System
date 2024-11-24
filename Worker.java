public class Worker {
    private QueueOfCustomers customerQueue;
    private ParcelMap parcelMap;
    private Log log;
    private Parcel currentParcel;

    public Worker(QueueOfCustomers customerQueue, ParcelMap parcelMap, Log log) {
        this.customerQueue = customerQueue;
        this.parcelMap = parcelMap;
        this.log = log;
    }

    // Calculate collection fee
    private float calculateFee(Parcel parcel) {
        return parcel.getWeight() * 0.5f + parcel.getDaysInDepot() * 0.2f;
    }

    // Process the next customer in the queue
    public void processNextCustomer() {
        Customer customer = customerQueue.dequeue();
        if (customer == null) {
            System.out.println("No customers in the queue.");
            return;
        }

        currentParcel = parcelMap.findParcel(customer.getParcelID());
        if (currentParcel != null) {
            float fee = calculateFee(currentParcel);
            currentParcel.setStatus("Collected");
            log.logEvent("Customer " + customer.getName() + " collected parcel " + currentParcel.getParcelID() + " with a fee of $" + fee);
            System.out.println("Processed parcel for " + customer.getName());
        } else {
            System.out.println("Parcel not found for customer " + customer.getName());
        }
    }

    public String getCurrentParcelInfo() {
        return currentParcel != null ? currentParcel.getParcelID() : "No parcel being processed";
    }
}


