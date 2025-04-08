package Inventory_Management;

public class Supplier {
    private String sid;
    private String sname;
    private String scontact;
    private String semail;
    private String saddress;

    public Supplier(String sid,String sname,String scontact,String semail,String saddress){
        this.sid=sid;
        this.sname=sname;
        this.scontact=scontact;
        this.semail=semail;
        this.saddress=saddress;
    }
    public String getScontact() {
        return scontact;
    }
    public String getSemail() {
        return semail;
    }
    public String getSaddress() {
        return saddress;
    }
    public String getSId(){
        return sid;
    }
    public String getSname(){
        return sname;
    }
    
}
