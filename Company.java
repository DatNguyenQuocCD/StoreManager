import java.util.ArrayList;

public class Company {
    private int id;
    private String nameCompany;
    private String address;
    private String email;
    private String phone;
    private ArrayList <Items> listItems= new ArrayList<Items>();
    
    public Company(int id,String nameCompany, String address, String email, String phone){
        this.id=id;
        this.nameCompany=nameCompany;
        this.address=address;
        this.email=email;
        this.phone=phone;
    }
    public void setId(int id){
        if(id>0){
            this.id=id;
        }
    }
    public void setNameCompany(String nameCompany){
        this.nameCompany=nameCompany;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    int getId (){
        return id;
    }
    String getNameCompany(){
        return nameCompany;
    }
    String getAddress(){
        return address;
    }
    String getEmail(){
        return email;
    }
    String getPhone(){
        return phone;
    }
    ArrayList <Items> getListItems(){
        return listItems;
    }
    
}
