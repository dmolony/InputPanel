package com.bytezone.input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

public class TextPanel extends InputPanel implements Iterable<JTextField>
{
  private final List<JTextField> textFields = new ArrayList<JTextField> ();

  public TextPanel (String[] labels)
  {
    init (labels);
  }

  public TextPanel (String title, String[] labels)
  {
    super (title);
    init (labels);
  }

  protected void init (String[] labels)
  {
    for (int i = 0; i < labels.length; i++)
    {
      setLabel (labels[i]);
      JTextField tf = labels[i].equals ("Password") ? new JPasswordField (TEXT_LENGTH)
          : new JTextField (TEXT_LENGTH);
      textFields.add (tf);
      add (tf);
      tf.setName (labels[i]);
    }

    SpringUtilities.makeCompactGrid (this, labels.length, 2, OFFSET, OFFSET, GAP, GAP);
  }

  public void setText (int index, String text)
  {
    textFields.get (index).setText (text);
  }

  public void setText (String label, String text)
  {
    for (JTextField textField : textFields)
      if (textField.getName ().equals (label))
      {
        textField.setText (text);
        break;
      }
  }

  public String getText ()
  {
    return textFields.size () == 1 ? textFields.get (0).getText () : null;
  }

  public String getText (int index)
  {
    return textFields.get (index).getText ();
  }

  public String getText (String label)
  {
    JTextField tf = getItem (label);
    return tf == null ? null : tf.getText ();
  }

  public JTextField getItem (int index)
  {
    return textFields.get (index);
  }

  public JTextField getItem (String label)
  {
    for (JTextField textField : textFields)
      if (textField.getName ().equals (label))
        return textField;
    return null;
  }

  //  public void addActionListener (ActionListener listener)
  //  {
  //    for (JTextField field : textFields)
  //      field.addActionListener (listener);
  //  }

  public void addDocumentListener (DocumentListener listener)
  {
    for (JTextField field : textFields)
      field.getDocument ().addDocumentListener (listener);
  }

  @Override
  public Iterator<JTextField> iterator ()
  {
    return textFields.iterator ();
  }
}