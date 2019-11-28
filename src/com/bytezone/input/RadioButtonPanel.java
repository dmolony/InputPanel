package com.bytezone.input;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class RadioButtonPanel extends InputPanel
{
  private final List<JRadioButton> buttons = new ArrayList<JRadioButton> ();
  private final ButtonGroup buttonGroup = new ButtonGroup ();
  private final JRadioButton hiddenButton = new JRadioButton ();

  public RadioButtonPanel (String labelText, String[] options)
  {
    init (labelText, options);
  }

  public RadioButtonPanel (String title, String labelText, String[] options)
  {
    super (title);
    init (labelText, options);
  }

  public RadioButtonPanel (String[][] options)
  {
    int saveWidth = LABEL_SIZE.width;
    InputPanel.setLabelWidth (0);
    initByColumn ("", options);
    InputPanel.setLabelWidth (saveWidth);
  }

  public RadioButtonPanel (String labelText, String[][] options)
  {
    initByColumn (labelText, options);
  }

  public RadioButtonPanel (String title, String labelText, String[][] options)
  {
    super (title);
    initByColumn (labelText, options);
  }

  protected void init (String labelText, String[] options)
  {
    buttonGroup.add (hiddenButton);

    setLabel (labelText);

    for (int i = 0; i < options.length; i++)
    {
      JRadioButton button = new JRadioButton (options[i]);
      buttonGroup.add (button);
      add (button);
      buttons.add (button);
    }

    SpringUtilities.makeCompactGrid (this, 1, options.length + 1, OFFSET, OFFSET, GAP,
        GAP);
  }

  protected void initByRow (String labelText, String[][] options)
  {
    buttonGroup.add (hiddenButton);

    for (int i = 0; i < options.length; i++)
    {
      setLabel (i == 0 ? labelText : "");

      for (int j = 0; j < options[0].length; j++)
        addButton (i, j, options);
      //      {
      //        if (j < options[i].length)
      //        {
      //          JRadioButton cb = new JRadioButton (options[i][j]);
      //          add (cb);
      //          buttonGroup.add (cb);
      //          buttons.add (cb);
      //        }
      //        else
      //          add (new JLabel (""));
      //      }
    }

    SpringUtilities.makeCompactGrid (this, options.length, options[0].length + 1, OFFSET,
        OFFSET, GAP, GAP);
  }

  protected void initByColumn (String labelText, String[][] options)
  {
    buttonGroup.add (hiddenButton);

    for (int j = 0; j < options[0].length; j++)    // rows
    {
      setLabel (j == 0 ? labelText : "");

      for (int i = 0; i < options.length; i++)
        addButton (i, j, options);
      //      {
      //        if (j < options[i].length)
      //        {
      //          JRadioButton cb = new JRadioButton (options[i][j]);
      //          add (cb);
      //          buttonGroup.add (cb);
      //          buttons.add (cb);
      //        }
      //        else
      //          add (new JLabel (""));
      //      }
    }

    SpringUtilities.makeCompactGrid (this, options[0].length, options.length + 1, OFFSET,
        OFFSET, GAP, GAP);
  }

  private void addButton (int i, int j, String[][] options)
  {
    if (j < options[i].length)
    {
      JRadioButton cb = new JRadioButton (options[i][j]);
      add (cb);
      buttonGroup.add (cb);
      buttons.add (cb);
    }
    else
      add (new JLabel (""));
  }

  public void deselectAll ()
  {
    hiddenButton.setSelected (true);
  }

  public JRadioButton getIndex (int index)
  {
    return buttons.get (index);
  }

  public JRadioButton getItem (String name)
  {
    for (JRadioButton button : buttons)
      if (button.getText ().equals (name))
        return button;
    return null;
  }

  public String getSelectedText ()
  {
    for (JRadioButton button : buttons)
      if (button.isSelected ())
        return button.getText ();

    return "";
  }

  public void setSelected (String name)
  {
    for (JRadioButton button : buttons)
      if (button.getText ().equals (name))
      {
        button.setSelected (true);
        break;
      }
  }

  public void addActionListener (ActionListener listener)
  {
    for (JRadioButton button : buttons)
      button.addActionListener (listener);
  }
}