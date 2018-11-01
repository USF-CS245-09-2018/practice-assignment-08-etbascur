public class LinkedList implements List {
    private class Node{
        public Object data;
        public Node next;
        Node(){
            Object data;
            Node next;
        }
    }
    private int Size = 0;
    private Node head;
    @Override
    public void add(Object obj) throws Exception {
        Node node = new Node();
        node.data = obj;
        node.next = head;
        head = node;
        ++Size;
    }

    @Override
    public void add(int pos, Object obj) throws Exception {
        if(pos<0 || pos>Size+1){
            //exception
        }
        Node node= new Node();
        node.data= obj;
        if(pos==0){
            node.next = head;
            head = node;
        }
        Node previous = find(pos-1);
        node.next=previous.next;
        previous.next = node;
        ++Size;
    }

    @Override
    public Object get(int pos) throws Exception {
        Node node = head;
        for(int i = 0;i<pos;i++){ //iterates through nodes until it finds the position of the node
            node = node.next;
        }
        return node.data;
    }

    @Override
    public Object remove(int pos) throws Exception {
        if(pos<0 || pos>Size+1){
            //exception
        }
        if(pos==0) //if removing the head, assign next node to be head
        {
            Node node = head;
            head = head.next;
            --Size;
            return node.data;
        }
        Node prev = find(pos-1);
        Node curr = prev.next;
        prev.next = curr.next;
        --Size;
        return curr.data;
    }

    @Override
    public int size() {
        return Size;
    }

    private Node find(int pos){
        Node node = head;
        for(int i=0;i<pos && node.next !=null;i++){
            node = node.next;
        }
        return node;
    }
}
