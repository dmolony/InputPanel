package com.bytezone.input;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

// ---------------------------------------------------------------------------------//
public class ButtonPanel extends InputPanel
// ---------------------------------------------------------------------------------//
{
  private final List<JButton> buttons = new ArrayList<JButton> ();

  // ---------------------------------------------------------------------------------//
  public ButtonPanel (String[] options)
  // ---------------------------------------------------------------------------------//
  {
    init (options);
  }

  // ---------------------------------------------------------------------------------//
  public ButtonPanel (String title, String[] options)
  // ---------------------------------------------------------------------------------//
  {
    super (title);
    init (options);
  }

  // ---------------------------------------------------------------------------------//
  protected void init (String[] options)
  // ---------------------------------------------------------------------------------//
  {
    JPanel panel = new JPanel ();     // uses FlowLayout

    for (String s : options)
    {
      JButton button = new JButton (s);
      button.setPreferredSize (BUTTON_SIZE);
      button.setMaximumSize (BUTTON_SIZE);

      panel.add (button);
      buttons.add (button);
    }

    add (panel);
    SpringUtilities.makeCompactGrid (this, 1, 1, OFFSET, OFFSET, GAP, GAP);
  }

  // ---------------------------------------------------------------------------------//
  public int totalItems ()
  // ---------------------------------------------------------------------------------//
  {
    return buttons.size ();
  }

  // ---------------------------------------------------------------------------------//
  public JButton getItem (int index)
  // ---------------------------------------------------------------------------------//
  {
    return buttons.get (index);
  }

  // ---------------------------------------------------------------------------------//
  public JButton getItem (String name)
  // ---------------------------------------------------------------------------------//
  {
    for (JButton button : buttons)
      if (button.getText ().equals (name))
        return button;
    return null;
  }
}