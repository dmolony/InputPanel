package com.bytezone.input;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

// -----------------------------------------------------------------------------------//
public class TextAreaPanel extends InputPanel
// -----------------------------------------------------------------------------------//
{
  private final List<JTextArea> textFields = new ArrayList<JTextArea> ();

  // ---------------------------------------------------------------------------------//
  public TextAreaPanel (int rows)
  // ---------------------------------------------------------------------------------//
  {
    int saveWidth = LABEL_SIZE.width;
    InputPanel.setLabelWidth (0);
    init (new String[] { "" }, rows);
    InputPanel.setLabelWidth (saveWidth);
  }

  // ---------------------------------------------------------------------------------//
  public TextAreaPanel (String[] labels, int rows)
  // ---------------------------------------------------------------------------------//
  {
    init (labels, rows);
  }

  // ---------------------------------------------------------------------------------//
  public TextAreaPanel (String title, String[] labels, int rows)
  // ---------------------------------------------------------------------------------//
  {
    super (title);
    init (labels, rows);
  }

  // ---------------------------------------------------------------------------------//
  protected void init (String[] labels, int rows)
  // ---------------------------------------------------------------------------------//
  {
    Font font = new Font ("Monospaced", Font.PLAIN, 12);

    for (int i = 0; i < labels.length; i++)
    {
      setLabel (labels[i], JLabel.TOP);
      JTextArea textArea = new JTextArea (rows, TEXT_LENGTH);
      JScrollPane sp = new JScrollPane (textArea);
      sp.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      textFields.add (textArea);

      add (sp);
      textArea.setName (labels[i]);
      textArea.setFont (font);
    }

    SpringUtilities.makeCompactGrid (this, labels.length, 2, OFFSET, OFFSET, GAP, GAP);
  }

  // ---------------------------------------------------------------------------------//
  public JTextArea getItem (int index)
  // ---------------------------------------------------------------------------------//
  {
    return textFields.get (index);
  }

  // ---------------------------------------------------------------------------------//
  public JTextArea getItem (String label)
  // ---------------------------------------------------------------------------------//
  {
    for (JTextArea textArea : textFields)
      if (textArea.getName ().equals (label))
        return textArea;
    return null;
  }
}