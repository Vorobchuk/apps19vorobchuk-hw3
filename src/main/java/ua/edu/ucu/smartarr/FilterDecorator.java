package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        Object[] array = new Object[arr.length];

        int j = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (predicate.test(arr[i])) {
                array[j] = arr[i];
                j++;
            }
        }
        return Arrays.copyOf(array, j);
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator. Tests every element and removes it if it doesn't satisfy MyPredicate";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
