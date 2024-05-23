import java.util.Arrays;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class InventoryManagementSystem {
    private Product[] products;
    private int size;

    public InventoryManagementSystem(int capacity) {
        products = new Product[capacity];
        size = 0;
    }

    public void addProduct(Product product) {
        if (size < products.length) {
            products[size++] = product;
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Inventory is full. Cannot add more products.");
        }
    }

    public void removeProduct(int id) {
        int index = findProductIndex(id);
        if (index == -1) {
            System.out.println("Product not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            products[i] = products[i + 1];
        }
        size--;
        System.out.println("Product removed successfully.");
    }

    public Product searchProductById(int id) {
        int index = findProductIndex(id);
        if (index == -1) {
            System.out.println("Product not found.");
            return null;
        }
        return products[index];
    }

    public Product[] searchProductByName(String name) {
        Product[] result = new Product[size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (products[i].getName().contains(name)) {
                result[count++] = products[i];
            }
        }

        if (count == 0) {
            System.out.println("No products found.");
            return null;
        }

        return Arrays.copyOf(result, count);
    }

    public void sortByName() {
        Arrays.sort(products, 0, size, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void sortByPrice() {
        Arrays.sort(products, 0, size, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    }

    public void sortByQuantity() {
        Arrays.sort(products, 0, size, (p1, p2) -> Integer.compare(p1.getQuantity(), p2.getQuantity()));
    }

    public void displayInventory() {
        if (size == 0) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\nCurrent Inventory:");
        System.out.println("ID\tName\tPrice\tQuantity");
        System.out.println("---\t----\t-----\t--------");
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            System.out.printf("%d\t%s\t$%.2f\t%d\n", product.getId(), product.getName(), product.getPrice(), product.getQuantity());
        }
    }

    private int findProductIndex(int id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem inventory = new InventoryManagementSystem(100);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Sort Products by Name");
            System.out.println("6. Sort Products by Price");
            System.out.println("7. Sort Products by Quantity");
            System.out.println("8. Display Inventory");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    inventory.addProduct(new Product(id, name, price, quantity));
                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    inventory.removeProduct(id);
                    break;

                case 3:
                    System.out.print("Enter product ID to search: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    Product product = inventory.searchProductById(id);
                    if (product != null) {
                        System.out.println("Product found: " + product.getName() + " - $" + product.getPrice() + " - " + product.getQuantity() + " in stock");
                    }
                    break;

                case 4:
                    System.out.print("Enter product name to search: ");
                    name = scanner.nextLine();
                    Product[] results = inventory.searchProductByName(name);
                    if (results != null) {
                        System.out.println("Search results:");
                        for (Product p : results) {
                            if (p != null) {
                                System.out.println(p.getName() + " - $" + p.getPrice() + " - " + p.getQuantity() + " in stock");
                            }
                        }
                    }
                    break;

                case 5:
                    inventory.sortByName();
                    System.out.println("Products sorted by name.");
                    break;

                case 6:
                    inventory.sortByPrice();
                    System.out.println("Products sorted by price.");
                    break;

                case 7:
                    inventory.sortByQuantity();
                    System.out.println("Products sorted by quantity.");
                    break;

                case 8:
                    inventory.displayInventory();
                    break;

                case 9:
                    System.out.println("Exiting Inventory Management System...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}