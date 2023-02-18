import java.util.*;

public class Laptop {
    private int identifier;
    private String manufacturer;
    private String modelName;
    private int ram;
    private int hdCapacity;
    private String os;
    private double price;

    public Laptop(int identifier, String manufacturer, String modelName, int ram, int hdCapacity, String os, double price) {
        this.identifier = identifier;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.ram = ram;
        this.hdCapacity = hdCapacity;
        this.os = os;
        this.price = price;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getRam() {
        return ram;
    }

    public int getHdCapacity() {
        return hdCapacity;
    }

    public String getOs() {
        return os;
    }

    public double getPrice() {
        return price;
    }
}

public class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        laptops = new HashSet<>();
        laptops.add(new Laptop(1, "Dell", "Inspiron 15", 8, 256, "Windows 10", 799.99));
        laptops.add(new Laptop(2, "Apple", "MacBook Air", 8, 256, "macOS", 999.99));
        laptops.add(new Laptop(3, "HP", "Pavilion x360", 4, 128, "Windows 10", 549.99));
    }

    public void printAllItems() {
        System.out.println("All laptops in the catalog:");
        for (Laptop laptop : laptops) {
            System.out.println(laptop.getManufacturer() + " " + laptop.getModelName() + " - $" + laptop.getPrice());
        }
    }

    public void searchCatalog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number that matches the search criterion:");
        System.out.println("1 - RAM");
        System.out.println("2 - HD capacity");
        System.out.println("3 - Operating system");
        int criterion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the search term: ");
        String searchTerm = scanner.nextLine();
        System.out.println("Laptops with " + getCriterionName(criterion) + " " + searchTerm);
        int i = 1;
        for (Laptop laptop : laptops) {
            if (matchesCriterion(laptop, criterion, searchTerm)) {
                System.out.println(i + " " + laptop.getManufacturer() + " " + laptop.getModelName());
                i++;
            }
        }
    }

    private boolean matchesCriterion(Laptop laptop, int criterion, String searchTerm) {
        switch (criterion) {
            case 1:
                return laptop.getRam() == Integer.parseInt(searchTerm);
            case 2:
                return laptop.getHdCapacity() == Integer.parseInt(searchTerm);
            case 3:
                return laptop.getOs().equalsIgnoreCase(searchTerm);
            default:
                return false;
        }
    }

    private String getCriterionName(int criterion) {
        switch (criterion) {
            case 1:
                return "RAM";
            case 2:
                return "HD capacity";
            case 3:
                return "Operating system";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Welcome to the notebook catalog!");
            System.out.println("Select an action:");
            System.out.println("1 - Print all items");
            System.out.println("2 - Search the catalog");
            System.out.println("0 - Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    store.printAllItems();
                    break;
                case 2:
                    store.searchCatalog();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
