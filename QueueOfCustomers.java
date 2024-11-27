import java.util.LinkedList;
import java.util.Queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QueueOfCustomers {
    private Queue<Customer> customerQueue;

    public QueueOfCustomers() {
        customerQueue = new LinkedList<>();
    }

    // Add customer to the queue
    /*public void enqueue(Customer customer) {
        customerQueue.add(customer);
        System.out.println("Customer " + customer.getName() + " added to the queue.");
    } */

    // Add a customer to the queue  - NEW VERSION
    public void enqueue(Customer customer) {
        customerQueue.add(customer);
    }

    // Method to read customers from a CSV file
    public void readCustomersFromCSV(String filePath) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    String customerID = values[0];
                    String name = values[1];
                    String parcelID = values[2];
                    Customer customer = new Customer(customerID, name, parcelID);
                    enqueue(customer);
                }
            }
            System.out.println("Customers loaded from CSV file.");
        } catch (IOException e) {
            System.err.println("Error reading customers CSV file: " + e.getMessage());
        }
    }

    // Remove customer from the queue
    public Customer dequeue() {
        Customer customer = customerQueue.poll();
        if (customer != null) {
            System.out.println("Customer " + customer.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty.");
        }
        return customer;
    }

    // Get the current queue of customers
    public Queue<Customer> getQueue() {
        return customerQueue;
    }

    // Display the current queue (for testing purposes)
    public void displayQueue() {
        System.out.println("Current Customer Queue:");
        for (Customer customer : customerQueue) {
            System.out.println(" - " + customer.getName() + " (Parcel ID: " + customer.getParcelID() + ")");
        }
    }
}


