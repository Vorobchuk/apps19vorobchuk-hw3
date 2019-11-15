package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = function.apply(array[i]);
        }
        return array;
    }

    @Override
    public String operationDescription() {
        return "Map Decorator. Maps every element to another object using MyFunction";
    }

    @Override
    public int size() {
        return toArray().length;
    }

}
