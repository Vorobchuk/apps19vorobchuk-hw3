package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        ArrayList<Object> arr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arr.add(array[i]);
        }
        for (int j = 0; j < arr.size(); j++) {
            for (int k = j + 1; k < arr.size(); k++) {
                if (arr.get(k).equals(arr.get(j))) {
                    arr.remove(j);
                }
            }
        }

        Object[] newArr = new Object[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            newArr[j] = arr.get(j);
        }
        return newArr;
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator. Remove duplicates from SmartArray. Use method equals() to compare objects";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
