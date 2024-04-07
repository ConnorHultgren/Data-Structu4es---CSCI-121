import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestDataLinkedList extends JFrame {

    private DataLinkedList linkedList;

    public TestDataLinkedList() {
        linkedList = new DataLinkedList(); //intance of DLL with three nodes
        linkedList.insertNode(new Data("Red", 1));
        linkedList.insertNode(new Data("Green", 2));
        linkedList.insertNode(new Data("Blue", 3));
    }

    public void GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        //title
        JLabel header = new JLabel("Linked List: Data(Str color, int num)");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(header);

        //Current List
        JPanel listPanel = new JPanel();
        JLabel listLabel = new JLabel("Current list:");
        JLabel listContent = new JLabel(linkedList.getListAsString());
        listPanel.add(listLabel);
        listPanel.add(listContent);
        panel.add(listPanel);

        //remove after method application
        JPanel raPanel = new JPanel();
        JLabel raLabel = new JLabel("Remove the Node Following -->");
        JTextField raTF = new JTextField(6);
        JButton raButton = new JButton("Remove");
        raPanel.add(raLabel);
        raPanel.add(raTF);
        raPanel.add(raButton);
        panel.add(raPanel);

        //Copy method application
        JPanel copyPanel = new JPanel();
        JLabel copyLabel = new JLabel("Make a Copy of the List");
        JButton copyButton = new JButton("Make Copy");
        copyPanel.add(copyLabel);
        copyPanel.add(copyButton);
        panel.add(copyPanel);

        //Remove duplicate method application
        JPanel rdPanel = new JPanel();
        JLabel rdLabel = new JLabel("Remove Duplicate Colors");
        JTextField rdTF = new JTextField(10);
        JButton rdButton = new JButton("Remove Duplicates");
        rdPanel.add(rdLabel);
        rdPanel.add(rdTF);
        rdPanel.add(rdButton);
        panel.add(rdPanel);

        //Max method application
        JPanel maxPanel = new JPanel();
        JLabel maxLabel = new JLabel("Find the Max Number");
        JButton maxButton = new JButton("Find Maximum");
        maxPanel.add(maxLabel);
        maxPanel.add(maxButton);
        panel.add(maxPanel);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == raButton){
                    String input = raTF.getText();//input as argument
                    DataNode node = linkedList.searchNode(input);
                    if (node != null) {
                        linkedList.removeAfter(node);//remove after with input
                        listContent.setText(linkedList.getListAsString()); //Current list updates to what was removed
                    }
                } else if (ae.getSource() == rdButton) {
                    String colorToRemove = rdTF.getText();
                    linkedList.removeDuplicate(linkedList.getHead(), colorToRemove); //the head and the input are arguments
                    listContent.setText(linkedList.getListAsString()); //Update what is shown in the window
                } else if (ae.getSource() == copyButton) {
                    DataLinkedList copiedList = linkedList.copy(linkedList.getHead());//makes copy from the head on
                    //cant show in window, JOptionPane shows that a copy was made
                    JOptionPane.showMessageDialog(null, "Copy created:\n" + copiedList.getListAsString());
                } else if (ae.getSource() == maxButton) {
                    int maxNumber = linkedList.max(linkedList.getHead());//Finds max int in LL
                    //Same as copy, shows in JOptionPane
                    JOptionPane.showMessageDialog(null, "Maximum number in the list: " + maxNumber);
                }
            }
        };

        raButton.addActionListener(listener);
        rdButton.addActionListener(listener);
        copyButton.addActionListener(listener);
        maxButton.addActionListener(listener);

        content.add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        TestDataLinkedList TDLL = new TestDataLinkedList();
        TDLL.GUI();
    }
}
