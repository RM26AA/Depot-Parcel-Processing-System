# Depot Parcel Processing System

- Author: Romeo Maunick
- Date: 22/11/2024
- Version: 8.0

## Table of Contents
1. Project Description
2. Features
3. System Design
4. Setup Instructions
5. How to Use
6. Class Overview
7. File Structure
8. Future Improvements

## Project Description
The Depot Parcel Processing System is a Java-based application designed to simulate the operations of a parcel depot. 
It allows depot staff to process customers, manage parcels, and update parcel statuses. 
This application uses an intuitive graphical user interface (GUI) built with Java Swing, following
the MVC (Model-View-Controller) architecture.

## Features
- Queue Management: Handles customers in a queue waiting to collect parcels.
- Parcel Management: Tracks parcels using unique IDs and statuses (e.g., "Waiting", "Collected").
- Fee Calculation: Automatically calculates collection fees based on parcel weight and days in depot.
- Logging: Maintains a log of system events, saved to a text file.
- GUI:
 - Displays parcels in the depot, the customer queue, and the current parcel being processed.
 - Buttons for processing the next customer, refreshing the view, changing font size/type, and quitting the application.
 - Confirmation dialog before exiting the application.

## System Design
The application follows the MVC design pattern:

1. Model: Classes like Customer, Parcel, QueueOfCustomers, and ParcelMap represent the core data and logic.
2. View: The DepotView class handles the graphical user interface.
3. Controller: The DepotController class handles communication between the View and the Model.

## Setup Instructions
Prerequisites
- Java Development Kit (JDK) 8 or later.
- IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code) or a text editor with Java support.
Steps to Run
1. Clone this repository or download the source code.
2. Place the Parcels.csv and Customers.csv files in the root project directory.
3. Compile and run the Manager class:
   ```bash
   javac Manager.java
   java Manager

## How to Use
1. Initial Setup:
- The system automatically loads parcel and customer data from Parcels.csv and Customers.csv when launched.
2. Process Customers:
- Click the "Process Next Customer" button to serve the next customer in the queue.
- The system will:
  - Retrieve the customer's parcel.
  - Calculate the collection fee.
  - Update the parcel status to "Collected".
3. Refresh Data:
- Click "Refresh" to update the displayed data.
4. Change Font:
- Use the "Change Font Size" and "Change Font Type" buttons to adjust text styles in the GUI.
5. Quit Application:
- Click the "Quit" button to exit. A confirmation dialog will appear.

## Class Overview
Core Classes
1. Customer: Represents a depot customer, storing their ID, name, and the ID of their associated parcel.
2. Parcel: Represents a parcel, storing attributes like parcel ID, weight, dimensions, status, and days in depot.
3. QueueOfCustomers: Manages a queue of customers using a LinkedList.
4. ParcelMap: Stores parcels in a HashMap for efficient retrieval by ID.
5. Worker: Handles processing logic, including dequeuing customers, finding parcels, calculating fees, and updating parcel statuses.
6. Log: Singleton class for logging events and writing them to a text file.

## GUI Classes
1. DepotView:
- Displays three panels: parcels in depot, customer queue, and current parcel being processed.
- Includes buttons for processing customers, refreshing data, changing font styles, and quitting the application.
2. DepotController:
- Connects the view with the model, handling button actions and updating the GUI.
## Driver Class
- Manager:
  - Entry point for the application.
  - Initializes core components, loads data, and sets up the GUI and controller.

## Future Improvements
1. Error Handling:
- Add better exception handling for missing or corrupted data files.
2. Advanced Features:
- Add functionality to manually add or remove customers/parcels via the GUI.
3. Database Integration:
- Replace CSV files with a database for better scalability.
4. Enhanced Logging:
- Provide filtering and search options in the log file for better readability.

## Sample CSV File Formats

1. Customers.csv
   ```bash
   customerID,name,parcelID
   C001,John Doe,X123
   C002,Jane Smith,X124
   C003,Mark Brown,X125

2. Parcels.csv
   ```bash
   parcelID,dimensions,weight,daysInDepot,status
   X123,10x10x20,5.5,3,Waiting
   X124,12x15x10,8.0,5,Waiting
   X125,5x5x5,2.5,1,Waiting

- Enjoy using the Depot Parcel Processing System! For questions or issues, please feel free to contact me.




























