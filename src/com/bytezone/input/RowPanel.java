package com.bytezone.input;

import java.util.List;

public class RowPanel extends InputPanel
{
  public RowPanel (List<InputPanel> panels)
  {
    this (panels.toArray (new InputPanel[panels.size ()]));
  }

  public RowPanel (String title, List<InputPanel> panels)
  {
    this (title, panels.toArray (new InputPanel[panels.size ()]));
  }

  public RowPanel (InputPanel... panels)
  {
    init (panels);

    SpringUtilities.makeCompactGrid (this, 1, panels.length, OFFSET, OFFSET, GAP, GAP);
  }

  public RowPanel (String title, InputPanel... panels)
  {
    super (title);
    init (panels);

    SpringUtilities.makeCompactGrid (this, 1, panels.length, 0, 0, 0, 0);
  }

  protected void init (InputPanel[] panels)
  {
    for (InputPanel c : panels)
      add (c);
  }
}