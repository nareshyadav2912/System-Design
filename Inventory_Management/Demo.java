package Inventory_Management;

import java.util.Arrays;
public class Demo {
    public static void main(String[] args) {
        Supplier s1=new Supplier("1", "Naresh", "9182461001", "guntuku001@gmail.com", "Hyderabad");
        Product p1=new Product("1", "Teddy", "Teddy Bear", 2, 20, s1);
        Product p2=new Product("2", "Tom", "Tom and Jerry", 1, 30, s1);
        Inventory inventory=new Inventory();
        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.showInventory();

        OrderItem o1=new OrderItem(p1, 1);
        OrderItem o2=new OrderItem(p2, 3);
        Order order1=new Order("202", Arrays.asList(o1,o2),null, false);
        OrderService oService=new OrderService(inventory);
        oService.placeOrder(order1);
        System.out.println("After Order");
        inventory.showInventory();
    }
}
