import java.util.Scanner;

public class ChallengeExample {
    static int num;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            num = scan.nextInt();
        } catch (Exception e){
            System.out.println("Please Enter an Integer Value");
        }

        double x = Math.sqrt(num);
        if (Double.isNaN(x)) {
            System.out.println("Error: Value Must be Greater Than 0");
        }
        else{
            System.out.println("The Square Root is: " + x);
        }
    }
}
