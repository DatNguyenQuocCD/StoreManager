public class Order extends Items {
    private float totalMoney;
    public Order(String name, int amount,float totalMoney){
        super(name, amount);
        this.totalMoney=totalMoney;
    }
    public void setTotalMoney(float totalMoney){
        this.totalMoney=totalMoney;
    }
    float getTotalMoney(){
        return totalMoney;
    }
}

