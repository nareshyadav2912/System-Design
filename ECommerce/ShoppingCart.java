package ECommerce;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class ShoppingCart {
    private final Map<String, OrderItem> items;

    public ShoppingCart(){
        this.items=new HashMap<>();
    }
    
    public void addItem(Product product,int quantity){
        String productdId=product.getId();
        if(items.containsKey(productdId)){
            OrderItem orderItem=items.get(productdId);
            quantity+=orderItem.getQuantity();
        }
        items.put(productdId,new OrderItem(product, quantity));
    }

    public void removeItem(String productId){
        items.remove(productId);
    }

    public void updateQuantity(String productId,int quantity){
        OrderItem item=items.get(productId);
        if(item!=null){
            items.put(productId, new OrderItem(item.getProduct(), quantity));
        }
    }
    
    public List<OrderItem> getItems(){
        return new ArrayList<>(items.values());
    }

    public void clear(){
        items.clear();
    }
}
