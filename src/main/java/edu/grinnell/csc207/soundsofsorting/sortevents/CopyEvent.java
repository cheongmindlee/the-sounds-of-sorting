package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {

    // Instantiate variables
    private T value;
    private int i;

    /**
     * the value being copied and the index of the value
     * @param value value being copied
     * @param i index of value
     */
    public CopyEvent(T value, int i) {
        this.value = value;
        this.i = i;
    }

    @Override
    public void apply(T[] arr) {
        arr[i] = value;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> affectedIndices = new ArrayList<>();
        affectedIndices.add(i);
        return affectedIndices;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }

}
