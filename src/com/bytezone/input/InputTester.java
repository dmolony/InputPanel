package com.bytezone.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

// -----------------------------------------------------------------------------------//
class InputTester extends JFrame
// -----------------------------------------------------------------------------------//
{
  // ---------------------------------------------------------------------------------//
  public InputTester ()
  // ---------------------------------------------------------------------------------//
  {
    super ("Create NATUNLD file");

    String[][] moduleTypes = { { "All", "GDA", "PDA", "LDA   " },
                               { "Program", "Subprogram", "Helproutine", "Map" },
                               { "Subroutine", "Copycode", "Text" } };

    String[] codeTypes = { "Saved", "Catalogued", "Either", "Both" };
    String[] mfOptions = { "Hercules", "Nissan" };
    String[] yesNoOptions = { "No", "Yes" };

    String[] fileNames2 = { "Source dataset", "Destination path", "Destination file" };
    String[] fileNames1 = { "Module name", "Library from", "Library to" };
    String[] buttons = { "Submit", "Cancel" };

    ComboBoxPanel connectPanel = new ComboBoxPanel ("Connect", "Mainframe", mfOptions);
    RadioButtonPanel compilePanel =
        new RadioButtonPanel ("Compile", "CATALL", yesNoOptions);
    TextPanel commandPanel = new TextPanel (fileNames1);
    CheckBoxPanel modulePanel = new CheckBoxPanel ("Module types", moduleTypes);
    RadioButtonPanel codePanel = new RadioButtonPanel ("Code type", codeTypes);
    RadioButtonPanel symbolPanel = new RadioButtonPanel ("Symbol table", yesNoOptions);
    TextPanel transferPanel = new TextPanel ("File Transfer", fileNames2);
    ButtonPanel buttonPanel = new ButtonPanel (buttons);

    List<InputPanel> windowPanel = new ArrayList<InputPanel> ();
    windowPanel.add (connectPanel);
    windowPanel.add (compilePanel);

    List<InputPanel> natunldPanel = new ArrayList<InputPanel> ();
    natunldPanel.add (commandPanel);
    natunldPanel.add (modulePanel);
    natunldPanel.add (codePanel);
    natunldPanel.add (symbolPanel);
    windowPanel.add (new ColumnPanel ("NATUNLD", natunldPanel));

    windowPanel.add (transferPanel);
    windowPanel.add (buttonPanel);

    add (new ColumnPanel (windowPanel));

    pack ();
    setLocationRelativeTo (null);
    setResizable (false);
    setDefaultCloseOperation (EXIT_ON_CLOSE);

    JButton submitButton = buttonPanel.getItem ("Submit");
    getRootPane ().setDefaultButton (submitButton);

    submitButton.addActionListener (new ActionListener ()
    {
      @Override
      public void actionPerformed (ActionEvent e)
      {
        System.exit (0);
      }
    });

    commandPanel.getItem ("Module name").setText ("PK*");
    commandPanel.getItem ("Library from").setText ("PEEK");
    transferPanel.getItem ("Source dataset").setText ("DENIS.LOADLSTR.NATUNLD");
    transferPanel.getItem ("Destination path")
        .setText ("/User/Denis/Natural files/Hercules/Peek/");
    transferPanel.getItem ("Destination file").setText ("PEEK-006.SRC");
  }

  // ---------------------------------------------------------------------------------//
  public static void main (String[] args)
  // ---------------------------------------------------------------------------------//
  {
    new InputTester ().setVisible (true);
  }
}