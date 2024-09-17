
import java.util.ArrayList;
import java.util.List;

// Class representing a product
class Product {

    private int productId;
    private String productName;
    private double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

// Class representing the customer's cart
class Cart {

    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getProductName() + " added to cart.");
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            System.out.println(product.getProductName() + " removed from cart.");
        } else {
            System.out.println(product.getProductName() + " not found in cart.");
        }
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void applyDiscount(double discountPercentage) {
        double totalPrice = calculateTotalPrice();
        double discount = totalPrice * (discountPercentage / 100);
        System.out.println("Discount applied: " + discountPercentage + "% (" + discount + ")");
    }

    public List<Product> getProducts() {
        return products;
    }

    public void clearCart() {
        products.clear();
    }
}

// Class representing an order
class Order {

    private Cart cart;
    private double totalAmount;

    public Order(Cart cart) {
        this.cart = cart;
        this.totalAmount = cart.calculateTotalPrice();
    }

    public void finalizeOrder() {
        System.out.println("Order finalized with total amount: $" + totalAmount);
    }
}

// Class representing a customer
class Customer {

    private String customerName;
    private Cart cart;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void placeOrder() {
        Order order = new Order(cart);
        order.finalizeOrder();
        cart.clearCart();
    }
}

// Main class to demonstrate functionality
public class ShoppingCartSystem {

    public static void main(String[] args) {
        // Create products
        Product product1 = new Product(1, "Laptop", 1200.00);
        Product product2 = new Product(2, "Smartphone", 800.00);
        Product product3 = new Product(3, "Headphones", 150.00);

        // Create customer
        Customer customer = new Customer("John Doe");

        // Add products to cart
        customer.getCart().addProduct(product1);
        customer.getCart().addProduct(product2);

        // Display total price
        double total = customer.getCart().calculateTotalPrice();
        System.out.println("Total price: $" + total);

        // Apply discount
        customer.getCart().applyDiscount(10); // Applying a 10% discount

        // Remove a product
        customer.getCart().removeProduct(product2);

        // Finalize order
        customer.placeOrder();
    }
}
