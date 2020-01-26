package com.bytezone.input;

import java.awt.Dimension;

import javax.swing.JScrollPane;

// -----------------------------------------------------------------------------------//
public class ScrollPanel extends InputPanel
// -----------------------------------------------------------------------------------//
{
  JScrollPane sp;

  //  public ScrollPanel (String[] items)
  //  {
  //    init (items);
  //
  //    SpringUtilities.makeCompactGrid (this, 1, 1, OFFSET, OFFSET, GAP, GAP);
  //  }

  // ---------------------------------------------------------------------------------//
  public ScrollPanel (JScrollPane sp)
  // ---------------------------------------------------------------------------------//
  {
    this (sp, 200, 120);
  }

  // ---------------------------------------------------------------------------------//
  public ScrollPanel (JScrollPane sp, int width, int height)
  // ---------------------------------------------------------------------------------//
  {
    this.sp = sp;
    add (sp);
    sp.setPreferredSize (new Dimension (width, height));   // width, height
    sp.setMaximumSize (sp.getPreferredSize ());
    SpringUtilities.makeCompactGrid (this, 1, 1, OFFSET, OFFSET, GAP, GAP);
  }

  //  public ScrollPanel (String label, String[] items)
  //  {
  //    setLabel (label);
  //    init (items);
  //
  //    SpringUtilities.makeCompactGrid (this, 1, 2, OFFSET, OFFSET, GAP, GAP);
  //  }

  //  public ScrollPanel (String title, String label, String[] items)
  //  {
  //    super (title);
  //    setLabel (label);
  //    init (items);
  //
  //    SpringUtilities.makeCompactGrid (this, 1, 2, OFFSET, OFFSET, GAP, GAP);
  //  }

  //  private void init (String[] items)
  //  {
  //    DefaultListModel<String> lm = new DefaultListModel<> ();
  //    JList<String> list = new JList<> (lm);
  //    for (String s : items)
  //      lm.addElement (s);
  //
  //    sp = new JScrollPane (list);
  //    sp.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  //    list.setPreferredSize (new Dimension (180, 20));
  //
  //    add (sp);
  //  }
}