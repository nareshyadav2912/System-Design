package ECommerce;

import java.util.*;

public class User {
    private final String id;
    private final String userName;
    private final String password;
    private final String email;
    private final List<order> orders;

    public User(String id,String userName,String password,String email){
        this.id=id;
        this.userName=userName;
        this.password=password;
        this.email=email;
        this.orders=new ArrayList<>();
    }

    public String getId(){
        return id;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public List<order> getOrders(){
        return orders;
    }
}

