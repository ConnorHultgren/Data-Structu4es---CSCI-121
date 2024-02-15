import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    int Width = 400;
    int Height = 700;
    String TofPiz;
    double SizeP = 0.00;
    double TopAmt = 0;
    double TopP = 0.00;
    double Total;

    public Main() {
        setSize(Width,Height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //GUI Header
        Container cp1 = getContentPane();
        cp1.setLayout(new BorderLayout());
        JLabel header = new JLabel("Big Y Pizza Order");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        cp1.add(header, BorderLayout.NORTH);

        //Grid Layout Within Center
        JPanel Bpanel = new JPanel();
        Bpanel.setLayout(new GridLayout(9,1));
        Bpanel.setBorder(new EmptyBorder(10,10,10,10));
        cp1.add(Bpanel, BorderLayout.CENTER);

        //Pictures
        JPanel pics = new JPanel(new GridLayout(2,2));
        ImageIcon CheP = new ImageIcon("Cheese-pizza.jpg");
        JLabel ChePL = new JLabel(CheP);
        ImageIcon PepP = new ImageIcon("pepperoni-pizza.jpg");
        JLabel PepPL = new JLabel(PepP);
        ImageIcon VegP = new ImageIcon("veggie-pizza.jpeg");
        JLabel VegPL = new JLabel(VegP);
        ImageIcon HIP = new ImageIcon("hawaiian-pizza.jpg");
        JLabel HIPL = new JLabel(HIP);

        pics.add(ChePL);
        pics.add(PepPL);
        pics.add(VegPL);
        pics.add(HIPL);
        Bpanel.add(pics);

        //Type Label
        JLabel Type = new JLabel("Type:");
        Bpanel.add(Type);

        //Type Selection Panel
        JPanel panel1 = new JPanel(new FlowLayout());
        JRadioButton Che = new JRadioButton("Cheese");
        JRadioButton Pep = new JRadioButton("Pepperoni");
        JRadioButton Veg = new JRadioButton("Veggie");
        JRadioButton HI = new JRadioButton("Hawaiian");

        ActionListener TypList = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae2){
                if (Che.isSelected()){
                    TofPiz = "Cheese";
                }
                if (Pep.isSelected()){
                    TofPiz = "Pepperoni";
                }
                if (Veg.isSelected()){
                    TofPiz = "Veggie";
                }
                if (HI.isSelected()){
                    TofPiz = "Hawaiian";
                }
            }
        };

        //Apply listener
        Che.addActionListener(TypList);
        Pep.addActionListener(TypList);
        Veg.addActionListener(TypList);
        HI.addActionListener(TypList);

        ButtonGroup choice1 = new ButtonGroup();
        choice1.add(Che);
        choice1.add(Pep);
        choice1.add(Veg);
        choice1.add(HI);

        panel1.add(Che);
        panel1.add(Pep);
        panel1.add(Veg);
        panel1.add(HI);
        Bpanel.add(panel1);



        //Size Label
        JLabel Size = new JLabel("Size:");
        Bpanel.add(Size);

        //Size Selection Panel
        JPanel panel2 = new JPanel(new FlowLayout());
        JRadioButton Sm = new JRadioButton("Small ($5)");
        JRadioButton Md = new JRadioButton("Medium ($10)");
        JRadioButton Lg = new JRadioButton("Large ($15)");
        JRadioButton Sp = new JRadioButton("Super ($20)");

        ActionListener SRBList = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae2){
                if (Sm.isSelected()){
                    SizeP += 5;
                }
                if (Md.isSelected()){
                    SizeP += 10;
                }
                if (Lg.isSelected()){
                    SizeP += 15;
                }
                if (Sp.isSelected()){
                    SizeP += 20;
                }
            }
        };

        //Apply listener
        Sm.addActionListener(SRBList);
        Md.addActionListener(SRBList);
        Lg.addActionListener(SRBList);
        Sp.addActionListener(SRBList);

        ButtonGroup choice2 = new ButtonGroup();
        choice2.add(Sm);
        choice2.add(Md);
        choice2.add(Lg);
        choice2.add(Sp);

        panel2.add(Sm);
        panel2.add(Md);
        panel2.add(Lg);
        panel2.add(Sp);
        Bpanel.add(panel2);



        //Toppings Label
        JLabel Top = new JLabel("3 Optional Toppings ($0.50 per, 3 for $1.20):");
        Bpanel.add(Top);

        //Toppings List
        JPanel panel3 = new JPanel(new FlowLayout());
        JCheckBox XCH = new JCheckBox("Extra Cheese (FREE)");
        JCheckBox Bacon = new JCheckBox("Bacon");
        JCheckBox Olives = new JCheckBox("Olives");
        JCheckBox Tom = new JCheckBox("Tomato");
        JCheckBox Mush = new JCheckBox("Mushrooms");


        ActionListener ToppingList = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                TopAmt = 0;
                if (Bacon.isSelected()) {
                    TopAmt++;
                }
                if (Olives.isSelected()){
                    TopAmt++;
                }
                if (Tom.isSelected()){
                    TopAmt++;
                }
                if (Mush.isSelected()){
                    TopAmt++;
                }
                if (TopAmt == 1){
                    TopP = .5;
                }
                if (TopAmt == 2){
                    TopP = 1.0;
                }
                if (TopAmt == 3){
                    TopP = 1.25;
                }
            }

        };

        //Apply listener
        XCH.addActionListener(ToppingList);
        Bacon.addActionListener(ToppingList);
        Tom.addActionListener(ToppingList);
        Olives.addActionListener(ToppingList);
        Mush.addActionListener(ToppingList);

        panel3.add(XCH);
        panel3.add(Bacon);
        panel3.add(Olives);
        panel3.add(Tom);
        panel3.add(Mush);
        Bpanel.add(panel3);



        //Amount
        JPanel panel4 = new JPanel(new FlowLayout());
        JLabel Amt = new JLabel("Additional Instructions:");
        JTextField n = new JTextField(20);
        panel4.add(Amt);
        panel4.add(n);
        Bpanel.add(panel4);

        //Place Order
        JButton button = new JButton("Place Your Order");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Total = SizeP + TopP;
                String m = n.getText();
                System.out.println("$" + Total + " for your " + TofPiz + " Pizza");
                System.out.println("Instructions: " + m);
                dispose();
            }
        });
        Bpanel.add(button);

        pack();
        setVisible(true);
    }


    public static void main (String[] args) {
        Main PizzaOrder = new Main();
    }
}
