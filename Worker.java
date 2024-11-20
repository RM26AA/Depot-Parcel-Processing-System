public class Worker {
    private QueueOfCustomers customerQueue;
    private ParcelMap parcelMap;
    private Log log;

    public Worker(QueueOfCustomers customerQueue, ParcelMap parcelMap, Log log)
    {
        this.customerQueue = customerQueue;
        this.parcelMap = parcelMap;
        this.log = log;
    }

    //calculate collection fee based on weight and days in depot
    private float calculateFee(Parcel parcel)
    {
        float fee = parcel.getWeight() * 0.5f + parcel.getDaysInDepot() * 0.2f;
        return fee;
    }

    //process the next customer in the queue
    public void processNextCustomer() {
        Customer customer = customerQueue.dequeue();
        if (customer == null) {
            System.out.println("No customers in the queue.");
            return;
        }

        Parcel parcel = parcelMap.findParcel(customer.getParcelID());
        if (parcel == null) {
            System.out.println("Parcel not found for customer " + customer.getName());
            log.logEvent("Parcel not found for customer " + customer.getName());
            return;
        }

        //calculate the fee
        float fee = calculateFee(parcel);
        System.out.println("Customer " + customer.getName() + " is collecting parcel " + parcel.getParcelID());
        System.out.println("Collection Fee: £" + fee);

        //update parcel status to 'Collected'
        parcel.setStatus("Collected");
        log.logEvent("Customer " + customer.getName() + " collected parcel " + parcel.getParcelID() + " with a fee of £" + fee);
    }
}

