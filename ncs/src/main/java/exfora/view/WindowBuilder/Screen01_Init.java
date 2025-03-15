package exfora.view.WindowBuilder;
import javax.swing.*;
import exfora.view.WindowBuilder.helper_classes.*;
import java.awt.Color;

public class Screen01_Init {
  private static Screen01_Init instance;
  private JFrame frame;

  private Screen01_Init() {
    frame = new JFrame("BaseN Operator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(938, 507);
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.decode("#1e1e1e"));

    JLabel lblScreen01_01 = new JLabel("Hey there!");
    lblScreen01_01.setBounds(371, 49, 272, 75);
    lblScreen01_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 50));
    lblScreen01_01.setForeground(Color.decode("#D9D9D9"));
    panel.add(lblScreen01_01);

    JTextArea lblScreen01_02 = new JTextArea("Did you know you can do amazing things with different kinds of number systems? Try it!");
    lblScreen01_02.setBounds(19, 153, 800, 150);
    lblScreen01_02.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 25));
    lblScreen01_02.setForeground(Color.decode("#D9D9D9"));
    lblScreen01_02.setBackground(Color.decode("#1e1e1e"));
    lblScreen01_02.setLineWrap(true);
    lblScreen01_02.setWrapStyleWord(true);
    lblScreen01_02.setEditable(false);
    panel.add(lblScreen01_02);

    JButton cmdScreen01_01 = new JButton("Operate!");
    cmdScreen01_01.setBounds(554, 334, 330, 110);
    cmdScreen01_01.setBackground(Color.decode("#2e2e2e"));
    cmdScreen01_01.setForeground(Color.decode("#D9D9D9"));
    cmdScreen01_01.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 40));
    cmdScreen01_01.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
    cmdScreen01_01.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(cmdScreen01_01, Color.decode("#232323"), Color.decode("#2e2e2e"));
    panel.add(cmdScreen01_01);
    cmdScreen01_01.addActionListener(_ -> {
      Screen01_Init.getInstance().close();
      Screen03_Operate.getInstance().open();
    });

    JButton cmdScreen01_02 = new JButton("Converse");
    cmdScreen01_02.setBounds(53, 327, 330, 110);
    cmdScreen01_02.setBackground(Color.decode("#2e2e2e"));
    cmdScreen01_02.setForeground(Color.decode("#D9D9D9"));
    cmdScreen01_02.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 40));
    cmdScreen01_02.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
    cmdScreen01_02.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(cmdScreen01_02, Color.decode("#232323"), Color.decode("#2e2e2e"));
    panel.add(cmdScreen01_02);
    cmdScreen01_02.addActionListener(_ -> {
      Screen01_Init.getInstance().close();
      Screen02_Converse.getInstance().open();
    });

    frame.add(panel);
  }

  public static Screen01_Init getInstance() {
    if (instance == null) {
      instance = new Screen01_Init();
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