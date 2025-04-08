package Inventory_Management;

public class OrderService {
    private Inventory inventory;
    public OrderService(Inventory inventory){
        this.inventory=inventory;
    }
    public boolean placeOrder(Order order){
        for(OrderItem item:order.getItems()){
            Product product=inventory.getProduct(item.getProduct().getPId());
            if(product==null || product.getQuantity()<item.getQuantity()){
                System.out.println("Insufficent Stock");
                return false;
            }
        }
        for(OrderItem item:order.getItems()){
            Product product=inventory.getProduct(item.getProduct().getPId());
            product.updateQuantity(-item.getQuantity());
        }
        order.fullfillOrder();
        System.out.println("Order fullfilled sucessfully"+order.getOId());
        return true;
    }
}
