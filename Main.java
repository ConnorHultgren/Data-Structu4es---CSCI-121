import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static double[] list = new double[20];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double n;
        int i = 0;

        while (i < 20){

            n = sc.nextDouble();
            list[i] = n;

            if (n == 99999){
                break;
            }

            System.out.println(Arrays.toString(list));
            i += 1;
        }


        if (i == 1){
            System.out.println("Error: No Values Entered");
        }
    }
}