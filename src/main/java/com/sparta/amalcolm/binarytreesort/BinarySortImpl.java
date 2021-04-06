package com.sparta.amalcolm.binarytreesort;

import com.sparta.amalcolm.exceptions.EmptyArrayException;
import com.sparta.amalcolm.util.Printer;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.sparta.amalcolm.Interfaces.BinaryTree;
import com.sparta.amalcolm.exceptions.ChildNotFoundException;

public class BinarySortImpl implements BinaryTree {

    public static final Logger logger = LogManager.getLogger(BinarySortImpl.class);

    private final Node rootNode;
    private Node searchNode;
    private Node previousNode;
    private int[] sortedTreeAsc;
    private int[] sortedTreeDesc;
    private int numberOfNodes = 1;
    private int numberOfRepeatNodes = 0;
    private int iterator = 0;


    public BinarySortImpl(final int element) {
        rootNode = new Node(element);
    }

    public BinarySortImpl(final int[] elements) {

        if (elements == null){
            try{
                throw new EmptyArrayException("Binary Sort Impl Class has received a null array.");
            }
            catch(EmptyArrayException eAE){
                logger.fatal("A fatal error has occurred within the BinarySortImpl class, program will now close.", eAE);
                Printer.printMessage("Unfortunately something went wrong, please reload the program.");
                System.exit(0);
            }
        }

        rootNode = new Node(elements[0]);
        for (int i = 1; i < elements.length; i++){
            previousNode = rootNode;
            addElement(elements[i]);
        }

        sortedTreeAsc = new int[numberOfNodes - numberOfRepeatNodes];
        sortedTreeDesc = new int[numberOfNodes - numberOfRepeatNodes];
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfNodes;
    }

    @Override
    public void addElement(int element) {
        Node newNode = new Node(element);
        boolean nodeAdded = false;

        while(nodeAdded == false){
            if(element == previousNode.value){
                nodeAdded=true;
                return;
            }

            if(element <= previousNode.value){
                if(previousNode.getLeftChild() == null)
                {
                    previousNode.setLeftChild(newNode);
                    nodeAdded = true;
                    numberOfNodes++;
                }
                else{
                    previousNode = previousNode.getLeftChild();
                    addElement(element);
                }
            }
            else if(element > previousNode.value){
                if(previousNode.getRightChild() == null)
                {
                    previousNode.setRightChild(newNode);
                    nodeAdded = true;
                    numberOfNodes++;
                }
                else{
                    previousNode = previousNode.getRightChild();
                    addElement(element);
                }
            }
            else{
                if(previousNode.getLeftChild().getValue() == newNode.getValue()) {
                    numberOfRepeatNodes++;
                }
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int i = 0; i < elements.length; i++){
            addElement(elements[i]);
        }
    }

    @Override
    public boolean findElement(int query) {

        searchNode = rootNode;
        boolean nodeFound = false;

        while(nodeFound == false){
            if(query == searchNode.getValue()){
                nodeFound = true;
                return nodeFound;
            }

            if(query <= searchNode.getValue()){
                if(searchNode.getLeftChild() == null)
                {
                    return false;
                }
                else{
                    searchNode = searchNode.getLeftChild();
                }
            }
            else if(query > searchNode.getValue()){
                if(searchNode.getRightChild() == null)
                {
                    return false;
                }
                else{
                    searchNode = searchNode.getRightChild();
                }
            }
        }
        return nodeFound;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {

        int leftChildValue = 0;

        findElement(element);
        if (searchNode.getLeftChild() == null) {
            throw new ChildNotFoundException("This element does not have a left child.");
        }
        else{
            leftChildValue = searchNode.getLeftChild().getValue();
        }

        return leftChildValue;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        int rightChildValue = 0;

        findElement(element);
        if (searchNode.getRightChild() == null) {
            throw new ChildNotFoundException("This element does not have a left child.");
        }
        else{
            rightChildValue = searchNode.getRightChild().getValue();
        }
        return rightChildValue;
    }

    @Override
    public int[] getSortedTreeAsc() {

        iterator = 0;
        TraverseTreeAsc(rootNode);
        return sortedTreeAsc;
    }

    @Override
    public int[] getSortedTreeDesc() {

        iterator = 0;
        TraverseTreeDesc();
        return sortedTreeDesc;
    }

    public void TraverseTreeAsc(Node focusNode){
        if (focusNode != null){
            TraverseTreeAsc(focusNode.getLeftChild());

            sortedTreeAsc[iterator++] = focusNode.getValue();

            TraverseTreeAsc(focusNode.getRightChild());
        }
    }

    public void TraverseTreeDesc(){

        TraverseTreeAsc(rootNode);
        for (int i = 0, j = numberOfNodes - numberOfRepeatNodes - 1; i < numberOfNodes - numberOfRepeatNodes; i++, j--){
            sortedTreeDesc[i] = sortedTreeAsc[j];
        }
    }

    public class Node {

        private int value;
        private Node leftChild;
        private Node rightChild;

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftChild(){
            try{
                if(this.leftChild == null){
                    throw new ChildNotFoundException("The targeted node has no Left Child.");
                }
            }
            catch(ChildNotFoundException cNFE){
                logger.info("The program has queried a node which does not have a left child.");
            }

            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild(){
            try{
                if(this.rightChild == null){
                    throw new ChildNotFoundException("The targeted node has no Right Child.");
                }
            }
            catch(ChildNotFoundException cNFE){
                logger.info("The program has queried a node which does not have a Right child.");
            }
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }
}
