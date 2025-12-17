package edu.grinnell.csc207.soundsofsorting;

import java.util.Random;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {

    // Array of the note indicies and highlighted
    private Integer[] notes;
    private boolean[] highlighted;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        initializeAndShuffle(n);
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * 
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        this.notes = new Integer[n];
        for (int i = 0; i < n; i++) {
            this.notes[i] = i;
        }

        // Shuffle the array using fischer Yates shuffle like tetris
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomInd = rand.nextInt(i + 1);
            int temp = notes[i];
            notes[i] = notes[randomInd];
            notes[randomInd] = temp;
        }

        // initialize the highlighted state
        highlighted = new boolean[n];
        for (int i = 0; i < n; i++) {
            highlighted[i] = false;
        }
    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() {
        return notes;
    }

    /**
     * Highlights the given index of the note array
     * 
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        highlighted[index] = true;
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return highlighted[index];
    }

    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int i = 0; i < highlighted.length; i++) {
            highlighted[i] = false;
        }
    }
}
