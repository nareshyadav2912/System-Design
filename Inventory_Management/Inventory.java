package Inventory_Management;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private final Map<String,Product> hm=new ConcurrentHashMap<>();
    public void addProduct(Product product){
        hm.put(product.getPId(),product);
    }
    public void removeProduct(String productId){
        hm.remove(productId);
    }
    public Product getProduct(String productId){
        return hm.get(productId);
    }
    public List<Product> getLowStockProducts(int threeshold){
        return hm.values().stream().filter(p->p.getQuantity()<threeshold).collect(Collectors.toList());
    }
    public void showInventory(){
        for(Product p:hm.values()){
            System.out.println(p.getPName()+" "+ p.getQuantity());
        }
    }
}
