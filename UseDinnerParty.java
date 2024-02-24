import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;


public class UseDinnerParty extends JFrame{
    int Width = 250;
    int Height = 500;
    int gNum;
    int fNum;
    String food;
    public void UP(){
        setSize(Width,Height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container Content = getContentPane();
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(3,1));

        //title
        JLabel header = new JLabel("Party");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        Panel.add(header);

        //Prompt and Text field
        JPanel QA = new JPanel();
        QA.setLayout(new GridLayout(1,2));
        JLabel guest = new JLabel("Enter # of Guests:");
        JTextField Num = new JTextField();

        //Finalize
        JButton enter = new JButton("Press to Finalize");

        ActionListener Listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if (ae.getSource() == enter){
                    String text = Num.getText();
                    gNum = parseInt(text);
                    System.out.println("The party has " + gNum + " guests");
                    dispose();

                    Party party = new Party();
                    party.setGuestNum(gNum);
                    party.displayInvitation();
                }
            }
        };

        enter.addActionListener(Listener);

        QA.add(guest);
        QA.add(Num);
        Panel.add(QA);

        Panel.add(enter);
        Content.add(Panel);

        pack();
        setVisible(true);

    }


    //Dinner Party
    public void UDP(){
        setSize(Width,Height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container Content = getContentPane();
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(4,1));

        //title
        JLabel header = new JLabel(" Dinner Party");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        Panel.add(header);

        //Prompt and Text field
        JPanel QA = new JPanel();
        QA.setLayout(new GridLayout(1,2));
        JLabel guest = new JLabel("Enter # of Guests:");
        JTextField Num = new JTextField();

        //Meal Choice
        JPanel Food = new JPanel();
        Food.setLayout(new GridLayout(1,2));
        JLabel Op = new JLabel("Enter Option (1 for Barbeque, 2 for Italian):");
        JTextField NumOp = new JTextField();

        //Finalize
        JButton enter = new JButton("Press to Finalize");

        ActionListener Listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if (ae.getSource() == enter){
                    String text = Num.getText();
                    gNum = parseInt(text);

                    String text2 = NumOp.getText();
                    fNum = parseInt(text2);
                    if (fNum ==1){
                        food = "Barbeque";
                    }
                    if (fNum ==2){
                        food = "Italian";
                    }
                    else{
                        food = "Salmon";
                    }

                    System.out.println("The party has " + gNum + " guests");
                    System.out.println("Menu option 2 (" + food + ") will be served");
                    dispose();

                    DinnerParty Dparty = new DinnerParty();
                    Dparty.setGuestNum(gNum);
                    Dparty.setdinnerChoice(fNum);
                    Dparty.displayInvitation();
                }
            }
        };

        enter.addActionListener(Listener);

        QA.add(guest);
        QA.add(Num);
        Panel.add(QA);

        Food.add(Op);
        Food.add(NumOp);
        Panel.add(Food);


        Panel.add(enter);
        Content.add(Panel);

        pack();
        setVisible(true);

    }

    private void DinnerGUI(){
        UseDinnerParty d = new UseDinnerParty();
        d.UDP();
    }

    public static void main (String[] args){
        UseDinnerParty Gui = new UseDinnerParty();
        Gui.UP();
        Gui.DinnerGUI();
    }

}
