import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoPizza extends JFrame {
    JLabel PizzaOrder = new JLabel("Pizza Online Order");
    Font header = new Font("Dialog", Font.BOLD, 15);

    JLabel entTop = new JLabel("Enter Toppings:");
    JTextField tppng = new JTextField(10);
    JButton enter = new JButton("Add To Toppings");

    JButton deliv = new JButton("Calculate for Delivery:");
    JButton pick = new JButton("Calculate for Pick-up:");

    JLabel[] toppingLabels = new JLabel[10];
    String[] topList = new String[10];
    int topNum = 0;

    public void GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container Cp = getContentPane();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12, 1));

        PizzaOrder.setFont(header);
        mainPanel.add(PizzaOrder);

        entTop.setFont(header);
        mainPanel.add(entTop);
        mainPanel.add(tppng);

        mainPanel.add(enter);

        for (int i = 0; i < 10; i++) {
            toppingLabels[i] = new JLabel("");
            mainPanel.add(toppingLabels[i]);
        }


        JPanel p4 = new JPanel();
        JTextField addy = new JTextField("Address Here");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(pick);
        buttonPanel.add(deliv);
        mainPanel.add(buttonPanel);

        Cp.add(mainPanel);
        pack();
        setVisible(true);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String text = tppng.getText().trim();
                if (!text.isEmpty()) {
                    if (topNum < 10) {
                        topList[topNum] = text;
                        tppng.setText("");
                        topNum++;

                        JLabel topLabel = new JLabel(text);
                        toppingLabels[topNum - 1].setText(text); 
                    }
                }
            }
        });

        deliv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Address = JOptionPane.showInputDialog("Enter delivery address:");
                DeliveryPizza deliveryPizza = new DeliveryPizza(topList, Address, topNum);

                System.out.println("Delivery Fee: $" + deliveryPizza.getDFee());
                double totalPrice = deliveryPizza.getPrice() + deliveryPizza.getDFee();
                System.out.println("Total Price: $" + totalPrice);

                System.out.println("Delivery Address: " + deliveryPizza.getDAdd());
            }
        });

        pick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pizza pizza = new Pizza(topList, topNum);
            }
        });
    }

    public static void main(String[] args){
        DemoPizza plan = new DemoPizza();
        plan.GUI();
    }
}
