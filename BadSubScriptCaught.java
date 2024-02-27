import java.util.Scanner;

public class BadSubScriptCaught{

    public static void main(String[] args) {
        String[] Names10 = {"Aaron", "Betsy", "Cameron", "Dylan", "Ella", "Francis", "Guy", "Harold", "Isla", "Jacob"};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        try{
            System.out.println(Names10[n]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Input Not a Valid Index");
        }


    }
}