package com.bytezone.input;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class CheckBoxPanel extends InputPanel implements Iterable<JCheckBox>
{
  private final List<JCheckBox> buttons = new ArrayList<JCheckBox> ();

  public CheckBoxPanel (String labelText, String[] options)
  {
    init (labelText, options);
  }

  public CheckBoxPanel (String title, String labelText, String[] options)
  {
    super (title);
    init (labelText, options);
  }

  public CheckBoxPanel (String labelText, String[][] options)
  {
    initByColumn (labelText, options);
  }

  public CheckBoxPanel (String title, String labelText, String[][] options)
  {
    super (title);
    initByColumn (labelText, options);
  }

  protected void init (String labelText, String[] options)
  {
    setLabel (labelText);

    for (int i = 0; i < options.length; i++)
    {
      JCheckBox cb = new JCheckBox (options[i]);
      add (cb);
      buttons.add (cb);
    }

    SpringUtilities.makeCompactGrid (this, 1, options.length + 1, OFFSET, OFFSET, GAP,
        GAP);
  }

  protected void initByRow (String labelText, String[][] options)
  {
    for (int i = 0; i < options.length; i++)
    {
      setLabel (i == 0 ? labelText : "");

      for (int j = 0; j < options[0].length; j++)
      {
        if (j < options[i].length)
        {
          JCheckBox cb = new JCheckBox (options[i][j]);
          add (cb);
          buttons.add (cb);
        }
        else
          add (new JLabel (""));
      }
    }

    SpringUtilities.makeCompactGrid (this, options.length, options[0].length + 1, OFFSET,
        OFFSET, GAP, GAP);
  }

  protected void initByColumn (String labelText, String[][] options)
  {
    for (int j = 0; j < options[0].length; j++)    // rows
    {
      setLabel (j == 0 ? labelText : "");

      for (int i = 0; i < options.length; i++)
      {
        if (j < options[i].length)
        {
          JCheckBox cb = new JCheckBox (options[i][j]);
          add (cb);
          buttons.add (cb);
        }
        else
          add (new JLabel (""));
      }
    }

    SpringUtilities.makeCompactGrid (this, options[0].length, options.length + 1, OFFSET,
        OFFSET, GAP, GAP);
  }

  public void setSelected (String name)
  {
    for (JCheckBox button : buttons)
      if (button.getText ().equals (name))
      {
        button.setSelected (true);
        break;
      }
  }

  public JCheckBox getItem (String name)
  {
    for (JCheckBox button : buttons)
      if (button.getText ().equals (name))
        return button;
    return null;
  }

  public void addActionListener (ActionListener listener)
  {
    for (JCheckBox button : buttons)
      button.addActionListener (listener);
  }

  @Override
  public Iterator<JCheckBox> iterator ()
  {
    return buttons.iterator ();
  }
}