package com.bytezone.input;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ComboBoxPanel extends InputPanel
{
  JComboBox<String> comboBox;

  public ComboBoxPanel (String title, String labelText, String[] options)
  {
    super (title);
    init (labelText, options);
  }

  public ComboBoxPanel (String title, String labelText, JComboBox<String> box)
  {
    super (title);

    JLabel label = setLabel (labelText);
    comboBox = box;
    label.setLabelFor (comboBox);
    add (comboBox);

    SpringUtilities.makeCompactGrid (this, 1, 2, OFFSET, OFFSET, GAP, GAP);
  }

  public ComboBoxPanel (String labelText, String[] options)
  {
    init (labelText, options);
  }

  //  public ComboBoxPanel (String labelText, JList<?> list)
  //  {
  //    JLabel label = setLabel (labelText);
  //    //    init (labelText, options);
  //    comboBox = new JComboBox<> ();
  //    label.setLabelFor (comboBox);
  //
  //    for (Object s : list)
  //      comboBox.addItem (s);
  //
  //    SpringUtilities.makeCompactGrid (this, 1, 2, OFFSET, OFFSET, GAP, GAP);
  //  }

  protected void init (String labelText, String[] options)
  {
    JLabel label = setLabel (labelText);

    comboBox = new JComboBox<String> (options);
    label.setLabelFor (comboBox);
    add (comboBox);

    SpringUtilities.makeCompactGrid (this, 1, 2, OFFSET, OFFSET, GAP, GAP);
  }

  public Object getSelectedItem ()
  {
    return comboBox.getSelectedItem ();
  }

  public int getSelectedIndex ()
  {
    return comboBox.getSelectedIndex ();
  }

  public void addActionListener (ActionListener listener)
  {
    comboBox.addActionListener (listener);
  }
}