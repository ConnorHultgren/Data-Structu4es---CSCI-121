import java.lang.Math;
import java.util.Scanner;

public class RPS {
    static String compChoice;
    static String winner;
    static String input;
    public enum Choice {ROCK,PAPER,SCISSORS}

    public static void main(String[] args) {
        double randChoice = (Math.random() * 3);
        if (randChoice < 1){
            compChoice = String.valueOf(Choice.ROCK);
        } else if (randChoice < 2 && randChoice >= 1){
            compChoice = String.valueOf(Choice.PAPER);
        }else{
            compChoice = String.valueOf(Choice.SCISSORS);
        }

        System.out.println("Rock, Paper, Scissors!");
        System.out.println("Choose \"R\", \"P\", or \"S\"");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();

        switch(input){

            case "R":
                input = String.valueOf(Choice.ROCK);
                if (compChoice == input)
                {
                    winner = "Tie";
                }
                else if (compChoice == String.valueOf(Choice.PAPER))
                {
                    winner = "Computer Wins";
                }
                else{
                    winner = "You Win";
                }
                break;

            case "P":
                input = String.valueOf(Choice.PAPER);
                if (compChoice == input)
                {
                    winner = "Tie";
                }
                else if (compChoice == String.valueOf(Choice.SCISSORS))
                {
                    winner = "Computer Wins";
                }
                else{
                    winner = "You Win";
                }
                break;

            case "S":
                input = String.valueOf(Choice.SCISSORS);
                if (compChoice == input)
                {
                    winner = "Tie";
                }
                else if (compChoice == String.valueOf(Choice.ROCK))
                {
                    winner = "Computer Wins";
                }
                else{
                    winner = "You Win";
                }
                break;
        }

        System.out.println("User Chose: " + input);
        System.out.println("Computer Chose: " + compChoice);
        System.out.println(winner);

    }
}