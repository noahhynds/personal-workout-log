package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui implements ActionListener {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private Box box;



    public Gui() {
        label();
        panel();
        button();
        frame();
        

    }

    public void frame() {
        // FRAME
        frame = new JFrame();
        frame.setTitle("My Workout Log");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setResizable(false);
        frame.setSize(700, 400);
        frame.setVisible(true);
        // frame.add(label);
        // frame.add(panel);
        // box = Box.createVerticalBox();
        box = Box.createHorizontalBox();
        box.add(button);
        frame.add(box);
        // frame.getContentPane().setBackground(Color.BLACK); change colour
    }

    public void label() {
        label = new JLabel();
        label.setText("Hi");
    }

    public void panel() {
        panel = new JPanel();
        panel.setBounds(20, 20, 20, 20);
        panel.setBackground(Color.GREEN);

    }

    public void button() {
        button = new JButton();
        button.setSize(10, 10);
        // button.setBounds(10, 10, 10, 10);
        // button.addActionListener();

    }

    public void box() {

    }

    public static void main(String[] args) {
        new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == button) {
            System.out.println("hi");
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}



// import java.awt.BorderLayout;
// import java.awt.FlowLayout;
// import java.awt.GridBagLayout;
// import java.awt.GridLayout;

// import javax.swing.*;

// public class TestingLayoutManagers {

//     private JPanel northFlowLayoutPanel;
//     private JPanel southBorderLayoutPanel;
//     private JPanel centerGridBagLayoutPanel;
//     private JPanel westBoxLayoutPanel;
//     private JPanel eastGridLayoutPanel;

//     private final JButton northButton = new JButton("North Button");
//     private final JButton southButton = new JButton("South Button");
//     private final JButton centerButton = new JButton("Center Button");
//     private final JButton eastButton = new JButton("East Button");

//     private final JButton menuButton1 = new JButton("Menu Item 1");
//     private final JButton menuButton2 = new JButton("Menu Item 2");
//     private final JButton menuButton3 = new JButton("Menu Item 3");
//     private final JButton menuButton4 = new JButton("Menu Item 4");
//     private final JButton menuButton5 = new JButton("Menu Item 5");

//     public TestingLayoutManagers() {
//         northFlowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         southBorderLayoutPanel = new JPanel(new BorderLayout());
//         centerGridBagLayoutPanel = new JPanel(new GridBagLayout());
//         eastGridLayoutPanel = new JPanel(new GridLayout(1, 1));
//         Box box = Box.createVerticalBox();
//         westBoxLayoutPanel = new JPanel();

//         northFlowLayoutPanel.add(northButton);
//         northFlowLayoutPanel.setBorder(BorderFactory.createTitledBorder("Flow Layout"));

//         southBorderLayoutPanel.add(southButton);
//         southBorderLayoutPanel.setBorder(BorderFactory.createTitledBorder("Border Layout"));

//         centerGridBagLayoutPanel.add(centerButton);
//         centerGridBagLayoutPanel.setBorder(BorderFactory.createTitledBorder("GridBag Layout"));

//         eastGridLayoutPanel.add(eastButton);
//         eastGridLayoutPanel.setBorder(BorderFactory.createTitledBorder("Grid Layout"));

//         box.add(menuButton1);
//         box.add(menuButton2);
//         box.add(menuButton3);
//         box.add(menuButton4);
//         box.add(menuButton5);
//         westBoxLayoutPanel.add(box);
//         westBoxLayoutPanel.setBorder(BorderFactory.createTitledBorder("Box Layout"));

//         JFrame frame = new JFrame("Test Layout Managers");
//         frame.setLayout(new BorderLayout());      // This is the deafault layout
//         frame.add(northFlowLayoutPanel, BorderLayout.PAGE_START);
//         frame.add(southBorderLayoutPanel, BorderLayout.PAGE_END);
//         frame.add(centerGridBagLayoutPanel, BorderLayout.CENTER);
//         frame.add(eastGridLayoutPanel, BorderLayout.LINE_END);
//         frame.add(westBoxLayoutPanel, BorderLayout.LINE_START);

//         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         frame.pack();
//         frame.setLocationRelativeTo(null);
//         frame.setVisible(true);
//         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             try {
//                 UIManager.setLookAndFeel(
//                         UIManager.getSystemLookAndFeelClassName());
//             } catch (ClassNotFoundException
//                     | InstantiationException
//                     | IllegalAccessException
//                     | UnsupportedLookAndFeelException e) {
//                 e.printStackTrace();
//             }

//             new TestingLayoutManagers();
//         });
//     }
// }