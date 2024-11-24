import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepotController {
    private DepotView view;
    private QueueOfCustomers queue;
    private ParcelMap parcelMap;
    private Worker worker;

    public DepotController(DepotView view, QueueOfCustomers queue, ParcelMap parcelMap, Worker worker) {
        this.view = view;
        this.queue = queue;
        this.parcelMap = parcelMap;
        this.worker = worker;

        // Add action listeners
        view.getProcessNextButton().addActionListener(new ProcessNextListener());
        view.getRefreshButton().addActionListener(new RefreshListener());

        // Initial display update
        refreshDisplay();
    }

    // Inner class for process next button
    private class ProcessNextListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            worker.processNextCustomer();
            refreshDisplay();
        }
    }

    // Inner class for refresh button
    private class RefreshListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            refreshDisplay();
        }
    }

    // Method to refresh display content
    private void refreshDisplay() {
        view.updateParcelList(getParcelList());
        view.updateCustomerQueue(getCustomerQueue());
        view.updateCurrentParcel(getCurrentParcelInfo());
    }

    // Helper methods to get formatted strings for display
    private String getParcelList() {
        StringBuilder sb = new StringBuilder();
        for (Parcel parcel : parcelMap.getAllParcels()) {
            sb.append("ID: ").append(parcel.getParcelID()).append(", ");
            sb.append("Status: ").append(parcel.getStatus()).append("\n");
        }
        return sb.toString();
    }

    private String getCustomerQueue() {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : queue.getQueue()) {
            sb.append("Customer: ").append(customer.getName()).append(", ");
            sb.append("Parcel ID: ").append(customer.getParcelID()).append("\n");
        }
        return sb.toString();
    }

    private String getCurrentParcelInfo() {
        // Placeholder for actual current parcel info from worker
        return "Currently Processing: " + worker.getCurrentParcelInfo();
    }
}

