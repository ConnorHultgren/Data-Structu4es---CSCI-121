public class Pizza {
    private double price;
    private String[] topList;

    public Pizza(String[] topList, int topNum) {
        this.topList = new String[topNum];
        price = 14 + (2 * topNum);
        if (topList != null && topList.length > 0) {
            StringBuilder topStr = new StringBuilder();
            for (int i = 0; i < topList.length; i++) {
                if (topList[i] != null) {
                    topStr.append(topList[i]);
                    if (i < topList.length - 1 && topList[i + 1] != null) {
                        topStr.append(", ");
                    }
                }
            }
            if (topStr.length() > 0) {
                System.out.println("Added Pizza Toppings: " + topStr.toString());
            }
        }
        System.out.println("Price: $" + price);
    }

    public String getTopStr(){
        StringBuilder topStr = new StringBuilder();
        for (int i = 0; i < topList.length; i++){
            topStr.append(topList[i]);
            if (i< topList.length-1){
                topStr.append(", ");
            }
        }
        return topStr.toString();
    }

    public double getPrice() {
        return price;
    }
}