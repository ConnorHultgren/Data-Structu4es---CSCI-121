//This method creates the nodes that contain data (with set and get)
public class DataNode {
    private Data data;
    private DataNode next;

    public DataNode(Data data){
        this.data = data;
        this.next = null;
    }

    public Data getData() {
        return data;
    }

    public DataNode getNext() {
        return next;
    }

    public void setNext(DataNode next) {
        this.next = next;
    }
}
