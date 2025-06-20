package com.datastructure.linkedlist;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class SingleLinkedListCustom{
    private Node head;

    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
           head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(){

    }


    public void display(){
        if(head == null){
            System.out.println("Empty List");
        }
        Node currrent = head;
        while (currrent != null){
            System.out.print(currrent.data + "-->");
            currrent = currrent.next;
        }
    }
}

//main
public class SingleLinkedList {
    public static void main(String[] args) {
        
        SingleLinkedListCustom linkedList = new SingleLinkedListCustom();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        
        linkedList.display();
    }
}
