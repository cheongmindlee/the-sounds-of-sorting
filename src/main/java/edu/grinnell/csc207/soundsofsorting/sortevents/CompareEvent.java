package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T>{

    //vars to store the indicies of the elements
    private int i;
    private int j;

    public CompareEvent(int i, int j){
        this.i = i;
        this.j = j;
    }
    /**
     * Does nothing for CompareEvent
     */
    @Override
    public void apply(T[] arr) {
    }


    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> affectedIndices = new ArrayList<>();
        affectedIndices.add(i);
        affectedIndices.add(j);
        return affectedIndices;
    }

    @Override
    public boolean isEmphasized() {
        return false;
    }
}
