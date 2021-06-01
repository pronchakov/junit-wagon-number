package edu.junit;

import java.util.List;

public class WagonNumberListCreator {

    private List<Integer> wagonNumber;
    private int count;
    private boolean isDone = false;

    public WagonNumberListCreator(List<Integer> wagonNumbers, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count cannot be less or equal zero");
        }
        this.wagonNumber = wagonNumbers;
        this.count = count;
    }

    public String getNextBatch() {
        if (isDone) {
            return null;
        }
        if (wagonNumber.isEmpty()) {
            isDone = true;
            return "()";
        }
        return "";
    }
}
