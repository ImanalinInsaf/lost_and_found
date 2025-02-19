import java.util.*;

class Item {
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final String category;
    private final String location;
    private final String dateFound;
    private boolean claimed;

    public Item(String name, String category, String location, String dateFound) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
        this.location = location;
        this.dateFound = dateFound;
        this.claimed = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getLocation() { return location; }
    public String getDateFound() { return dateFound; }
    public boolean isClaimed() { return claimed; }
    public void claim() { this.claimed = true; }

    @Override
    public String toString() {
        return id + ". " + name + " (" + category + ") - Found at: " + location + " | Date: " + dateFound + " | " + (claimed ? "Claimed" : "Unclaimed");
    }
}

public class LostAndFoundSystem {
    private static final List<Item> items = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLost & Found System");
            System.out.println("1. Add Found Item");
            System.out.println("2. View All Unclaimed Items");
            System.out.println("3. Search for an Item");
            System.out.println("4. Mark Item as Claimed");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> viewUnclaimedItems();
                case 3 -> searchItem();
                case 4 -> claimItem();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Error: Invalid choice.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Found Location: ");
        String location = scanner.nextLine();
        System.out.print("Date Found (YYYY-MM-DD): ");
        String dateFound = scanner.nextLine();

        items.add(new Item(name, category, location, dateFound));
        System.out.println("✅ Item successfully added!");
    }

    private static void viewUnclaimedItems() {
        System.out.println("\nList of Unclaimed Items:");
        for (Item item : items) {
            if (!item.isClaimed()) {
                System.out.println(item);
            }
        }
    }

    private static void searchItem() {
        System.out.print("Enter name, category, or location: ");
        String query = scanner.nextLine().toLowerCase();
        
        System.out.println("\nSearch Results:");
        for (Item item : items) {
            if (item.getName().toLowerCase().contains(query) ||
                item.getCategory().toLowerCase().contains(query) ||
                item.getLocation().toLowerCase().contains(query)) {
                System.out.println(item);
            }
        }
    }

    private static void claimItem() {
        System.out.print("Enter Item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Item item : items) {
            if (item.getId() == id && !item.isClaimed()) {
                item.claim();
                System.out.println("✅ Item marked as claimed.");
                return;
            }
        }
        System.out.println("❌ Item not found or already claimed.");
    }
}
