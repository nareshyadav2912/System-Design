package Inventory_Management;

public class Product {
    private String pid;
    private String pname;
    private String pdescription;
    private int quantity;
    private double price;
    private Supplier supplier;
    private final Object lock=new Object();

    public Product(String pid,String pname,String pdescription,int quantity,double price,Supplier supplier){
        this.pid=pid;
        this.pname=pname;
        this.pdescription=pdescription;
        this.quantity=quantity;
        this.price=price;
        this.supplier=supplier;
    }

    public String getPId(){
        return pid;
    }
    public String getPName(){
        return pname;
    }
    public String getDescription(){
        return pdescription;
    }
    public double getPrice(){
        return price;
    }
    public Supplier getSupplier(){
        return supplier;
    }

    public boolean updateQuantity(int newQauntity){
        synchronized(lock){
            if(quantity>=newQauntity){
                quantity-=newQauntity;
                return true;
            }else{
                return false;
            }
        }
        //return false;
    }
    public void addQuantity(int newQauntity){
        synchronized(lock){
            quantity+=newQauntity;
        }
    }
    public int getQuantity(){
        synchronized(lock){
            return quantity;
        }
    }
}
