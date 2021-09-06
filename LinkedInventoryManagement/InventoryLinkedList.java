package LinkedInventoryManagement;

//Samuel Osezua SOO190000

public class InventoryLinkedList<E extends Comparable<E>> {
    int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;


    private boolean addFirst(E item) {
        // create a node that will store the data 'item'
        Node<E> node;
        // check if the linked list is empty
        if (head == null) {

            node = new Node<>(item, null, null);
            head = node;
            tail = node;
        } else {

            node = new Node<>(item, null, head);
            head.previous = node;
            head = node;
        }
        size++;
        return true;
    }


    private boolean addAfter(Node<E> node, E item) {

        Node<E> nextNode = node.getNext();

        // check if the 'nextNode' is null, that would mean the 'node' is the last node of the linked list.
        if (nextNode == null) {

            Node<E> newNode = new Node<>(item, node, null);
            node.next = newNode;
            tail = newNode;
        } else {

            Node<E> newNode = new Node<>(item, node, nextNode);
            node.next = newNode;
            nextNode.previous = newNode;
        }
        // increase the size of the linked list
        size++;
        return true;
    }

    public Node<E> getNode(int index) {
        Node<E> iterator = head;
        for (int i = 0; i < index && iterator != null; i++) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    public E getNodeVal(int index) {
        Node<E> iterator = head;
        for (int i = 0; i < index && iterator != null; i++) {
            iterator = iterator.getNext();
        }
        return iterator.data;
    }


    public boolean insert(int index, E item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return addFirst(item);
        } else {
            return addAfter(getNode(index - 1), item);
        }
    }


    public boolean add(E value) {
        return insert(size, value);
    }

    private void remove(Node<E> del) {
        if (del.getPrevious() != null) {
            del.previous.next = del.next;
        }
        if (del.next != null) {
            del.next.previous = del.previous;
        }
        if (del == tail)
        {
            tail = del.previous;
        }
        if (del == head)
        {
            head = del.next;
        }

        size--;
    }


    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if (index == 0) {

            head = head.next;
            head.previous = null;

        }
        else if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
        }


        else
            remove(getNode(index));
    }


    public boolean contains(E e) {

        boolean flag = false;
        Node<E> current = head;
        E element  = current.data;

        for (int i = 0; i < size; i++) {

            if (e.compareTo(element)==0)
            {
                flag = true;
                break;
            }

            element  = current.data;
            current = current.next;
        }

        if (e.compareTo(tail.data)==0)
        {
            flag = true;
        }



        return flag;
    }


    public Node<E> getFirstNode()
    {

        return getNode(0);
    }

    public E getFirst()
    {

        return getNode(0).data;
    }

    public Node<E> getLastNode()
    {

        return getNode(size-1);
    }

    public E setElement(int index, E element)
    {
        getNode(index).data= element;

        return getNodeVal(index);
    }

    public E getLast()
    {

        return getNode(size-1).data;
    }

    public int getLength() {
        return size;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");

        //iterate through the linked list
        Node<E> currentNode = head;
        for (int i = 0; i < size && currentNode != null; i++) {


            // fetch the data from the current node.
            E data = currentNode.getData();

            // append the data to the string builder object
            sb.append(data);

            // append the commas after the data
            sb.append(i < size - 1 ? ", " : "");

            // change the reference of the temp variable to the next node.
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }


    private static class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        private Node (E data)
        {
            this.data = data;
        }
        private Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        private E getData() {
            return data;
        }

        private Node<E> getPrevious() {
            return previous;
        }

        private Node<E> getNext() {
            return next;
        }
    }
}

