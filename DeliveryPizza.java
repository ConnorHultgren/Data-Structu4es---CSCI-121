public class DeliveryPizza extends Pizza{
    private String dAdd;
    private double dFee;

    public DeliveryPizza(String[] topList, String dAdd, int topNum ){
        super(topList, topNum);
        this.dAdd = dAdd;

        if (getPrice() > 18){
            dFee = 3;

        } else{
            dFee = 5;
        }
    }

    public String getDAdd(){
        return dAdd;
    }

    public double getDFee(){
        return dFee;
    }
}
