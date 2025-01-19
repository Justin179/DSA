package datastructures.lc240212;

class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);     // linked list becomes 1->2->3
        int res1 = myLinkedList.get(1);                        // return 2

        myLinkedList.deleteAtIndex(0);              // now the linked list is 1->3
        int res2 = myLinkedList.get(0);                        // return 3
        System.out.println(res2);
    }

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    Node dummy;
    int size;

    public MyLinkedList() {
        dummy = new Node(-1);
        size = 0;
    }

    public int get(int index) {
        if(index >= size){
            return -1;
        }

        Node j = dummy.next;
        for(int i = 0; i<index; i++){
            j = j.next;
        }
        return j.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = dummy.next;
        dummy.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node i = dummy.next;
        while(i.next != null){
            i = i.next;
        }
        Node tail = new Node(val);
        i.next = tail;
        size++;
    }

    /*
    Add a node of value val before the indexth node in the linked list.
    If index equals the length of the linked list, the node will be appended to the end of the linked list.
    If index is greater than the length, the node will not be inserted.
    */
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }

        Node j = dummy.next;
        for(int i = 1; i<index; i++){
            j = j.next;
        }

        Node next = j.next;
        Node insert = new Node(val);
        j.next = insert;
        insert.next = next;

        size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size){
            return;
        }

        Node j = dummy.next;
        for(int i = 1; i<index; i++){
            j = j.next;
        }
        if(index == 0){
            dummy.next = j.next;
        }else{
            j.next = j.next.next;
        }

        size--;
    }
}
