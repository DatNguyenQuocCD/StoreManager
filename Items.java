

public class Items {
    private int id;
    private String name;
    private int amount;
    private float importPrice;
    private float saleprice;
    private float totalMoney;
    private float totalAmountAfterPromotion;
    public Items(int id, String name, int amount, Float importPrice, Float saleprice, float totalMoney, float totalAmountAfterPromotion){
        this.id=id;
        this.name=name;
        this.amount=amount;
        this.importPrice=importPrice;
        this.saleprice=saleprice;
        this.totalMoney=totalMoney;
        this.totalAmountAfterPromotion=totalAmountAfterPromotion;
    }
    public Items(String name,int amount){
        this.name=name;
        this.amount=amount;
    }
    public void setId(int id){
        if(id>0){
            this.id=id;
        }
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAmount(int amount){
        if(amount>=0){
            this.amount=amount;
        }
    }
    public void setImportPrice(Float importPrice){
        if(importPrice>0){
            this.importPrice=importPrice;
        }
    }
    public void setSaleprice(Float saleprice){
        if(saleprice>0){
            this.saleprice=saleprice;
        }
    }
    public void setTotalMoney(float totalMoney){
        if(totalMoney>0){
            this.totalMoney=totalMoney;
        }
    }
    public void setTotalAmountAfterPromotison(float totalAmountAfterPromotion){
        if(totalAmountAfterPromotion>0){
            this.totalAmountAfterPromotion=totalAmountAfterPromotion;
        }
    }
    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    int getAmount(){
        return amount;
    }
    float getImportPrice(){
        return importPrice;
    }
    float getSaleprice(){
        return saleprice;
    }
    float getTotalMoney(){
        return totalMoney;
    }
    float getTotalAmountAfterPromotion(){
        return totalAmountAfterPromotion;
    }
    //tinh tong tien nhap
    public float totalMoney(){
        return amount*importPrice;
    }
    // phuong thuc nap chong tinh tong tien nhap sau khi giam gia
    public float totalMoney( float percent ){
        return totalMoney() - (totalMoney()/100 *percent);
    }
    // phuong thuc tinh tien order
}
