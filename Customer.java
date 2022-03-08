

import java.util.ArrayList;

public class Customer{
    private int id;
    private String customerName;
    private String phone;
    private String purchaseDate;
    private ArrayList <Order> listOrder=new ArrayList<Order>();
    public Customer(int id, String customerName, String phone, String purchaseDate){
        this.id=id;
        this.customerName=customerName;
        this.phone=phone;
        this.purchaseDate=purchaseDate;
    }
    public void setId(int id){
        if (id>0){
            this.id=id;
        }
    }
    public void setCustomerName( String customerName){
        this.customerName=customerName;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate=purchaseDate;
    }
    int getId(){
        return id;
    }
    String getCustomerName(){
        return customerName;
    }
    String getPhone(){
        return phone;
    }
    ArrayList <Order> getListOrder(){
        return listOrder;
    }
    String getPurchaseDate(){
        return purchaseDate;
    }
}
