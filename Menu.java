import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public List<MenuItem> getMenuItems() {
        return items;
    }

    public void printMenu() {
        System.out.println("Menu:");
        for (MenuItem item : items) {
            System.out.println(item);
        }
    }
}
