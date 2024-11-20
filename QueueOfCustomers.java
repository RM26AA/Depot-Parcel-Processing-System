import java.util.LinkedList;
import java.util.Queue;

public class QueueOfCustomers {
    private Queue<Customer> customerQueue;

    public QueueOfCustomers()
    {
        customerQueue = new LinkedList<>();
    }

    //add customer to the queue
    public void enqueue(Customer customer)
    {
        customerQueue.add(customer);
        System.out.println("Customer " + customer.getName() + " added to the queue.");
    }

    //remove customer from the queue
    public Customer dequeue()
    {
        Customer customer = customerQueue.poll();
        if (customer != null) {
            System.out.println("Customer " + customer.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty.");
        }
        return customer;
    }

    //display the current queue
    public void displayQueue()
    {
        System.out.println("Current Customer Queue:");
        for (Customer customer : customerQueue) {
            System.out.println(" - " + customer.getName() + " (Parcel ID: " + customer.getParcelID() + ")");
        }
        System.out.println();
    }
}

