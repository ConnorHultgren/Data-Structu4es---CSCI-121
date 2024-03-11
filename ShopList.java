import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopList extends JFrame{
    public class Item{
        private String item;
        private double cost;

        public Item (String item, double cost){
            this.item = item;
            this.cost = cost;
        }

        public String getItem() {return item;}
        public double getCost() {return cost;}
    }
    public class ItemOrder{
        private Item choice;
        private int amount;

        public ItemOrder (Item choice, int amount) {
            this.choice = choice;
            this.amount = amount;
        }

        public Item getChoice() {return choice;}
        public int getAmount() {return amount;}

    }



    //GUI to create list and price
    public class ShoppingList extends JFrame{
        ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();
        public ShoppingList(){

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container Content = getContentPane();
            JPanel Panel = new JPanel();
            Panel.setLayout(new GridLayout(6,1));

            //title
            JLabel header = new JLabel("Online List");
            header.setFont(new Font("Arial", Font.BOLD, 20));
            Panel.add(header);

            //Element Adder
            JPanel ad = new JPanel();
            ad.setLayout(new FlowLayout());

            JLabel type = new JLabel("Item:");
            ad.add(type);
            JTextField tex = new JTextField(8);
            ad.add(tex);

            JLabel type1 = new JLabel("Price:");
            ad.add(type1);
            JTextField tex1 = new JTextField(4);
            ad.add(tex1);

            JLabel type2 = new JLabel("Quantity:");
            ad.add(type2);
            JTextField tex2 = new JTextField(3);
            ad.add(tex2);

            Panel.add(ad);


            //add button
            JPanel adbutton = new JPanel();
            adbutton.setLayout(new FlowLayout());

            JButton adlist = new JButton("Add to List");

            adbutton.add(adlist);
            Panel.add(adbutton);


            //remove button
            JPanel rembutton = new JPanel();
            rembutton.setLayout(new FlowLayout());

            JButton remlist = new JButton("Remove Last Item");

            rembutton.add(remlist);
            Panel.add(rembutton);


            //search
            JPanel sbutton = new JPanel();
            sbutton.setLayout(new FlowLayout());

            JTextField search = new JTextField(9);
            JButton slist = new JButton("Search Item");

            sbutton.add(search);
            sbutton.add(slist);
            Panel.add(sbutton);

            //show in console
            JPanel show = new JPanel();
            show.setLayout(new FlowLayout());

            JButton calc = new JButton("Show List and Calculate Cost");
            show.add(calc);
            Panel.add(show);


            ActionListener Listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (ae.getSource() == slist) {
                        //match the text to the item of itemOrder
                        String s = search.getText();
                        boolean found = false;

                        for (int x = 0; x < list.size(); x++){
                            if (list.get(x).getChoice().getItem() == s){
                                found = true;
                                System.out.println("Found:");
                                System.out.println(list.get(x).getChoice().getItem() + " for " + list.get(x).getChoice().getCost() + " " + list.get(x).getAmount() + " times");
                            }
                        }
                        if (found == false){
                            System.out.println("Item not Found");
                        }

                    }
                    if (ae.getSource() == remlist) {
                        //remove the last thing added (itemOrder from array)
                        int x = list.size();
                        list.remove(list.get(x-1));
                    }

                    if (ae.getSource() == adlist) {
                        //add another item order to the array
                        String name = tex.getText();
                        double price = Double.parseDouble(tex1.getText());
                        int quant = Integer.parseInt(tex2.getText());

                        Item item = new Item(name, price);
                        ItemOrder Ord = new ItemOrder(item, quant);
                        list.add(Ord);

                    }

                    if (ae.getSource() == calc) {
                        int i = 0;
                        double total = 0;
                        System.out.println("Your Shopping List:");
                        while (i < list.size()){
                            System.out.println(list.get(i).getAmount() + " of " + list.get(i).getChoice().getItem() + " (Individually $" + list.get(i).getChoice().getCost() + ")");
                            total += (list.get(i).getChoice().getCost())*(list.get(i).getAmount());
                            i++;
                        }
                        System.out.println("The Cost: $"+ total);

                    }
                }
            };

            slist.addActionListener(Listener);
            remlist.addActionListener(Listener);
            adlist.addActionListener(Listener);
            calc.addActionListener(Listener);

            Content.add(Panel);

            pack();
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        ShopList SL = new ShopList();
        ShoppingList List = SL.new ShoppingList();
    }
}
