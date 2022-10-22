package com.company;

import org.w3c.dom.Node;

public class CompleLinkedList_Programs {

    private Node head;
    private Node tail;

    private int size;

    public LL() {
        this.size = 0;
    }

    public void InsertFirst(int val) {

        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void InsertLast(int val) {

        if (tail == null) {
            InsertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;

    }
    public void InsertLastWithoutTail(int val) {
        Node node = new Node(val);
        Node temp = head;

        while (temp.next != null) {

            temp = temp.next;
        }
        temp.next = node;
        tail = node; // THis line is not mandidatory!!!

    }
    //       if (temp.next == null) { // It means only one element is present
    //            temp.next = node;
    //
    //        }

    public void InsertAtPlace(int val, int index) {
        if (index == 0) {
            InsertFirst(val);
            return;
        }
        if (index == size) {
            InsertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;

    }

    public void InsertAtPlaceModified(int value, int index) {

        if (index == 0) {
            InsertFirst(value);
            return;
        }
        if (index == size) {
            InsertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node temp2 = head;
        for (int i = 1; i < index + 1; i++) {
            temp2 = temp2.next;
        }
        Node node = new Node(value);
        temp.next = node;
        node.next = temp2;
    }

    public int DeleteFirst() {

        int val = head.val;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }


    public void DeleteLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }

    public void DeleteLastByForLoop() {
        int index = size;
        Node temp = head;

        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void DeleteAtPlace(int index) {

        if (index == 0) {
            DeleteFirst();
            return;
        }
        if (index == size) {
            DeleteLastByForLoop();
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void LeetCode(int value) {

        Node temp = head;
        int cnt = -1;
        while(temp.next != null) {
            cnt++;
            if (temp.val == value) {
                DeleteAtPlace(cnt);
            }
            temp = temp.next;
        }
    }
    public Node RemoveDuplicates() {

        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }

    public void  RemoveElements (int value) {

        Node temp = head;
        // This Blok Of Code Works For Starting Head Value. If Head == Value Move Head By One Until Head.val != Value :)
        while (head != null && head.val == value) {
            head = head.next;
        }
        while (temp != null && temp.next != null) {
            if (temp.next.val == value) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
    }


    public void DeleteNth(int index) {

        int cnt = 0;
        Node counter = head;
        while (counter != null) {
            cnt++;
            counter = counter.next;
        }

        Node temp = head;
        if (cnt == 1 || cnt == index) {
            head = head.next;
            return;
        }

        for (int i = 1; i < cnt - index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public Node MiddleLinkedList() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node MiddleByForLoop() {

        int cnt = 0;
        Node counting = head;
        while (counting != null) {
            cnt++;
            counting = counting.next;
        }

        Node temp = head;
        for (int i = 0; i < cnt / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node DeleteMiddle() {

        int cnt = 0;
        Node counting = head;

        while (counting != null) {
            cnt++;
            counting = counting.next;
        }

        Node temp = head;
        for (int i = 1; i < cnt / 2 ; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return temp;
    }


    public void Reverse() {

        Node prev = null;
        Node preset = head;
        Node future = preset.next;

        while (preset != null) {

            preset.next = prev;
            prev = preset;
            preset = future;

            if (future != null) {
                future = future.next;
            }
        }
        head = prev;
    }

    public void ReverseNodes(int value) {

        int value1, value2;
        Node temp1 = head;
        for (int i = 1; i < value; i++) {
            temp1 = temp1.next;
        }
        value1 = temp1.val;

        Node temp2 = head;
        for (int i = 1; i < size - value + 1; i++) {
            temp2 = temp2.next;
        }
        value2 = temp2.val;

        temp1.val = value2;
        temp2.val = value1;
    }

    public void GreaterNodes (int value) {

        while (head != null && head.val > value) {
            head = head.next;
        }

        Node temp = head;
        while (temp != null && temp.next != null) {

            if (temp.next.val > value) {
                temp.next = temp.next.next;
                // temp.next = null; If The LL Is Sorted
            }
            else {
                temp = temp.next;
            }
        }
    }

    public boolean LLCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }


    private class Node {

        private int val;
        private Node next;

        public Node(int value) {
            this.val = value;
        }

        public Node(int value, Node next) {
            this.val = value;
            this.next = next;
        }

    }
}
