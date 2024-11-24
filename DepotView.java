import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DepotView extends JFrame {
    // Panels to display data
    private JTextArea parcelListArea;
    private JTextArea customerQueueArea;
    private JTextArea currentParcelArea;

    // Buttons for actions
    private JButton processNextButton;
    private JButton refreshButton;

    public DepotView() {
        setTitle("Depot Parcel Processing System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for parcel list
        parcelListArea = new JTextArea(15, 25);
        parcelListArea.setEditable(false);
        JPanel parcelPanel = new JPanel();
        parcelPanel.setBorder(BorderFactory.createTitledBorder("Parcels in Depot"));
        parcelPanel.add(new JScrollPane(parcelListArea));

        // Panel for customer queue
        customerQueueArea = new JTextArea(15, 25);
        customerQueueArea.setEditable(false);
        JPanel queuePanel = new JPanel();
        queuePanel.setBorder(BorderFactory.createTitledBorder("Customer Queue"));
        queuePanel.add(new JScrollPane(customerQueueArea));

        // Panel for current parcel being processed
        currentParcelArea = new JTextArea(10, 25);
        currentParcelArea.setEditable(false);
        JPanel currentParcelPanel = new JPanel();
        currentParcelPanel.setBorder(BorderFactory.createTitledBorder("Current Parcel Being Processed"));
        currentParcelPanel.add(new JScrollPane(currentParcelArea));

        // Control panel with buttons
        processNextButton = new JButton("Process Next Customer");
        refreshButton = new JButton("Refresh");
        JPanel controlPanel = new JPanel();
        controlPanel.add(processNextButton);
        controlPanel.add(refreshButton);

        // Adding panels to the frame
        add(parcelPanel, BorderLayout.WEST);
        add(queuePanel, BorderLayout.EAST);
        add(currentParcelPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Methods to update the text areas
    public void updateParcelList(String parcels) {
        parcelListArea.setText(parcels);
    }

    public void updateCustomerQueue(String queue) {
        customerQueueArea.setText(queue);
    }

    public void updateCurrentParcel(String parcelInfo) {
        currentParcelArea.setText(parcelInfo);
    }

    // Getters for buttons to add ActionListeners
    public JButton getProcessNextButton() {
        return processNextButton;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }
}

