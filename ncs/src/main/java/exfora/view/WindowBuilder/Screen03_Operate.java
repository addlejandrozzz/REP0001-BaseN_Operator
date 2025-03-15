package exfora.view.WindowBuilder;

import javax.swing.*;
import exfora.view.WindowBuilder.helper_classes.*;
import exfora.model.util.Base;
import exfora.model.util.NumberGuardian;
import exfora.model.util.Operation;
import java.awt.Color;

public class Screen03_Operate {
  private static Screen03_Operate instance;
  private JFrame frame;

  private Screen03_Operate() {
    frame = new JFrame("Operate Window");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(938, 507);
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.decode("#1e1e1e"));

    JLabel lblScreen03_01 = new JLabel("Operate your numbers");
    lblScreen03_01.setBounds(319, 56, 326, 48);
    lblScreen03_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    lblScreen03_01.setForeground(Color.decode("#D9D9D9"));
    panel.add(lblScreen03_01);

    JTextField inputScreen03_01 = new JTextField("");
    inputScreen03_01.setBounds(78, 174, 300, 40);
    inputScreen03_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    inputScreen03_01.setBackground(Color.decode("#B2B2B2"));
    inputScreen03_01.setForeground(Color.decode("#656565"));
    inputScreen03_01.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
    OnFocusEventHelper.setOnFocusText(inputScreen03_01, "X", Color.decode("#353535"), Color.decode("#656565"));
    panel.add(inputScreen03_01);

    JTextField inputScreen03_02 = new JTextField("");
    inputScreen03_02.setBounds(560, 172, 300, 40);
    inputScreen03_02.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    inputScreen03_02.setBackground(Color.decode("#B2B2B2"));
    inputScreen03_02.setForeground(Color.decode("#656565"));
    inputScreen03_02.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
    OnFocusEventHelper.setOnFocusText(inputScreen03_02, "Y", Color.decode("#353535"), Color.decode("#656565"));
    panel.add(inputScreen03_02);

    String[] operations = { "1 - Plus", "2 - Minus", "3 - Multiply", "4 - Divide" };
    JComboBox<String> cmdScreen03_01 = new JComboBox<>(operations);
    cmdScreen03_01.setSelectedItem("Select the operation");
    cmdScreen03_01.setBounds(395, 134, 150, 40);
    cmdScreen03_01.setBackground(Color.decode("#2e2e2e"));
    cmdScreen03_01.setForeground(Color.decode("#D9D9D9"));
    cmdScreen03_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 20));
    cmdScreen03_01.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
    panel.add(cmdScreen03_01);

    String[] numberTypes = { "1 - Binary", "2 - Octal", "3 - Decimal", "4 - Hexadecimal" };
    JComboBox<String> cmdScreen03_02 = new JComboBox<>(numberTypes);
    cmdScreen03_02.setSelectedItem("Select the base");
    cmdScreen03_02.setBounds(395, 184, 150, 40);
    cmdScreen03_02.setBackground(Color.decode("#2e2e2e"));
    cmdScreen03_02.setForeground(Color.decode("#D9D9D9"));
    cmdScreen03_02.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 20));
    cmdScreen03_02.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
    panel.add(cmdScreen03_02);

    JTextField resultScreen03_01 = new JTextField("");
    resultScreen03_01.setBounds(100, 303, 750, 40);
    resultScreen03_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    resultScreen03_01.setBackground(Color.decode("#B2B2B2"));
    resultScreen03_01.setForeground(Color.decode("#656565"));
    resultScreen03_01.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
    resultScreen03_01.setEditable(false);
    panel.add(resultScreen03_01);

    JButton btnOperate = new JButton("Operate");
    btnOperate.setBounds(395, 234, 150, 40);
    btnOperate.setBackground(Color.decode("#2e2e2e"));
    btnOperate.setForeground(Color.decode("#D9D9D9"));
    btnOperate.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 20));
    btnOperate.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
    btnOperate.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(btnOperate, Color.decode("#232323"), Color.decode("#2e2e2e"));
    btnOperate.addActionListener(_ -> {
      String x = inputScreen03_01.getText();
      String y = inputScreen03_02.getText();
      if (x == null || x.isEmpty() || y == null || y.isEmpty()) {
        return;
      }
      Base selectedBase = switch (cmdScreen03_02.getSelectedIndex()) {
        case 0 -> Base.BINARY;
        case 1 -> Base.OCTAL;
        case 2 -> Base.DECIMAL;
        case 3 -> Base.HEXADECIMAL;
        default -> throw new IllegalArgumentException("Invalid base selected");
      };
      Operation selectedOperation = switch (cmdScreen03_01.getSelectedIndex()) {
        case 0 -> Operation.PLUS;
        case 1 -> Operation.MINUS;
        case 2 -> Operation.MULTIPLY;
        case 3 -> Operation.DIVIDE;
        default -> throw new IllegalArgumentException("Invalid operation selected");
      };

      resultScreen03_01.setText(NumberGuardian.passOperation(selectedBase, x, y, selectedOperation));
    });
    panel.add(btnOperate);

    JButton cmdScreen02_02 = new JButton("←");
    cmdScreen02_02.setBounds(10, 420, 902, 40);
    cmdScreen02_02.setBackground(Color.decode("#2e2e2e"));
    cmdScreen02_02.setForeground(Color.decode("#D9D9D9"));
    cmdScreen02_02.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 30));
    cmdScreen02_02.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
    cmdScreen02_02.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(cmdScreen02_02, Color.decode("#232323"), Color.decode("#2e2e2e"));
    cmdScreen02_02.addActionListener(_ -> {
      Screen03_Operate.getInstance().close();
      Screen01_Init.getInstance().open();
    });
    panel.add(cmdScreen02_02);

    frame.add(panel);
  }

  public static Screen03_Operate getInstance() {
    if (instance == null) {
      instance = new Screen03_Operate();
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