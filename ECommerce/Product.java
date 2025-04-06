package ECommerce;

public class Product {
    private final String id;
    private final String productName;
    private final String description;
    private int quantity;
    private final double price;

    public Product(String id,String productName,String description,int quantity,double price){
        this.id=id;
        this.description=description;
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return productName;
    }

    public String getDescription(){
        return description;
    }
    
    public int getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }

    public synchronized void updateQuantity(int quantity){
        this.quantity+=quantity;
    }

    public synchronized boolean isAvalaible(int quantity){
        return this.quantity>=quantity;
    }
}
