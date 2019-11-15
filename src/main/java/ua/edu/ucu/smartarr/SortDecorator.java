package ua.edu.ucu.smartarr;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;


    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        Arrays.sort(array, comparator);
        return array;
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator. Sorts elements using MyComparator to compare them";
    }

    @Override
    public int size() {
        return toArray().length;
    }
    
}
