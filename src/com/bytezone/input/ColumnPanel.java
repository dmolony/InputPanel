package com.bytezone.input;

import java.util.List;

// -----------------------------------------------------------------------------------//
public class ColumnPanel extends InputPanel
// -----------------------------------------------------------------------------------//
{
  // ---------------------------------------------------------------------------------//
  public ColumnPanel (List<InputPanel> panels)
  // ---------------------------------------------------------------------------------//
  {
    this (panels.toArray (new InputPanel[panels.size ()]));
  }

  // ---------------------------------------------------------------------------------//
  public ColumnPanel (String title, List<InputPanel> panels)
  // ---------------------------------------------------------------------------------//
  {
    this (title, panels.toArray (new InputPanel[panels.size ()]));
  }

  // ---------------------------------------------------------------------------------//
  public ColumnPanel (InputPanel... panels)
  // ---------------------------------------------------------------------------------//
  {
    init (panels);

    SpringUtilities.makeCompactGrid (this, panels.length, 1, OFFSET, OFFSET, GAP, GAP);
  }

  // ---------------------------------------------------------------------------------//
  public ColumnPanel (String title, InputPanel... panels)
  // ---------------------------------------------------------------------------------//
  {
    super (title);
    init (panels);

    SpringUtilities.makeCompactGrid (this, panels.length, 1, 0, 0, 0, 0);
  }

  // ---------------------------------------------------------------------------------//
  protected void init (InputPanel[] panels)
  // ---------------------------------------------------------------------------------//
  {
    for (InputPanel c : panels)
      add (c);
  }
}