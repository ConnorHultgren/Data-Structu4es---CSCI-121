import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPatient extends JFrame {
    public static Patient p1 = new Patient();
    public static Patient p2 = new Patient();
    public static Patient p3 = new Patient();

    public void patientInfo(Patient p){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container Content = getContentPane();
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(7, 1));

        //title
        JLabel header = new JLabel("Patient Information");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        Panel.add(header);

        //Prompt and Text field
        JPanel QA1 = new JPanel();
        QA1.setLayout(new FlowLayout());
        JLabel idL = new JLabel("Enter ID Number:");
        JTextField idTF = new JTextField(6);

        //Prompt and Text field
        JPanel QA2 = new JPanel();
        QA2.setLayout(new FlowLayout());
        JLabel ageL = new JLabel("Enter Age:");
        JTextField ageTF = new JTextField(6);

        //Prompt and Text field
        JPanel QA3 = new JPanel();
        QA3.setLayout(new FlowLayout());
        JLabel group = new JLabel("Enter Blood Group:");
        JTextField bGroup = new JTextField(2);

        //Prompt and Text field
        JPanel QA4 = new JPanel();
        QA4.setLayout(new FlowLayout());
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
                    int ageTex = Integer.parseInt(ageTF.getText());
                    int idTex = Integer.parseInt(idTF.getText());

                    p.setAge(ageTex);
                    p.setID(idTex);

                    switch (bGroupTex) {
                        case "A":
                            p.getBlood().setBloodLetter(BloodData.BloodGroup.A);
                            break;
                        case "B":
                            p.getBlood().setBloodLetter(BloodData.BloodGroup.B);
                            break;
                        case "O":
                            p.getBlood().setBloodLetter(BloodData.BloodGroup.O);
                            break;
                        case "AB":
                            p.getBlood().setBloodLetter(BloodData.BloodGroup.AB);
                            break;
                        default:
                            p.getBlood().setBloodLetter(BloodData.BloodGroup.O);
                            break;
                    }

                    switch (rhTex) {
                        case "+":
                            p.getBlood().setPosNeg(BloodData.Rh.POSITIVE);
                            break;
                        case "-":
                            p.getBlood().setPosNeg(BloodData.Rh.NEGATIVE);
                            break;
                        default:
                            p.getBlood().setPosNeg(BloodData.Rh.POSITIVE);
                    }

                    System.out.println("\nPatient 1 Info:");
                    System.out.println("ID #: " + p1.getID());
                    System.out.println("Age: " + p1.getAge());
                    System.out.println("Blood Group: "+ p1.getBlood().getBloodLetter());
                    System.out.println("Rh Factor:" + p1.getBlood().getPosNeg());

                    System.out.println("\nPatient 2 Info:");
                    System.out.println("ID #: " + p2.getID());
                    System.out.println("Age: " + p2.getAge());
                    System.out.println("Blood Group: "+ p2.getBlood().getBloodLetter());
                    System.out.println("Rh Factor:" + p2.getBlood().getPosNeg());

                    System.out.println("\nPatient 3 Info:");
                    System.out.println("ID #: " + p3.getID());
                    System.out.println("Age: " + p3.getAge());
                    System.out.println("Blood Group: "+ p3.getBlood().getBloodLetter());
                    System.out.println("Rh Factor:" + p3.getBlood().getPosNeg());
                    dispose();
                    TestPatient TPp3 = new TestPatient();
                    TPp3.patientInfoNoB(p3);
                }
            }
        };

        enter.addActionListener(Listener);

        QA1.add(idL);
        QA1.add(idTF);

        QA2.add(ageL);
        QA2.add(ageTF);

        QA3.add(group);
        QA3.add(bGroup);

        QA4.add(rh);
        QA4.add(rhFactor);

        Panel.add(QA1);
        Panel.add(QA2);
        Panel.add(QA3);
        Panel.add(QA4);
        Panel.add(enter);

        Content.add(Panel);
        pack();
        setVisible(true);
    }

    public void patientInfoNoB(Patient p){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container Content = getContentPane();
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(7, 1));

        //title
        JLabel header = new JLabel("Patient Information");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        Panel.add(header);

        //Prompt and Text field
        JPanel QA1 = new JPanel();
        QA1.setLayout(new FlowLayout());
        JLabel idL = new JLabel("Enter ID Number:");
        JTextField idTF = new JTextField(6);

        //Prompt and Text field
        JPanel QA2 = new JPanel();
        QA2.setLayout(new FlowLayout());
        JLabel ageL = new JLabel("Enter Age:");
        JTextField ageTF = new JTextField(6);

        //Finalize
        JButton enter = new JButton("Press to Finalize");

        ActionListener Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == enter) {
                    int ageTex = Integer.parseInt(ageTF.getText());
                    int idTex = Integer.parseInt(idTF.getText());

                    p.setAge(ageTex);
                    p.setID(idTex);

                    System.out.println("\nPatient 1 Info:");
                    System.out.println("ID #: " + p1.getID());
                    System.out.println("Age: " + p1.getAge());
                    System.out.println("Blood Group: "+ p1.getBlood().getBloodLetter());
                    System.out.println("Rh Factor:" + p1.getBlood().getPosNeg());

                    System.out.println("\nPatient 2 Info:");
                    System.out.println("ID #: " + p2.getID());
                    System.out.println("Age: " + p2.getAge());
                    System.out.println("Blood Group: "+ p2.getBlood().getBloodLetter());
                    System.out.println("Rh Factor:" + p2.getBlood().getPosNeg());

                    System.out.println("\nPatient 3 Info:");
                    System.out.println("ID #: " + p3.getID());
                    System.out.println("Age: " + p3.getAge());
                    System.out.println("Blood Group: "+ p3.getBlood().getBloodLetter());
                    System.out.println("Rh Factor:" + p3.getBlood().getPosNeg());
                    dispose();
                }
            }
        };

        enter.addActionListener(Listener);

        QA1.add(idL);
        QA1.add(idTF);

        QA2.add(ageL);
        QA2.add(ageTF);

        Panel.add(QA1);
        Panel.add(QA2);
        Panel.add(enter);

        Content.add(Panel);
        pack();
        setVisible(true);
    }


    public static void main(String[] args){
        TestPatient TP = new TestPatient();
        TP.patientInfo(p2);
    }
}
