package edu.grinnell.csc207.soundsofsorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
    private int width;
    private int height;

    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * 
     * @param notes  the note indices
     * @param width  the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Draws rectangles to the panel coressesponding to their position in the scale
     * 
     * @param g A graphics object
     */
    @Override
    public void paintComponent(Graphics g) {

        int len = notes.getNotes().length;
        for (int i = 0; i < len; i++) {
            // Add 1 to not lose the height of on bar
            int value = notes.getNotes()[i] + 1;
            int rectHeight = height - (int) (((float) value) / len * height);
            int rectWidth = 1 + width / len;
            if (notes.isHighlighted(i)) {
                Color c = new Color(0, 0, 255);
                g.setColor(c);
                g.fillRect(rectWidth * i, rectHeight, rectWidth, height - rectHeight);

            } else {
                Color c = new Color(255, 5 * i, 0);
                g.setColor(c);
                g.fillRect(rectWidth * i, rectHeight, rectWidth, height - rectHeight);
            }
        }
    }

    /**
     * Sets the note values
     * @param notes NoteIndices object
     */
    public void setNotes(NoteIndices notes) {
        this.notes = notes;
    }
}