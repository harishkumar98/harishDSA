package LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Internal Class to represent a Node of LinkedList
    private static class Node<T>{
        private T data;
        private Node<T> next, prev;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Empty this linked-list
    public void clear(){
        Node<T> trav = head;
        while(trav != null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    // Add a node at the last of linked-list
    public void addAtLast(T elem){

        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }else{
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
        System.out.println("addAtLast() = "+ elem.toString());
    }

    //Add a node at the begin of the linked-list
    public void adAtBegin(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }else{
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
        System.out.println("addAtBegin() = "+ elem.toString());
    }

    //Add an elem at the last of the linked-list
    public void add(T elem){
        addAtLast(elem);
    }

    // Remove the first value at the head of linked-list, O(1)
    public T removeFromFirst(){
        if(isEmpty())
            throw new RuntimeException("Empty Linked List");
        T data = head.data;
        head = head.next;
        --size;

        if(isEmpty())
            tail = null;
        else
            head.prev = null;
        System.out.println("removed from First = "+ data.toString());
        return data;
    }

    // Remove the last value at the tail of linked-list, O(1)
    public T removeFromLast(){
        if(isEmpty())
            throw new RuntimeException("Empty Linked List");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if(isEmpty())
            head = null;
        else
            tail.next = null;
        System.out.println("removed from Last = "+ data.toString());
        return data;
    }

    // Remove the arbitrary node from linked-list, O(1)
    public T remove(Node<T> node){
        System.out.println("remove node with data = "+ node.data.toString());
        if(node.prev == null)
            return removeFromFirst();
        if(node.next == null)
            return removeFromLast();
        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node = node.prev = node.next = null;
        --size;

        return data;
    }

    // Remove a node at a particular index, O(n)
    public T removeAt(int index){
        System.out.println("removeAtIndex() = "+ index);
        if(index < 0 || index >= size){
            throw new IllegalArgumentException();
        }

        int i;
        Node<T> trav;

        if(index < size/2){
            for(i = 0, trav=head; i != index; i++){
                trav = trav.next;
            }
        }else{
            for(i = size-1, trav = tail; i != index; i--){
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    // Remove a particular value from linked-list, O(n)
    public boolean remove(Object obj){
        Node<T> trav = head;
        System.out.println("remove data = "+ obj);
        if(obj == null){
            for(trav = head; trav != null; trav = trav.next){
                if(trav.data == null){
                    remove(trav);
                    return true;
                }
            }
        }else{
            for(trav = head; trav != null; trav = trav.next){
                if(obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // find index of a particular value in linked-list
    public int indexOf(Object obj){
        int index = 0;
        Node<T> trav = head;

        if(obj == null){
            for(; trav != null; trav = trav.next, index++){
                if(trav.data == null){
                    return index;
                }
            }
        }else{
            for(; trav != null; trav = trav.next, index++){
                if(obj.equals(trav.data))
                    return index;
            }
        }
        return -1;
    }

    //Check if a value is contained within linked-list
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    // add a node at an index
    public void addAtIndex(int index, T obj){
        System.out.print("addAtIndex() = "+ index + ": ");
        if(index < 0 || index == size){
            throw new IllegalArgumentException();
        }

        if(index == 0)
            adAtBegin(obj);
        else if(index == size -1) {
            addAtLast(obj);
        }else {
            int i;
            Node<T> node = new Node<>(obj, null, null);
            Node<T> trav;
            if (index < size / 2) {
                for (i = 0, trav = head; i != index - 1; i++) {
                    trav = trav.next;
                }
            } else {
                for (i = size - 1, trav = tail; i != index - 1; i--) {
                    trav = trav.prev;
                }
            }
            node.next = trav.next;
            node.prev = trav.next.prev;
            trav.next.prev = node;
            trav.next = node;
            ++size;
        }

    }



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;
            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while(trav.next != null){
            sb.append(trav.data).append(", ");
            trav = trav.next;
        }

        sb.append(trav.data).append(" ]");
        trav = null;
        return sb.toString();
    }
}
