package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T>{

    //Store indicies of elements we are going to swap
    private int i;
    private int j;

    public SwapEvent(int i, int j){
        this.i = i;
        this.j = j;
    }
    @Override
    public void apply(T[] arr) {
        //Swap the two elements
        T newJ = arr[i];
        arr[i] = arr[j];
        arr[j] = newJ;
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
        return true;
    }
    
}
