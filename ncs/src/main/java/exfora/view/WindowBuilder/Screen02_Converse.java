package exfora.view.WindowBuilder;

import javax.swing.*;
import exfora.view.WindowBuilder.helper_classes.*;
import exfora.model.util.Base;
import exfora.model.util.NumberGuardian;
import java.awt.Color;

public class Screen02_Converse {
  private static Screen02_Converse instance;
  private JFrame frame;

  private Screen02_Converse() {
    frame = new JFrame("Converse Window");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(938, 550);
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.decode("#1e1e1e"));

    JLabel lblScreen02_01 = new JLabel("Please provide your number →");
    lblScreen02_01.setBounds(50, 30, 448, 45);
    lblScreen02_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    lblScreen02_01.setForeground(Color.decode("#D9D9D9"));
    panel.add(lblScreen02_01);

    JTextField inputScreen02_01 = new JTextField("");
    inputScreen02_01.setBounds(50, 80, 800, 40);
    inputScreen02_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    inputScreen02_01.setBackground(Color.decode("#B2B2B2"));
    inputScreen02_01.setForeground(Color.decode("#656565"));
    inputScreen02_01.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
    OnFocusEventHelper.setOnFocusText(inputScreen02_01, "Your Input!", Color.decode("#353535"),
        Color.decode("#656565"));
    panel.add(inputScreen02_01);

    String[] numberTypes = { "1 - Binary", "2 - Octal", "3 - Decimal", "4 - Hexadecimal" };
    JComboBox<String> cmdScreen02_01 = new JComboBox<>(numberTypes);
    cmdScreen02_01.setSelectedItem("Select the type of number");
    cmdScreen02_01.setBounds(500, 30, 350, 45);
    cmdScreen02_01.setBackground(Color.decode("#2e2e2e"));
    cmdScreen02_01.setForeground(Color.decode("#D9D9D9"));
    cmdScreen02_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 20));
    cmdScreen02_01.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
    panel.add(cmdScreen02_01);

    JLabel lblScreen02_02 = new JLabel("Hexadecimal");
    lblScreen02_02.setBounds(50, 150, 176, 44);
    lblScreen02_02.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    lblScreen02_02.setForeground(Color.decode("#D9D9D9"));
    panel.add(lblScreen02_02);

    JLabel lblScreen02_03 = new JLabel("Decimal");
    lblScreen02_03.setBounds(50, 220, 160, 40);
    lblScreen02_03.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    lblScreen02_03.setForeground(Color.decode("#D9D9D9"));
    panel.add(lblScreen02_03);

    JLabel lblScreen02_04 = new JLabel("Octal");
    lblScreen02_04.setBounds(50, 290, 114, 39);
    lblScreen02_04.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    lblScreen02_04.setForeground(Color.decode("#D9D9D9"));
    panel.add(lblScreen02_04);

    JLabel lblScreen02_05 = new JLabel("Binary");
    lblScreen02_05.setBounds(50, 360, 138, 45);
    lblScreen02_05.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    lblScreen02_05.setForeground(Color.decode("#D9D9D9"));
    panel.add(lblScreen02_05);

    JTextField rsltScreen02_01 = new JTextField("number");
    rsltScreen02_01.setBounds(250, 150, 600, 40);
    rsltScreen02_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    rsltScreen02_01.setBackground(Color.decode("#B2B2B2"));
    rsltScreen02_01.setForeground(Color.decode("#656565"));
    rsltScreen02_01.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
    rsltScreen02_01.setEditable(false);
    panel.add(rsltScreen02_01);

    JTextField rsltScreen02_02 = new JTextField("number");
    rsltScreen02_02.setBounds(250, 220, 600, 40);
    rsltScreen02_02.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    rsltScreen02_02.setBackground(Color.decode("#B2B2B2"));
    rsltScreen02_02.setForeground(Color.decode("#656565"));
    rsltScreen02_02.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
    rsltScreen02_02.setEditable(false);
    panel.add(rsltScreen02_02);

    JTextField rsltScreen02_03 = new JTextField("number");
    rsltScreen02_03.setBounds(250, 290, 600, 40);
    rsltScreen02_03.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    rsltScreen02_03.setBackground(Color.decode("#B2B2B2"));
    rsltScreen02_03.setForeground(Color.decode("#656565"));
    rsltScreen02_03.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
    rsltScreen02_03.setEditable(false);
    panel.add(rsltScreen02_03);

    JTextField rsltScreen02_04 = new JTextField("number");
    rsltScreen02_04.setBounds(250, 360, 600, 40);
    rsltScreen02_04.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    rsltScreen02_04.setBackground(Color.decode("#B2B2B2"));
    rsltScreen02_04.setForeground(Color.decode("#656565"));
    rsltScreen02_04.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
    rsltScreen02_04.setEditable(false);
    panel.add(rsltScreen02_04);

    JButton cmdScreen02_02 = new JButton("←");
    cmdScreen02_02.setBounds(10, 420, 902, 40);
    cmdScreen02_02.setBackground(Color.decode("#2e2e2e"));
    cmdScreen02_02.setForeground(Color.decode("#D9D9D9"));
    cmdScreen02_02.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    cmdScreen02_02.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
    cmdScreen02_02.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(cmdScreen02_02, Color.decode("#232323"), Color.decode("#2e2e2e"));
    cmdScreen02_02.addActionListener(_ -> {
      Screen02_Converse.getInstance().close();
      Screen01_Init.getInstance().open();
    });
    panel.add(cmdScreen02_02);

    inputScreen02_01.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
      public void changedUpdate(javax.swing.event.DocumentEvent e) {
      updateResults();
      }

      public void removeUpdate(javax.swing.event.DocumentEvent e) {
      updateResults();
      }

      public void insertUpdate(javax.swing.event.DocumentEvent e) {
      updateResults();
      }

      public void updateResults() {
      String input = inputScreen02_01.getText();
      if (input == null || input.isEmpty()) {
        return;
      }
      System.out.println(input);
      Base selectedBase = switch (cmdScreen02_01.getSelectedIndex()) {
        case 0 -> Base.BINARY;
        case 1 -> Base.OCTAL;
        case 2 -> Base.DECIMAL;
        case 3 -> Base.HEXADECIMAL;
        default -> throw new IllegalArgumentException("Invalid base selected");
      };

      rsltScreen02_01.setText(NumberGuardian.passConverse(selectedBase, Base.HEXADECIMAL, input));
      rsltScreen02_02.setText(NumberGuardian.passConverse(selectedBase, Base.DECIMAL, input));
      rsltScreen02_03.setText(NumberGuardian.passConverse(selectedBase, Base.OCTAL, input));
      rsltScreen02_04.setText(NumberGuardian.passConverse(selectedBase, Base.BINARY, input));
      }
    });

    frame.add(panel);
  }

  public static Screen02_Converse getInstance() {
    if (instance == null) {
      instance = new Screen02_Converse();
    }
    return instance;
  }

  public void open() {
    frame.setVisible(true);
  }

  public void close() {
    frame.setVisible(false);
  }
}