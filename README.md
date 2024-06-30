### Inventory Management System

#### Project Description

The Inventory Management System is a Java-based application designed to efficiently manage product information within a business. This system utilizes arrays to store and manipulate data related to products, allowing users to perform various operations that ensure accurate stock levels and streamlined inventory management.

#### Data Structure

**Products:**
- The products are represented using an array of `Product` objects.
- Each `Product` object includes attributes such as:
  - `id`: A unique identifier for the product.
  - `name`: The name of the product.
  - `price`: The price of the product.
  - `quantity`: The quantity of the product in stock.

#### Functionalities

**Add Product:**
- Users can add a new product to the inventory by providing details such as the product ID, name, price, and quantity.
- A new `Product` object is created with the provided information and added to the array.
- The system checks if there is enough space in the array before adding a new product.

**Remove Product:**
- Users can remove an existing product by searching for it using the product ID.
- The system locates the product in the array and removes it, shifting the remaining products to fill the gap.

**Search Product:**
- Users can search for products based on:
  - `Product ID`: The system returns the product that matches the given ID.
  - `Product Name`: The system returns a list of products that match the given name or partial name.

**Sort Products:**
- The system allows sorting of the inventory based on different criteria:
  - `Product Name`: Sorts the products in alphabetical order.
  - `Product Price`: Sorts the products by price, either in ascending or descending order.
  - `Product Quantity`: Sorts the products by quantity, either from low to high or high to low.

**Display Inventory:**
- The system provides a function to display all products currently in the inventory.
- The display includes details such as the product ID, name, price, and quantity.

#### Code Implementation

The project is implemented in Java and comprises two main classes: `Product` and `InventoryManagementSystem`, along with a `Main` class to interact with the user.

**Product Class:**
- Defines the properties of a product and provides getter and setter methods.

**InventoryManagementSystem Class:**
- Manages the array of `Product` objects.
- Includes methods to add, remove, search, sort, and display products.

**Main Class:**
- Provides a user interface for interacting with the inventory management system.
- Contains a menu-driven approach that allows users to perform various operations by choosing options from the menu.

#### Conclusion

The Inventory Management System is a robust application designed to handle various inventory management tasks efficiently. By leveraging arrays and implementing essential functionalities such as adding, removing, searching, sorting, and displaying products, the system ensures that users can maintain accurate and up-to-date inventory records. This project serves as a practical example of how Java can be used to develop comprehensive management systems.
