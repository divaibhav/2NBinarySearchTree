package implementation;

public class MyBinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }

    public void insert(E element) {
        Node<E> node = new Node<>(element);
        if (isEmpty()) {
            root = node;
        } else {
            //traverse and reach the position where new node
            // will be inserted as well as keep reference of parent
            Node<E> temp = root;
            Node<E> parent = null;
            while (temp != null) {
                parent = temp;
                if (element.compareTo(temp.getData()) <= 0) {
                    //update temp to refer left subtree
                    temp = temp.getLeft();
                } else {
                    //update temp to refer right subtree
                    temp = temp.getRight();
                }
            }
            //checking whether new node will be left or right
            //child of parent
            if (element.compareTo(parent.getData()) <= 0) {
                //set new node to left child of parent
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    private boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    //traversal
    public void inOrder(Node<E> node) {
        if (node != null) {
            //process the left subtree
            inOrder(node.getLeft());
            // process node data
            System.out.print(node.getData() + ", ");
            //process right subtree
            inOrder(node.getRight());
        }
    }
    //post order
    //pre order

    //search
    public boolean search(E searchElement) {
        boolean response = false;
        //traverse
        Node<E> temp = root;
        while (temp != null) {
            if (searchElement.compareTo(temp.getData()) == 0) {
                response = true;
                break;
            } else if (searchElement.compareTo(temp.getData()) < 0) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return response;
    }

    //delete
    public void delete(E deletingElement) {
        //search for deleting node, and keep track of parent
        Node<E> temp = root;
        Node<E> parent = null;
        while (temp != null) {
            if (deletingElement.compareTo(temp.getData()) == 0) {
                break;
            } else {
                parent = temp;
                if (deletingElement.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        if(temp != null){
            //case 1

            if(isLeaf(temp)){
                //root node
                if(parent == null){
                    root = null;
                }
                else{
                    if(deletingElement.compareTo(parent.getData()) < 0){
                        parent.setLeft(null);
                    }
                    else{
                        parent.setRight(null);
                    }
                }
            }
            //case 2
            //left child
            else if(hasLeftChild(temp)){
                //root node
                if(parent == null){
                    root = root.getLeft();
                }
                else{
                    if(deletingElement.compareTo(parent.getData()) < 0){
                        parent.setLeft(temp.getLeft());
                    }
                    else{
                        parent.setRight(temp.getLeft());
                    }
                }
            }
            //right child
            else if(hasRightChild(temp)){
                //root case
                if(parent == null){
                    root = root.getRight();
                }
                else {
                    if(deletingElement.compareTo(parent.getData()) < 0){
                        parent.setLeft(temp.getRight());
                    }
                    else{
                        parent.setRight(temp.getRight());
                    }
                }
            }
            //case 3 two children
            else{
                Node<E> successor = getSuccessor(temp);
                //delete successor
                delete(successor.getData());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                //root case
                if(parent == null){
                    root = successor;
                }
                else{
                    if(deletingElement.compareTo(parent.getData()) < 0){
                        parent.setLeft(successor);
                    }
                    else{
                        parent.setRight(successor);
                    }
                }
            }


                //root node
        }
        else{
            System.out.println("cannot delete");
        }
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> response = null;
        Node<E> temp = node.getRight();
        while (temp.getLeft() != null){
            temp = temp.getLeft();
        }
        response = temp;
        return response;
    }

    private boolean hasRightChild(Node<E> temp) {
        if(temp.getRight() != null && temp.getLeft() == null){
            return true;
        }
        return false;
    }

    private boolean hasLeftChild(Node<E> temp) {
        if(temp.getLeft() != null && temp.getRight() == null){
            return true;
        }
        return false;
    }

    private boolean isLeaf(Node<E> temp) {
        if(temp.getLeft() == null && temp.getRight() == null){
            return true;
        }
        return false;
    }
}
