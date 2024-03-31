import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestBloodData extends JFrame{
    public static BloodData p1 = new BloodData();
    public static BloodData p2 = new BloodData();

    public void info(BloodData x) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container Content = getContentPane();
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(5, 1));

        //title
        JLabel header = new JLabel("Blood Type Information");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        Panel.add(header);

        //Prompt and Text field
        JPanel QA = new JPanel();
        QA.setLayout(new FlowLayout());
        JLabel group = new JLabel("Enter Blood Group:");
        JTextField bGroup = new JTextField(2);

        //Prompt and Text field
        JPanel QA2 = new JPanel();
        QA2.setLayout(new FlowLayout());
        JLabel rh = new JLabel("Enter Rh Factor (+/-):");
        JTextField rhFactor = new JTextField(2);

        //Finalize
        JButton enter = new JButton("Press to Finalize");

        ActionListener Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == enter) {
                    String bGroupTex = bGroup.getText();
                    String rhTex = rhFactor.getText();

                    switch (bGroupTex) {
                        case "A":
                            x.setBloodLetter(BloodData.BloodGroup.A);
                            break;
                        case "B":
                            x.setBloodLetter(BloodData.BloodGroup.B);
                            break;
                        case "O":
                            x.setBloodLetter(BloodData.BloodGroup.O);
                            break;
                        case "AB":
                            x.setBloodLetter(BloodData.BloodGroup.AB);
                            break;
                        default:
                            x.setBloodLetter(BloodData.BloodGroup.O);
                            break;
                    }

                    switch (rhTex) {
                        case "+":
                            x.setPosNeg(BloodData.Rh.POSITIVE);
                            break;
                        case "-":
                            x.setPosNeg(BloodData.Rh.NEGATIVE);
                            break;
                        default:
                            x.setPosNeg(BloodData.Rh.POSITIVE);
                    }

                    System.out.println("Blood Type of Person 1:");
                    System.out.println("Blood Group: " + p1.getBloodLetter());
                    System.out.println("Rh Factor: " + p1.getPosNeg());

                    System.out.println("\nBlood Type of Person 2:");
                    System.out.println("Blood Group: " + p2.getBloodLetter());
                    System.out.println("Rh Factor: " + p2.getPosNeg());
                    dispose();

                    System.out.println("\n Updated Person 2: ");
                    TestBloodData TBD = new TestBloodData();
                    TBD.info(p2);
                }
            }
        };

        enter.addActionListener(Listener);

        QA.add(group);
        QA.add(bGroup);

        QA2.add(rh);
        QA2.add(rhFactor);

        Panel.add(QA);
        Panel.add(QA2);
        Panel.add(enter);

        Content.add(Panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        TestBloodData testBD = new TestBloodData();
        testBD.info(p1);
    }
}
