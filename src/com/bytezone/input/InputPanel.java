package com.bytezone.input;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

// -----------------------------------------------------------------------------------//
public abstract class InputPanel extends JComponent
// -----------------------------------------------------------------------------------//
{
  protected static Dimension LABEL_SIZE = new Dimension (80, 15);
  protected static Dimension BUTTON_SIZE = new Dimension (80, 30);
  protected static int TEXT_LENGTH = 20;
  protected static int OFFSET = 5;
  protected static int GAP = 5;

  // ---------------------------------------------------------------------------------//
  public InputPanel ()
  // ---------------------------------------------------------------------------------//
  {
    setLayout (new SpringLayout ());
  }

  // ---------------------------------------------------------------------------------//
  public InputPanel (String title)
  // ---------------------------------------------------------------------------------//
  {
    this ();
    setBorder (BorderFactory.createTitledBorder (title));
  }

  // only call this AFTER the pack() call
  // ---------------------------------------------------------------------------------//
  public void lock ()
  // ---------------------------------------------------------------------------------//
  {
    Dimension size = getSize ();
    setMinimumSize (size);
    setPreferredSize (size);
    setMaximumSize (size);

    for (Component c : getComponents ())
      if (c instanceof InputPanel)
        ((InputPanel) c).lock ();
      else
      {
        size = c.getSize ();
        c.setMinimumSize (size);
        c.setPreferredSize (size);
        c.setMaximumSize (size);
      }
  }

  // ---------------------------------------------------------------------------------//
  protected JLabel setLabel (String labelText)
  // ---------------------------------------------------------------------------------//
  {
    return setLabel (labelText, JLabel.CENTER);
  }

  // ---------------------------------------------------------------------------------//
  protected JLabel setLabel (String labelText, int alignment)
  // ---------------------------------------------------------------------------------//
  {
    JLabel label = new JLabel (labelText + " ", JLabel.TRAILING);
    add (label);

    // set these two to the same size so the label width can't be resized
    label.setPreferredSize (LABEL_SIZE);
    label.setMaximumSize (LABEL_SIZE);
    label.setVerticalAlignment (alignment);
    //    label.setBorder (BorderFactory.createLineBorder (Color.black));

    return label;
  }

  // ---------------------------------------------------------------------------------//
  public static void setLabelWidth (int width)
  // ---------------------------------------------------------------------------------//
  {
    LABEL_SIZE = new Dimension (width, 15);
  }

  // ---------------------------------------------------------------------------------//
  public static void setButtonSize (Dimension dimension)
  // ---------------------------------------------------------------------------------//
  {
    BUTTON_SIZE = dimension;
  }

  // ---------------------------------------------------------------------------------//
  public static void setTextLength (int length)
  // ---------------------------------------------------------------------------------//
  {
    TEXT_LENGTH = length;
  }

  // ---------------------------------------------------------------------------------//
  public static void setOffset (int length)
  // ---------------------------------------------------------------------------------//
  {
    OFFSET = length;
  }

  // ---------------------------------------------------------------------------------//
  public static void setGap (int length)
  // ---------------------------------------------------------------------------------//
  {
    GAP = length;
  }
}