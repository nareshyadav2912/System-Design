package ECommerce;

public class CreditCardPayement implements Payment {
    @Override
    public boolean processPayement(double amount){
        return true;
    }
}
