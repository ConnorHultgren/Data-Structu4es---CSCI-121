import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class TestWedding extends JFrame{
    int Width = 250;
    int Height = 500;
    public int dayN;
    public int monthN;
    public int yearN;
    public LocalDate formatDate;
    public void planner(){

        setSize(Width,Height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container Content = getContentPane();
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(6,1));

        //title
        JLabel header = new JLabel("Wedding Info");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        Panel.add(header);

        //Prompt and Text field for p1
        JPanel QA = new JPanel();
        QA.setLayout(new FlowLayout());
        JLabel per1 = new JLabel("Enter First and Last Name of Person #1:");
        JTextField First = new JTextField(10);
        JTextField Last = new JTextField(10);

        //Prompt and Text field for p2
        JPanel QA1 = new JPanel();
        QA1.setLayout(new FlowLayout());
        JLabel per2 = new JLabel("Enter First and Last Name of Person #2:");
        JTextField First2 = new JTextField(10);
        JTextField Last2 = new JTextField(10);

        //Prompt and Text field for location
        JPanel local = new JPanel();
        local.setLayout(new FlowLayout());
        JLabel donde = new JLabel("Enter Name of Venue:");
        JTextField spot = new JTextField(20);

        //Prompt and Text field for date
        JPanel when = new JPanel();
        when.setLayout(new FlowLayout());
        JLabel date = new JLabel("The Date:");
        JLabel month = new JLabel("Month:");
        JTextField mon = new JTextField("00",2);
        JLabel day= new JLabel("Day:");
        JTextField dy = new JTextField("00",2);
        JLabel year = new JLabel("Year:");
        JTextField yr = new JTextField("0000",4);

        //Finalize
        JButton enter = new JButton("Press to Finalize");

        ActionListener Listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if (ae.getSource() == enter){

                    //Catching improper date entries
                    try {
                        //create location
                        String location = spot.getText();


                        //create date
                        dayN = parseInt(dy.getText());
                        monthN = parseInt(mon.getText());
                        yearN = parseInt(yr.getText());


                        //create couple
                        String p01first = First.getText();
                        String p01last = Last.getText();
                        String p02first = First2.getText();
                        String p02last = Last2.getText();

                        Couple couple = new Couple(new Person(p01first, p01last),new Person(p02first, p02last));


                        //create date
                        formatDate = LocalDate.of(yearN, monthN, dayN);

                        Wedding wedding = new Wedding(location, formatDate, couple);
                    } catch (NumberFormatException e){
                        System.out.println("Invalid Input Entered");
                    }

                    System.out.println("The Wedding of " + First.getText() + " and " + First2.getText());
                    System.out.println("On " + formatDate);
                    System.out.println("At " + spot.getText());

                    dispose();
                }
            }
        };

        enter.addActionListener(Listener);

        QA.add(per1);
        QA.add(First);
        QA.add(Last);

        QA1.add(per2);
        QA1.add(First2);
        QA1.add(Last2);

        local.add(donde);
        local.add(spot);

        when.add(date);
        when.add(month);
        when.add(mon);
        when.add(day);
        when.add(dy);
        when.add(year);
        when.add(yr);

        Panel.add(QA);
        Panel.add(QA1);
        Panel.add(local);
        Panel.add(when);

        Panel.add(enter);
        Content.add(Panel);

        pack();
        setVisible(true);
    }
    public static void main(String[] args){
        TestWedding plan = new TestWedding();
        plan.planner();
    }
}


//// Date: parse int, try/catch for if it is a number at all, if statement to tell if it is within a certain range