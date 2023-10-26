import java.util.Timer;
import java.util.TimerTask;

public class Table {
  private int tableNumber;
  private int capacity;
  private boolean isOccupied;
  private Timer occupancyTimer;

  public Table(int tableNumber, int capacity) {
      this.tableNumber = tableNumber;
      this.capacity = capacity;
      this.isOccupied = false; // By default, the table is not occupied when created.
    
  }

  public int getTableNumber() {
      return tableNumber;
  }

  public int getCapacity() {
      return capacity;
  }

  public boolean isOccupied() {
      return isOccupied;
  }

  public void occupy() {
      isOccupied = true;

      occupancyTimer = new Timer();
      occupancyTimer.schedule(new TableOccupancyTask(), 6000);
  }

  public void vacate() {
      isOccupied = false;
      occupancyTimer.cancel();

  }

  
  @Override
  public String toString() {
      return "Table " + tableNumber + " (Capacity: " + capacity + ", Occupied: " + isOccupied + ")";
  }

  private class TableOccupancyTask extends TimerTask {
      @Override
      public void run() {
          System.out.println("Table " + tableNumber + " Has been vacated after group left");
          vacate();
      }
  }
}
