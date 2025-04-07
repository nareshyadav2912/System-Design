package ECommerce;
import java.util.*;

public class order {
    private final String id;
    private final User user;
    private final List<OrderItem> items;
    private final double totalAmount;
    private orderStatus Ostatus;
    private paymentStatus Pstatus;

    public order(String id, User user,List<OrderItem> items){
        this.id=id;
        this.user=user;
        this.items=items;
        this.totalAmount=calculateTotalAmount();
        this.Ostatus=orderStatus.PENDING;
        this.Pstatus=paymentStatus.IN_PROGRESS;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setStatus(orderStatus orderStatus){
        this.Ostatus=orderStatus;

    }
    public void setPaymentStatus(paymentStatus paymentStatus){
        this.Pstatus=paymentStatus;
    }
    public orderStatus getOstatus() {
        return Ostatus;
    }

    public paymentStatus getPstatus() {
        return Pstatus;
    }

    //implememt this
    public double calculateTotalAmount(){
        return items.stream().mapToDouble(item -> item.getProduct().getPrice()*item.getQuantity()).sum();
    }
}
