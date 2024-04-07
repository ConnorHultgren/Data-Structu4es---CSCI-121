//Creates the data class that will hold...data
public class Data {
    private String color;
    private int num;

    public Data(String color, int num){
        this.color = color;
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Data{" +
                "color ='" + color + '\'' +
                ", number =" + num +
                '}';
    }
}

