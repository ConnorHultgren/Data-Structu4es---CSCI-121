public class DataLinkedList {
    private DataNode head;
    private DataNode tail;

    public DataLinkedList(){
        head = null;
        tail = null;
    }

    public DataNode getHead() {
        return this.head;
    }

    public void insertNode(Data data){
        DataNode node = new DataNode(data);
        if(head == null){
            head = node;
        }
        else {
            tail.setNext(node);
        }
        tail = node;
    }

    //search method
    public DataNode searchNode(String color){
        DataNode current = head;
        if(!current.getData().getColor().equals(color)){ //if the search is not for the head
            while(current.getNext() != null){ // while the node isn't the tail
                String dcolor = current.getNext().getData().getColor();
                if(dcolor.equals(color)){ //if the color of the node matches the search: found
                    return current.getNext();
                }
                else // if it doesn't match current becomes the next one
                    current = current.getNext();
            }
        }
        return current; //if it is the head, returns the head
    }

    //delete a node method
    public void deleteNode(String color){
        DataNode current = head;
        if(!current.getData().getColor().equals(color)){ // if the node to be deleted isnt the head...
            while(current.getNext() != null){ // while not the tail
                String dcolor = current.getNext().getData().getColor();
                if(dcolor.equals(color)){// if it is the one to be deleted:
                    current.setNext(current.getNext().getNext());//set the previous node to skip over the deleted
                    break;
                }
                else
                    current = current.getNext(); //current becomes the next node
            }
        }
    }

    //removeAfter, deletes the next thing
    public void removeAfter(DataNode remAf){
        if (!(remAf.getNext() == null)){
            remAf.setNext(remAf.getNext().getNext()); //list skips over the one to be removed
        }
    }

    //copy, makes a copy of the entire list
    public DataLinkedList copy(DataNode node){
        DataLinkedList copied = new DataLinkedList();
        DataNode current = node;
        while (!(current == null)){
            Data cData = current.getData();
            copied.insertNode(new Data(cData.getColor(), cData.getNum())); //copies each value of the current Node
            current = current.getNext();
        }
        return copied; //new link list
    }

    //removeDuplicate, makes each node unique based on its string value
    public void removeDuplicate(DataNode node, String color){
        DataNode current = node;
        while (!(current == null)){
            if(current.getData().getColor().equals(color)){ //if the color value matches the current color value
                current.setNext(current.getNext().getNext()); //skip it
            }
            current = current.getNext();
        }
    }

    //max, returns the DataNode with the greatest
    public int max(DataNode node){
        int maxNum = 0; //if null then max is 0
        DataNode current = node;
        while (!(current == null)){
            if (current.getData().getNum() > maxNum){
                maxNum = current.getData().getNum(); //if the num value is greater than the max, there is a new max
            }
            current = current.getNext();
        }
        return maxNum;
    }

    //print out
    public String getListAsString() {
        StringBuilder sb = new StringBuilder(); //able to create string of LL
        DataNode current = head;
        while (current != null) {
            sb.append(current.getData().toString());//adds each node
            if (current.getNext() != null) {
                sb.append(", "); //wont add a comma on the tail
            }
            current = current.getNext();
        }
        return sb.toString();
    }

}
