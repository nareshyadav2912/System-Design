package Inventory_Management;

import java.util.List;
import java.util.Date;
public class Order {
    private String oid;
    private List<OrderItem> items;
    private Date orderDate;
    private boolean fullfilled;

    public Order(String oid,List<OrderItem> items,Date orderDate,boolean fullfilled){
        this.oid=oid;
        this.items=items;
        this.orderDate=orderDate;
        this.fullfilled=false;
    }
    public String getOId(){
        return oid;
    }
    public List<OrderItem> getItems(){
        return items;
    }
    public boolean isFullfiller(){
        return fullfilled;
    }
    public Date getODate(){
        return orderDate;
    }
    public void fullfillOrder(){
        this.fullfilled=true;
    }
}
