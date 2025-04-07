package ECommerce;

import java.util.Map;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ShoppingService {
    private static ShoppingService instance;
    private final Map<String,User> users;
    private final Map<String,Product> products;
    private final Map<String,order> orders;
    
    private ShoppingService(){
        users=new ConcurrentHashMap<>();
        products=new ConcurrentHashMap<>();
        orders=new ConcurrentHashMap<>();
    }

    public static synchronized ShoppingService getInstance(){
        if(instance==null){
            instance=new ShoppingService();
        }
        return instance;
    }

    public void registerUser(User user){
        users.put(user.getId(), user);
    }

    public User getUser(String userId){
        return users.get(userId);
    }
    
    public void addProduct(Product product){
        products.put(product.getId(),product);
    }

    public Product getProduct(String productId){
        return products.get(productId);
    }

    public List<Product> searchProducts(String keyword){
        return products.values().stream()
        .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
        .collect(Collectors.toList());
    }

    public synchronized order placeOrder(User user, ShoppingCart cart,Payment payment){
        List<OrderItem> orderItems=new ArrayList<>();
        String orderId=generateOrderId();
        order order=new order(orderId, user, orderItems);
        for(OrderItem item: cart.getItems()){
            Product product=item.getProduct();
            int quantity=item.getQuantity();
            if(product.isAvalaible(quantity)){
                product.updateQuantity(-quantity);
                orderItems.add(item);
                order.setPaymentStatus(paymentStatus.SUCESS);
            }
        }

        if(orderItems.isEmpty()){
            throw new IllegalStateException("No Products in the Cart");
        }
        orders.put(orderId, order);
        user.addOrder(order);
        cart.clear();
        if(payment.processPayement(order.getTotalAmount())){
            order.setStatus(orderStatus.PROCESSING);
            order.setPaymentStatus(paymentStatus.IN_PROGRESS);
        }else{
            order.setStatus(orderStatus.CANCELLED);
            order.setPaymentStatus(paymentStatus.FAILURE);
            for(OrderItem item:orderItems){
                Product product=item.getProduct();
                int quantity=item.getQuantity();
                product.updateQuantity(quantity);
            }
        }
        return order;
    }
    public order getOrder(String orderId){
        return orders.get(orderId);
    }
    public String generateOrderId(){
        return "ORDER" + UUID.randomUUID().toString().substring(0,8).toLowerCase();
    }
}
