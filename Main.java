import java.util.*;
import java.lang.*;
class Main {
  public static void main(String[] args) {
    //how many tables a customer wants
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Your Restaurant Management System!");
    System.out.println("============================================");
    System.out.println();
    

    // Get the number of tables from the restaurant manager
    System.out.print("Enter the number of tables: ");
    int numTables = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    // Create a list to store the tables
    List<Table> tables = new ArrayList<>();

    // Create tables and set occupancy for each
    for (int i = 1; i <= numTables; i++) {
        System.out.print("Enter the capacity for Table " + i + ": ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Table table = new Table(i, capacity);
        tables.add(table);
    }
    System.out.println();
    System.out.println("============================================");
    System.out.println("Great job! Now initialize your menu and add the staple items");
    System.out.println("============================================");
    System.out.println();

    // Create a menu
    Menu menu = new Menu();

    // Ask the restaurant owner to add menu items
    boolean running = true;
    while (running) {
        System.out.println("Options:");
        System.out.println("1. Add a menu item");
        System.out.println("2. Print the menu");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.print("Enter the name of the menu item: ");
                String itemName = scanner.nextLine();

                System.out.print("Enter the description: ");
                String description = scanner.nextLine();

                System.out.print("Enter the price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                MenuItem newItem = new MenuItem(itemName, description, price);
                menu.addItem(newItem);
                System.out.println("Menu item added.");
                break;
            case 2:
                menu.printMenu();
              break;
            case 3:
                System.out.println("Exiting...");
                scanner.close();
                running=false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    System.out.println();
    System.out.println("============================================");
    System.out.println("Great job! Your restaurant has been initialized and is now open");
    System.out.println("============================================");
    System.out.println();
    System.out.println("RESTAURANT OPEN");
    System.out.println();
    System.out.println("============================================");

    int count=0;
    boolean tableAvailable=false;
    while (count < 10){
      count++;
      //randomly generate the number of customers ranging from to 8
      int partySize = (int)(Math.random() * 8) + 1;
      System.out.println("Welcome Customer #"+count+" of party of "+partySize);
      
      System.out.println("============================================");

      // checks if there are any vacant tables that have a capacity as large as partySize using isOccupied and getCapacity methods
      for (Table table : tables) {
        if (table.getCapacity() == partySize && !table.isOccupied()) {
          System.out.println("Table #" + table.getTableNumber() + " is available for Customer #" + count + " of party of " + partySize);
            tableAvailable=true;
            table.occupy();
            break;
        }
      }
      if (tableAvailable==false){
        System.out.println("No table is available for Customer #" + count + " of party of " + partySize);
        // while (tableAvailable==false){
        //   for (Table table : tables) {
        //     if (table.getCapacity() == partySize && !table.isOccupied()) {
        //       System.out.println("Table #" + table.getTableNumber() + " is available for Customer #" + count + " of party of " + partySize);
        //         tableAvailable=true;
        //         break;
        //     }
        //   }
        // }
      }
    }
    // Access and modify table properties
    // System.out.println("Table Number: " + table1.getTableNumber());
    // System.out.println("Capacity: " + table1.getCapacity());
    // System.out.println("Is Occupied? " + table1.isOccupied());

    // // Occupy the table
    // table1.occupy();
    // System.out.println("Is Occupied? " + table1.isOccupied());

    // // Vacate the table
    // // table1.vacate();
    // table2.occupy();
    // System.out.println("Is Occupied? " + table2.isOccupied());

    // // new customer
    // int counter = 0;
    // while (true){
    //   if (table1.isOccupied() == true){
    //   }
    //   else{
        
    //   }
      
    // }
  }
}

