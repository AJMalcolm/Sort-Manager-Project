package com.sparta.amalcolm.factory;

import com.sparta.amalcolm.Interfaces.BinaryTree;
import com.sparta.amalcolm.Interfaces.Sorter;
import com.sparta.amalcolm.binarytreesort.BinarySortImpl;
import com.sparta.amalcolm.sort.BubbleSort;
import com.sparta.amalcolm.sort.MergeSort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SorterFactory {

    public static final Logger logger = LogManager.getLogger(SorterFactory.class);

    public static Sorter getSorter(SorterTypes sortTypes){

        Sorter sorter = null;
        switch(sortTypes){
            case BUBBLE:
                sorter = BubbleSort.getInstance();
                break;
            case MERGE:
                sorter = MergeSort.getInstance();
                break;
        }

        return sorter;
    }

    public static BinaryTree getSorter(SorterTypes sortTypes, int[] array){

        BinaryTree sorter = null;
        switch(sortTypes){
            case BINARYTREE:
                sorter = BinarySortImpl.getInstance(array);
                break;
            default:
                logger.fatal("Sorter Factory has malfunctioned, this should never happen.");
                System.exit(0);
        }
        return sorter;
    }
}