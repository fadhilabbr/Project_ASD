/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList{

    public Node head,tail;
    private int size=0;

    public SinglyLinkedList(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return size;
    }
    public void addFirst(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node baru = new Node(inputData);
        Node C=head;
        for(int i=0;i<index;i++){
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=1;i<size;i++){
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print(){
        Node currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }
    @Override
    public Object get(int index) {
        // TODO digunakan untuk mengembalikan data pada index ke-i dimulai dari head. Head memiliki index 0
        if (index < 0 || index >= size) {
            System.out.println("index out of bound");
            return null;
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.pointer;
        }
        return currentNode.data;
    }

    @Override
    public int indexOf(Object targetData) {
        // TODO digunakan mencari kemunculan pertama targetData pada linked list dan mengembalikan indeksnya. Indeks dari head adalah 0. Jika tidak ada targetData pada linked list, kembalikan nilai -1 
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if ((targetData == null && currentNode.data == null) || 
                (targetData != null && targetData.equals(currentNode.data))) {
                return index;
            }
            currentNode = currentNode.pointer;
            index++;
        }
        return -1;
    }

    @Override
    public void printReverse() {
        // TODO digunakan untuk mencetak data pada linked list dengan urutan terbalik, dari tail ke head.
        for (int i = size - 1; i >= 0; i--) {
            Node current = head;
            for (int j = 0; j < i; j++) {
                current = current.pointer;
            }
            System.out.println(current.data);
        }
    }

    @Override
    public boolean remove(Object targetData) {
        // TODO digunakan untuk mencari dan menghapus node dengan data=targetData pada linked list serta mengembalikan nilai True jika berhasil, dan False jika targetData tidak ada di linkedList
        if (isEmpty()) {
            return false;
        }
        if ((targetData == null && head.data == null) || 
            (targetData != null && targetData.equals(head.data))) {
            deleteFirst();
            return true;
        }
        Node prev = head;
        Node current = head.pointer;
        while (current != null) {
            if ((targetData == null && current.data == null) || 
                (targetData != null && targetData.equals(current.data))) {
                prev.pointer = current.pointer;
                if (current == tail) {
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.pointer;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        // TODO digunakan untuk mendapatkan keseluruhan data pada node-node di linked list dalam bentuk array. Data-data pada array disusun secara urut mulai dari head sampai dengan tail.
        Object[] result = new Object[size];
        Node currentNode = head;
        int i = 0;
        while (currentNode != null) {
            result[i++] = currentNode.data;
            currentNode = currentNode.pointer;
        }
        return result;
    }
}